package es.unex.asee.gb01.contents.Mappers;

import es.unex.asee.gb01.contents.Entities.CreditCardEntity;
import es.unex.swagger.model.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {
    public CreditCardEntity toEntity (CreditCard creditCard) {
        CreditCardEntity entity = new CreditCardEntity();
        
        entity.setIBAN(creditCard.getIBAN());
        entity.setBank(creditCard.getBank());
        entity.setCVC(creditCard.getCVC());
        entity.setidUser(creditCard.getidUser());
        return entity;
    }

    public CreditCard toModel(CreditCardEntity creditCardEntity){
        CreditCard model = new CreditCard();
        model.setIBAN(creditCardEntity.getIBAN());
        model.setBank(creditCardEntity.getBank());
        model.setCVC(creditCardEntity.getCVC());
        model.setidUser(creditCardEntity.getidUser());
        return model;
    }

}
