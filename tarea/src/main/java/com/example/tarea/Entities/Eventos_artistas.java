package com.example.tarea.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "`eventos_artistas`")
public class Eventos_artistas {

    @EmbeddedId
    private eventos_artistasId id;

    @MapsId("eventoId")
    @ManyToOne
    @JoinColumn(name = "eventoId", nullable = false)
    private Eventos evento;

    @MapsId("artistaId")
    @ManyToOne
    @JoinColumn(name = "artistaId", nullable = false)
    private Artistas artista;

    public eventos_artistasId getId() {
        return id;
    }

    public void setId(eventos_artistasId id) {
        this.id = id;
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public Artistas getArtista() {
        return artista;
    }

    public void setArtista(Artistas artista) {
        this.artista = artista;
    }
}
