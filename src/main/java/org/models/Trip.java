package org.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trip")
@Data
public class Trip {
    @Column(name = "trip_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
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
    @ManyToOne
    //@JoinColumn атрибут этого объекта, который ссылается на внешний объект
    @JoinColumn(name = "id_comp")
    //Переменная куда сохраняем внешний объект
    private Company company;
    private String plane;
    @Column(name = "town_from")
    private String townFrom;
    @Column(name = "town_to")
    private String townTo;
    @Column(name = "time_out")
    private String timeOut;
    @Column(name = "time_in")
    private String timeIn;


}
