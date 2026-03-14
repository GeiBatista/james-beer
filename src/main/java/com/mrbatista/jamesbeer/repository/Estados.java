package com.mrbatista.jamesbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrbatista.jamesbeer.model.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long> {

}
