package org.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
//import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {
    /**
     * С идентификаторами все интересно. Если убрать GeneratedValue то задавать PK
     * обязан сам пользователь, лучше через глобальный синхронизированный-волатильный генератор.
     * Либо выставить GenerationType, но при этом еще и создать его в БД для SEQUENCE или IDENTITY.
     * В противном случае генератор начнет генерировать значения с 0 каждый раз, или вовсе скажет что его(генератора) нет.
     */
    @Column(name = "id_psg", nullable = false)
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
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
