package com.mrbatista.jamesbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrbatista.jamesbeer.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

}
