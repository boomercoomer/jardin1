package tn.esprit.esponline.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    //Stars
    @Column
    private int ratingStars;
    //Services
    @Column
    private int ratingServices;
    //Prices
    @Column
    private int ratingPrice;
    //ambiance
    @Column
    private int ratingAmbiance;

    @ManyToOne(cascade=CascadeType.ALL)
    private Jardin_enfant jardin_enfant;


    public Jardin_enfant getComment() {
        return jardin_enfant;
    }

    public void setComment(Comment comment) {
        this.jardin_enfant = jardin_enfant;
    }

    public Rating(int ratingStars, int ratingServices, int ratingPrice, int ratingAmbiance) {
        super();
        this.ratingStars = ratingStars;
        this.ratingServices = ratingServices;
        this.ratingPrice = ratingPrice;
        this.ratingAmbiance = ratingAmbiance;
    }
    public Rating() {
        super();
        this.ratingStars = 5;
        this.ratingServices = 5;
        this.ratingPrice = 5;
        this.ratingAmbiance = 5;
    }
    public Rating(long id,int ratingStars, int ratingServices, int ratingPrice, int ratingAmbiance) {
        super();
        this.id=id;
        this.ratingStars = ratingStars;
        this.ratingServices = ratingServices;
        this.ratingPrice = ratingPrice;
        this.ratingAmbiance = ratingAmbiance;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }

    public int getRatingServices() {
        return ratingServices;
    }

    public void setRatingServices(int ratingServices) {
        this.ratingServices = ratingServices;
    }

    public int getRatingPrice() {
        return ratingPrice;
    }

    public void setRatingPrice(int ratingPrice) {
        this.ratingPrice = ratingPrice;
    }

    public int getRatingAmbiance() {
        return ratingAmbiance;
    }

    public void setRatingAmbiance(int ratingAmbiance) {
        this.ratingAmbiance = ratingAmbiance;
    }
}
