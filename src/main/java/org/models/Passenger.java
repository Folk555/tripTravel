package org.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Column(name = "id_psg")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPsg;
    @Getter
    @Setter
    @Column(name = "name", columnDefinition = "bpchar")
    private String name;

    @Override
    public String toString() {
        return "Passenger{" +
                "idPsg=" + idPsg +
                ", name='" + name + '\'' +
                '}';
    }
}
