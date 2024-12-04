package es.unex.asee.gb01.contents.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity {

    @Id
    @GeneratedValue
    private Long idSubscription;

    
    @Column(name = "idUser", nullable = false)
    private Long idUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriptionType", nullable = false)
    private SubscriptionTypeEntity subscriptionType;

    
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    // Getters y Setters

    public Long getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Long idSubscription) {
        this.idSubscription = idSubscription;
    }

    public Long getidUser() {
        return idUser;
    }

    public void setidUser(Long idUser) {
        this.idUser = idUser;
    }

    public SubscriptionTypeEntity getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionTypeEntity subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionEntity that = (SubscriptionEntity) o;
        return idSubscription == that.idSubscription &&
               idUser == that.idUser &&
               subscriptionType == that.subscriptionType &&
               startDate.equals(that.startDate) &&
               endDate.equals(that.endDate);
    }

    // @Override
    // public int hashCode() {
    //     return Object.hash(idSubscription, idUser, subscriptionType, startDate, endDate);
    // }

    @Override
    public String toString() {
        return "SubscriptionEntity{" +
               "idSubscription=" + idSubscription +
               ", idUser=" + idUser +
               ", subscriptionType=" + subscriptionType +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               '}';
    }
}
