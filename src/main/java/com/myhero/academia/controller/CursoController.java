package com.myhero.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhero.academia.dto.CursoDto;
import com.myhero.academia.entity.CursoEntity;
import com.myhero.academia.repository.CursoRepository;

@RestController
@RequestMapping(value = "/myhero")

public class CursoController {
	
	@Autowired
	CursoRepository repository;
	
	
	@GetMapping(value = "/consulta")
	public ResponseEntity<?>findAllCurso(){
		
		List<CursoEntity> listacursos = repository.findAll();
		
		return ResponseEntity.ok(listacursos);
		
	}
	
	
	@PostMapping(path = "/reg_curso", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> AddCurso(@RequestBody CursoDto dto){
		
		CursoEntity request  = new CursoEntity(dto.getNome(),dto.getSigla());
		CursoEntity response = repository.save(request);
		
		return ResponseEntity.ok(response);
		
	}
	
}
