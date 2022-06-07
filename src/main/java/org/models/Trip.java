package org.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
@Data
public class Trip {
    @Column(name = "trip_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Id
    private int idTrip;

    /*Связь многие к одному.
    Объект владелец может иметь поле с параметрами:
        FetchType.LAZY - связанные объекты не будут выгружаться в память,
        пока они не требуются.
        FetchType.EAGER - все связанные объекты сразу же выгрузятся в память.
     mappedBy = "имя переменной из ORM" в нашем случае было бы [company].
         применяется у владеемого (на который ссылаются) объекта,
         благодоря ему можно получить ссылающиеся объекты.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn атрибут этого объекта, который ссылается на внешний объект
    @JoinColumn(name = "id_comp")
    //Переменная куда сохраняем внешний объект
    private Company company;
    @Column(name = "plane", columnDefinition = "bpchar")
    private String plane;
    @Column(name = "town_from", columnDefinition = "bpchar")
    private String townFrom;
    @Column(name = "town_to", columnDefinition = "bpchar")
    private String townTo;
    @Column(name = "time_out", columnDefinition = "timestamp")
    private LocalDateTime timeOut;
    @Column(name = "time_in", columnDefinition = "timestamp")
    private LocalDateTime timeIn;

    @Override
    public String toString() {
        return "Trip{" +
                "idTrip=" + idTrip +
                "comp=" + company +
                ", plane='" + plane + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut=" + timeOut +
                ", timeIn=" + timeIn +
                '}';
    }
}
