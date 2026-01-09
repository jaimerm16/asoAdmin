package com.proyecto.asoAdmin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "socios")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "n_socio", unique = true)
    private Integer nSocio;

    @Column(unique = true)
    private String dni;

    @Enumerated(EnumType.STRING)
    @Column(name = "t_socio")
    private TipoSocio tSocio;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "recibe_notificaciones")
    private boolean recibeNotificaciones = true;
}