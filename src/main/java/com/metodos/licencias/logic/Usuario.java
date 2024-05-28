package com.metodos.licencias.logic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="Usuarios")

@Data

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    //No se si agregar mas datos personales como puse en la maqueta

    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private Rol rol; //Tiene 3 roles, usuario normal, admin y superadmin, por eso no lo puse como bool.

}
