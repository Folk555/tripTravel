package org.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Column(name = "id_psg")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPsg;
    @Getter
    @Setter
    private String name;

}
