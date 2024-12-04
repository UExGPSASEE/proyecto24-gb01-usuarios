package es.unex.asee.gb01.contents.Entities;

import javax.persistence.*;

@Entity
@Table(name = "creditCards")
public class CreditCardEntity {

    @Id
    @GeneratedValue
    private Long idCard;

    // 
    @Column(name = "IBAN", nullable = false, unique = true)
    private String IBAN;
    // 
    // @ManyToOne
    // @JoinColumn(name = "idUser", nullable = false)
    // private UserEntity idUser;
    
    @Column(name = "idUser", nullable = false)
    private Long idUser;


    
    @Column(name = "CVC", nullable = false)
    private String CVC;

    
    @Column(name = "bank", nullable = false)
    private String bank;

    // Getters y Setters
    // public Long getIdCard() {
    //     return idCard;
    // }

    // public void setIdCard(Long idCard) {
    //     this.idCard = idCard;
    // }

    // public UserEntity getidUser() {
    //     return idUser;
    // }

    // public void setidUser(UserEntity idUser) {
    //     this.idUser = idUser;
    // }
    public Long getidUser() {
        return idUser;
    }

    public void setidUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     CreditCardEntity that = (CreditCardEntity) o;
    //     return Objects.equals(idUser, that.idUser) &&
    //            Objects.equals(IBAN, that.IBAN) &&
    //            Objects.equals(CVC, that.CVC) &&
    //            Objects.equals(bank, that.bank);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(idUser, IBAN, CVC, bank);
    // }

    // @Override
    // public String toString() {
    //     return "CreditCardEntity{" +
    //            "idCard=" + idCard +
    //            ", idUser=" + idUser +
    //            ", IBAN='" + IBAN + '\'' +
    //            ", CVC='" + CVC + '\'' +
    //            ", bank='" + bank + '\'' +
    //            '}';
    // }
}

