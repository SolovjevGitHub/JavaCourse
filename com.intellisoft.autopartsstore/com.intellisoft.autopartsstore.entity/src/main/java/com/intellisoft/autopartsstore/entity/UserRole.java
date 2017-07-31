package com.intellisoft.autopartsstore.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = User.class,mappedBy = "userRole")
    private List<User> users=new ArrayList<User>();


    //Constructors
    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }

    public UserRole(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
