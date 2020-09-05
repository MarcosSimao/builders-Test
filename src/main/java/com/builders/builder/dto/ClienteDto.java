package com.builders.builder.dto;

import java.io.Serializable;

import com.builders.builder.domain.Cliente;

public class ClienteDto implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String id;
  private String nome;
  private String cpf;
  private String dataNascimento;
  
  public ClienteDto() {
	  
  }
	public ClienteDto(Cliente obj) {
	this.id=obj.getId();
	this.nome=obj.getNome();
	this.cpf=obj.getCpf();
	this.dataNascimento=obj.getDataNascimento();
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
