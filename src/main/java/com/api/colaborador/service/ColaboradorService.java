package com.api.colaborador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.colaborador.dto.ChefeSubordinadoDto;
import com.api.colaborador.model.Colaborador;
import com.api.colaborador.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	public Colaborador salvarColaborador(Colaborador colaborador) {
		return 	colaboradorRepository.save(colaborador);
		
	}
	
	public Colaborador buscarPorId(Long id) {
		return colaboradorRepository.findById(id).get();
	}
	
	public java.util.List<Colaborador> buscarTodos(){
		return colaboradorRepository.findAll();
	}

	public Colaborador associaSubordinado(ChefeSubordinadoDto dto) {
		Colaborador chefe = colaboradorRepository.findById(dto.getIdChefe()).get();
		Colaborador subordinado = colaboradorRepository.findById(dto.getIdSubordinado()).get();
		subordinado.setChefe(chefe);
		return colaboradorRepository.save(subordinado);
	}
	
	
	
}
