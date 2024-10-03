package com.example.tarea.Repositories;

import com.example.tarea.Entities.Eventos_artistas;
import com.example.tarea.Entities.eventos_artistasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Eventos_ArtistasRepository extends JpaRepository<Eventos_artistas, eventos_artistasId> {
    @Query("SELECT f FROM Eventos_artistas f WHERE f.evento.id = :eventoId ")
    List<Eventos_artistas> buscarPorEvento(@Param("eventoId") Integer  eventoId);
}
