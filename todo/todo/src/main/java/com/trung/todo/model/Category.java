package com.trung.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="userId")
    @JsonIgnore
    //mappedBy the user field inside User model class remember?
    private User user;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Todo> todoList;

}