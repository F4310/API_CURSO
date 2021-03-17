package com.myhero.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhero.academia.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

}
