package com.intellisoft.autopartsstore.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "autopart_brands")
public class AutopartBrand implements Serializable{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Autopart.class,mappedBy = "autopartBrand")
    private List<Autopart> autoparts=new ArrayList<Autopart>();


    //Constructors
    public AutopartBrand() {
    }

    public AutopartBrand(String name) {
        this.name = name;
    }

    public AutopartBrand(String name, List<Autopart> autoparts) {
        this.name = name;
        this.autoparts = autoparts;
    }

    //Getters and setters

    public List<Autopart> getAutoparts() {
        return autoparts;
    }

    public void setAutoparts(List<Autopart> autoparts) {
        this.autoparts = autoparts;
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
}
