package model;

public class Pessoas {

	private Integer id_pessoa;
	private String nome;
	private String email;
	private String sexo;
	
	public Integer getId() {
		return id_pessoa;
	}
	public void setId(Integer id) {
		this.id_pessoa = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
