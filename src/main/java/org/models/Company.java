package org.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    // @Column не обязательно так как переменная имеет то же название
    @Column(name = "id_comp")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comp;
    @Getter
    @Setter
    @Column(columnDefinition = "bpchar")
    private String name;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
