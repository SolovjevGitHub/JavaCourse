package com.intellisoft.autopartsstore.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "car_makes")

public class CarMake implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = CarModel.class, mappedBy = "carMake")
    private List<CarModel> carModels = new ArrayList<CarModel>();

    //Constructors
    public CarMake() {
    }

    public CarMake(String name) {
        this.name = name;
    }

    public CarMake(String name, List<CarModel> carModels) {
        this.name = name;
        this.carModels = carModels;
    }

    public List<CarModel> getCarModels() {
        return carModels;
    }

    public void setCarModels(List<CarModel> carModels) {
        this.carModels = carModels;
    }

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
