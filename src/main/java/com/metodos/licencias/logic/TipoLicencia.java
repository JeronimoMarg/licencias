package com.metodos.licencias.logic;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name="tipodelicencias")

@Data

public class TipoLicencia {

    @Id
    @GeneratedValue
    private Long id;

    private String letraClase;
    private String descripción;
    private int edadMinima;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_costo")
    private List<Costo> costos;
}
