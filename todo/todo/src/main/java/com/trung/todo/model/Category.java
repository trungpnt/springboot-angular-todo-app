package com.trung.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

public class Category implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="userId")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Todo> todoList;
    
}