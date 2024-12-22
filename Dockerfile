# Usar una imagen base con JDK para compilar la aplicación
FROM maven:3.8.4-openjdk-17-slim AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar solo los archivos de configuración de Maven primero
# Esto aprovecha la caché de Docker para capas
COPY pom.xml .
COPY src ./src

# Compilar la aplicación
RUN mvn clean package -DskipTests

# Usar una imagen más ligera para la ejecución
FROM amazoncorretto:17-alpine-jdk

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]