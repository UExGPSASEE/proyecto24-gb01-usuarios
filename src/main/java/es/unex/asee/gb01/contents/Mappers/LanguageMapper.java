package es.unex.asee.gb01.contents.Mappers;

import es.unex.asee.gb01.contents.Entities.LanguageEntity;
import es.unex.swagger.model.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {

    public static LanguageEntity toEntity(Language language) {

        return new LanguageEntity(language.getIdLanguage(),language.getName());
        
    }
    public static Language toModel(LanguageEntity languageEntity){
        Language model = new Language();
        model.setIdLanguage(languageEntity.getIdLanguage());
        model.setName(languageEntity.getName());
        return model;
    }

}
