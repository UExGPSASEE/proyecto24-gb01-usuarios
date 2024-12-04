package es.unex.asee.gb01.contents.Mappers;

import es.unex.asee.gb01.contents.Mappers.UserProfileMapper;
import es.unex.asee.gb01.contents.Entities.UserEntity;
import es.unex.asee.gb01.contents.Entities.UserProfileEntity;
import es.unex.swagger.model.User;
import es.unex.swagger.model.UserLogIn;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Convertir de modelo REST a entIdad JPA
    public static UserEntity toEntity(User userModel) {
        if (userModel == null) return null;

        UserEntity userEntity = new UserEntity(
                userModel.getName(),
                userModel.getSurname(),
                userModel.getUsername(),
                userModel.getEmail(),
                userModel.getPassword()
        );
        
        userEntity.setIdUser(userModel.getIdUser());
        userEntity.setStartDate(userModel.getStartDate());
        userEntity.setProfilePicture(userModel.getProfilePicture());
        userEntity.setRegisterDate(userModel.getRegisterDate());

        // Convertir profilees de user
        if (userModel.getUserProfiles() != null) {
            List<UserProfileEntity> lista = new ArrayList<>();
            for (int i = 0; i < userModel.getUserProfiles().size(); i++) {
                lista.add(UserProfileMapper.toEntity(userModel.getUserProfiles().get(i)));
            }
        }

        // Convertir cards de crédito
        if (userModel.getCreditCards() != null) {
            // userEntity.setCreditCards(
            //     userModel.getCreditCards().stream()
            //     .map(CreditCardMapper::toEntity)
            //     .collect(Collectors.toList())
            // );
        }

        // Convertir language
        if (userModel.getLanguage() != null) {
            userEntity.setLanguage(LanguageMapper.toEntity(userModel.getLanguage()));
        }

        return userEntity;
    }

    // Convertir de entIdad JPA a modelo REST
    public static User toModel(UserEntity userEntity) {
        if (userEntity == null) return null;

        User userModel = new User();
        userModel.setIdUser(userEntity.getIdUser());
        userModel.setName(userEntity.getName());
        userModel.setSurname(userEntity.getSurname());
        userModel.setUsername(userEntity.getUsername());
        userModel.setEmail(userEntity.getEmail());
        userModel.setPassword(userEntity.getPassword());
        userModel.setStartDate(userEntity.getStartDate());
        userModel.setProfilePicture(userEntity.getProfilePicture());
        userModel.setRegisterDate(userEntity.getRegisterDate());

        // Convertir language
        if (userEntity.getLanguage() != null) {
            userModel.setLanguage(LanguageMapper.toModel(userEntity.getLanguage()));
        }

        return userModel;
    }
    public static List<User> toListModel(List<UserEntity> listUserEntity) {
        if (listUserEntity.size() == 0) return null;
        List<User> listUserModel = new ArrayList<>();
        for (UserEntity userEntity : listUserEntity) {
            User userModel = new User();
            userModel.setIdUser(userEntity.getIdUser());
            userModel.setName(userEntity.getName());
            userModel.setSurname(userEntity.getSurname());
            userModel.setUsername(userEntity.getUsername());
            userModel.setEmail(userEntity.getEmail());
            userModel.setPassword(userEntity.getPassword());
            userModel.setStartDate(userEntity.getStartDate());
            userModel.setProfilePicture(userEntity.getProfilePicture());
            userModel.setRegisterDate(userEntity.getRegisterDate());
            // Convertir language
            if (userEntity.getLanguage() != null) {
                userModel.setLanguage(LanguageMapper.toModel(userEntity.getLanguage()));
            }
            listUserModel.add(userModel);
        }

        return listUserModel;
    }

    public User loginToUser (UserLogIn logIn){
        User user = new User(logIn.getUsername(), logIn.getPassword());
        return user;
    }

    public UserLogIn userToLogIn (User user){
        return new UserLogIn(user.getUsername(), user.getPassword());
    }
}

