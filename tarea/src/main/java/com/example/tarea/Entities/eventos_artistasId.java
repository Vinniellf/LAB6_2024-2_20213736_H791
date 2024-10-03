package com.example.tarea.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class eventos_artistasId implements Serializable {
    @Column(name = "eventoId", nullable = false)
    private Integer eventoId;

    @Column(name = "artistaId", nullable = false)
    private Integer artistaId;

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Integer artistaId) {
        this.artistaId = artistaId;
    }
}
