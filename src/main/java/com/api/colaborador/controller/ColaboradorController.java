package com.api.colaborador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.colaborador.dto.ChefeSubordinadoDto;
import com.api.colaborador.model.Colaborador;
import com.api.colaborador.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {
	
	@Autowired
	ColaboradorService colaboradorService;
	
	@PostMapping
	public Colaborador salvarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorService.salvarColaborador(colaborador);
	}
	
	@PostMapping("/assoaciaChefe")
	public Colaborador associaChefe(@RequestBody ChefeSubordinadoDto dto) {
		return colaboradorService.associaSubordinado(dto);
	}
	
	@GetMapping("/{id}")
	public Colaborador buscarPorId(@PathVariable Long id) {
		return colaboradorService.buscarPorId(id);
	}

	@GetMapping
	public List<Colaborador> buscarTodos(){
		return colaboradorService.buscarTodos();
	}
	
}
