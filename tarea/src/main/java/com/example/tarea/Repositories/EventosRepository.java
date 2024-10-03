package com.example.tarea.Repositories;

import com.example.tarea.Entities.Base;
import com.example.tarea.Entities.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Integer> {

    //FILTROS
    /*@Query("SELECT f FROM Flores f WHERE (:tipo = 0 OR f.tipo.id = :tipo) AND (:color = 0  OR f.color.id = :color) AND (:ocasion = 0 OR f.ocasion.id = :ocasion)")
    List<Base> findByTipoColorOcasion(@Param("tipo") Long  tipo, @Param("color") Long  color, @Param("ocasion") Long  ocasion);*/
}
