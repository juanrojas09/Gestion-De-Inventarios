package com.proyectojava.proyecto.models;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Time;
import static javax.persistence.GenerationType.*;
import java.lang.String;
import java.util.Date;
@Entity
@Table(name = "movimientos")

public class Movimientos {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name ="concepto")
    @Getter
    @Setter
    private String concepto;

    @Column(name ="monto")
    @Getter
    @Setter
    private Double monto;

    @Column(name ="fecha")
    @Getter
    @Setter
    private Date fecha;

    @Column(name ="tipo")
    @Getter
    @Setter
    private String tipo;

}
