package com.cqwo.base.core.domain.users;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(nullable = false)
    private String id;


    /**
     *
     */
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(nullable = false)
    private String name = "";

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }
}
