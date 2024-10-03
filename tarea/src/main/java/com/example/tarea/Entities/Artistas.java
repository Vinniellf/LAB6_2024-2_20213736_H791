package com.example.tarea.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artistas")
public class Artistas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artistaId", nullable = false)
    private Integer id;

    @NotNull
    @NotBlank(message = "El numero del artista es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe estar conformado entre 2 y 100 caracteres")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @NotBlank(message = "El género musical es obligatorio")
    @Column(name = "genero", length = 50)
    private String genero;

    @NotNull
    @NotBlank(message = "El numero de telefono es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El número debe tener 9 dígitos")
    @Column(name = "telefono", length = 9)
    private String telefono;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
