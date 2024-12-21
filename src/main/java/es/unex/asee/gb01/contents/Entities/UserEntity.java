package es.unex.asee.gb01.contents.Entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity{
  @Id
  @GeneratedValue
  private Long idUser = null;

  private String name = null;

  private String surname = null;

  private String username = null;

  private String email = null;

  private String password = null;

  private String startDate = null;

  private String profilePicture = null;

  private String registerDate = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userprofiles")
  private List<UserProfileEntity> userProfiles = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "creditcards")
  private List<CreditCardEntity> creditCards = null;

@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userlanguage")
  private LanguageEntity language = null;

  public UserEntity( ){
    // this.name = name;
    // this.surname = surname;
    // this.username= username;
    // this.email = email;
    // this.password = password;
    
  }
  public UserEntity( String name, String surname, String username, String email, String password){
    this.name = name;
    this.surname = surname;
    this.username= username;
    this.email = email;
    this.password = password;
    
  }
  
    public String getStartDate() {
      return startDate;
    }

    public void setStartDate(String startDate) {
      this.startDate = startDate;
    }

    public String getProfilePicture() {
      return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
      this.profilePicture = profilePicture;
    }

    public String getRegisterDate() {
      return registerDate;
    }

    public void setRegisterDate(String registerDate) {
      this.registerDate = registerDate;
    }

    public List<UserProfileEntity> getUserProfiles() {
      return userProfiles;
    }

    public void setUserProfiles(List<UserProfileEntity> userProfiles) {
      this.userProfiles = userProfiles;
    }

    public List<CreditCardEntity> getCreditCards() {
      return creditCards;
    }

    public void setCreditCards(List<CreditCardEntity> creditCards) {
      this.creditCards = creditCards;
    }

    public LanguageEntity getLanguage() {
      return language;
    }

    public void setLanguage(LanguageEntity language) {
      this.language = language;
    }



  public Long getIdUser() {
    return idUser;
  }

  public void setIdUser(Long idUser) {
    this.idUser = idUser;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  


}
