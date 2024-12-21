package es.unex.asee.gb01.contents.Mappers;

import es.unex.asee.gb01.contents.Entities.SubscriptionTypeEntity;
import es.unex.swagger.model.SubscriptionType;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionTypeMapper {

    /**
     * Convierte un SubscriptionTypeEntity a un SubscriptionType (API Model).
     */
    public static SubscriptionType toModel(SubscriptionTypeEntity entity) {
        if (entity == null) {
            return null;
        }

        SubscriptionType model = new SubscriptionType();
        model.setIdSubscriptionType(entity.getIdSubscriptionType());
        model.setSubscriptionTypeName(entity.getSubscriptionTypeName());
        model.setQuantity(entity.getQuantity());

        return model;
    }

    /**
     * Convierte un SubscriptionType (API Model) a un SubscriptionTypeEntity.
     */
    public static SubscriptionTypeEntity toEntity(SubscriptionType model) {
        if (model == null) {
            return null;
        }

        SubscriptionTypeEntity entity = new SubscriptionTypeEntity();
        entity.setIdSubscriptionType(model.getIdSubscriptionType());
        entity.setSubscriptionTypeName(model.getSubscriptionTypeName());
        entity.setQuantity(model.getQuantity());

        return entity;
    }

    /**
     * Convierte una lista de SubscriptionTypeEntity a una lista de SubscriptionType.
     */
    public static List<SubscriptionType> toModelList(List<SubscriptionTypeEntity> entities) {
        return entities.stream()
                .map(SubscriptionTypeMapper::toModel)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de SubscriptionType a una lista de SubscriptionTypeEntity.
     */
    public static List<SubscriptionTypeEntity> toEntityList(List<SubscriptionType> models) {
        return models.stream()
                .map(SubscriptionTypeMapper::toEntity)
                .collect(Collectors.toList());
    }
}
