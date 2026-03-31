package com.mrbatista.jamesbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mrbatista.jamesbeer.model.Grupo;

@Service
public interface Grupos extends JpaRepository<Grupo, Long> {

}
