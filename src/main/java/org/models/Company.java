package org.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
    // @Column не обязательно так как переменная имеет то же название
    @Column(name = "id_column")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_comp;
    @Getter
    @Setter
    private String name;

}
