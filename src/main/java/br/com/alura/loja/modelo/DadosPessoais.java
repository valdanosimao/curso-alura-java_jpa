package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable //anotation que informa que é uma classe embutita, e eu posso embutir em uma entidade
public class DadosPessoais {
	
	private String nome;
	private String cpf;
	
	public DadosPessoais() {
	}
	
	public DadosPessoais(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
