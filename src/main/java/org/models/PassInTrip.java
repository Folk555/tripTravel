package org.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pass_in_trip")
public class PassInTrip {
    @Id
    @ManyToOne
    @JoinColumn(name = "trip_no")
    private Trip tripNo;

    @Id
    private long date;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_psg")
    private Passenger passenger;

    @Getter @Setter
    private String place;

}
