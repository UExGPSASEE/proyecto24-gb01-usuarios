package es.unex.swagger;


import es.unex.asee.gb01.contents.Entities.UserEntity;
import es.unex.asee.gb01.contents.Entities.UserProfileEntity;
import es.unex.asee.gb01.contents.repositories.UserProfileRepository;
import es.unex.asee.gb01.contents.repositories.UserRepository;
import es.unex.swagger.Swagger2SpringBoot.ExitException;
import es.unex.swagger.configuration.LocalDateConverter;

import es.unex.swagger.configuration.LocalDateTimeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.Module;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("es.unex.asee.gb01.contents.repositories")
@EntityScan(basePackages = "es.unex.asee.gb01.contents.Entities")
@EnableFeignClients(basePackages = "es.unex.asee.gb01.contents.clients")
@ComponentScan(basePackages = { "es.unex.swagger", "es.unex.swagger.api" , "es.unex.swagger.configuration","es.unex.asee.gb01.contents"})

public class Swagger2SpringBoot implements CommandLineRunner {
    @Autowired UserRepository userRepository;
    @Autowired UserProfileRepository userProfileRepository;

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }
    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Configuration
    static class CustomDateConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
            registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }

    @PostConstruct
    public void init() {
        List<UserEntity> listaUsers = new ArrayList<>();
        List<UserProfileEntity> listaUserProfiles = new ArrayList<>();
        //Long id = Long.valueOf(1);
        listaUsers.add(new UserEntity("Sergio", "Martín", "semartinl", "semartinl@gmail.com", "12345"));
        listaUserProfiles.add(new UserProfileEntity(1L,"Sergio","1234"));
        listaUsers.add(new UserEntity("Perico", "Martín", "pericomartin", "perico@gmail.com", "12345"));
        listaUsers.add(new UserEntity("Pablo", "Fernández", "pafergon", "pafergon@gmail.com", "12345"));
        listaUsers.add(new UserEntity("Daniel", "Mocinha", "danielmocinha", "dmocinha@alumnos.unex.es", "12345"));
        listaUsers.add(new UserEntity("Sara", "Guillén", "sara", "sguillenl@alumnos.unex.es", "sara"));


        userRepository.saveAll(listaUsers);
        userProfileRepository.saveAll(listaUserProfiles);



        //listaUserProfiles.add(new UserProfileEntity(id,"Perico", "12345"));
        //userProfileRepository.saveAll(listaUserProfiles);
        
    }
}
