package com.builders.builder.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	private Integer idade;

	public ClienteDto() {

	}

	public ClienteDto(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.dataNascimento = obj.getDataNascimento();
		try {
			this.setIdade(obj.getDataNascimento());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(String data) throws ParseException {

		this.idade = retornarIdade(data);
	}

	public int retornarIdade(String data) throws ParseException {
		Date atual = new Date();
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		Calendar c = Calendar.getInstance();
		Calendar catual = Calendar.getInstance();

		c.setTime(date);
		catual.setTime(atual);

		int idade = catual.get(Calendar.YEAR) - c.get(Calendar.YEAR);

		if (catual.get(Calendar.MONTH) + 1 == c.get(Calendar.MONTH) + 1) {
			if (catual.get(Calendar.DATE) + 1 >= c.get(Calendar.DATE)) {

			} else {
				idade--;
			}
		} else {
			if (catual.get(Calendar.MONTH) + 1 > c.get(Calendar.MONTH) + 1) {
			} else {
				idade--;
			}
		}
		return idade;
	}

}
