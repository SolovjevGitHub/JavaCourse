package com.intellisoft.autopartsstore.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "autoparts")
public class Autopart {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "part_number")
    private String partNumber;
    @Column(name = "note")
    private String note;
    @Column(name = "quantity_sold")
    private String quantitySold;
    @Column(name = "warranty")
    private String warranty;
    @Column(name = "price")
    private Float price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autopart_brands_id")
    private AutopartBrand autopartBrand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_categories_id")
    private AutopartCategories autopartCategories;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_models_id")
    private CarModel carModel;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autoparts")
    private List<Order> orders = new ArrayList<Order>();


    public Autopart() {
    }

    public Autopart(String name, String partNumber, String note, String quantitySold, String warranty, Float price) {
        this.name = name;
        this.partNumber = partNumber;
        this.note = note;
        this.quantitySold = quantitySold;
        this.warranty = warranty;
        this.price = price;
    }

    public Autopart(String name, String partNumber, String note, String quantitySold, String warranty, Float price, AutopartBrand autopartBrand, AutopartCategories autopartCategories, CarModel carModel) {
        this.name = name;
        this.partNumber = partNumber;
        this.note = note;
        this.quantitySold = quantitySold;
        this.warranty = warranty;
        this.price = price;
        this.autopartBrand = autopartBrand;
        this.autopartCategories = autopartCategories;
        this.carModel = carModel;
    }

    public Autopart(String name, String partNumber, String note, String quantitySold, String warranty, Float price, AutopartBrand autopartBrand, AutopartCategories autopartCategories, CarModel carModel, List<Order> orders) {
        this.name = name;
        this.partNumber = partNumber;
        this.note = note;
        this.quantitySold = quantitySold;
        this.warranty = warranty;
        this.price = price;
        this.autopartBrand = autopartBrand;
        this.autopartCategories = autopartCategories;
        this.carModel = carModel;
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public AutopartBrand getAutopartBrand() {
        return autopartBrand;
    }

    public void setAutopartBrand(AutopartBrand autopartBrand) {
        this.autopartBrand = autopartBrand;
    }

    public AutopartCategories getAutopartCategories() {
        return autopartCategories;
    }

    public void setAutopartCategories(AutopartCategories autopartCategories) {
        this.autopartCategories = autopartCategories;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

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

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(String quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
