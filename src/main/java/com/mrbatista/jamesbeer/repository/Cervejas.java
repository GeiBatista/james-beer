package com.mrbatista.jamesbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrbatista.jamesbeer.model.Cerveja;
import com.mrbatista.jamesbeer.repository.helper.cerveja.CervejasQueries;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries {

}
