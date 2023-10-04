package com.api.colaborador.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Colaborador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	@ManyToOne
	@JoinColumn(name = "id_chefe")
	private Colaborador chefe;
	
	public Colaborador() {
		
	}
	
	
	public Colaborador(Long id, String nome, String senha, Colaborador chefe) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.chefe = chefe;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Colaborador getChefe() {
		return chefe;
	}
	public void setChefe(Colaborador chefe) {
		this.chefe = chefe;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", senha=" + senha  + ", chefe=" + chefe
				+ "]";
	}

	
	
}
