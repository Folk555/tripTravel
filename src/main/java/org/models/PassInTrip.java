package org.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pass_in_trip")
public class PassInTrip {
    @Id
    @ManyToOne
    @JoinColumn(name = "trip_no")
    private Trip tripNo;

    @Id
    @Column(columnDefinition = "timestamp")
    private LocalDateTime date;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_psg")
    @Setter @Getter
    private Passenger passenger;

    @Getter @Setter
    @Column(columnDefinition = "bpchar")
    private String place;

}
