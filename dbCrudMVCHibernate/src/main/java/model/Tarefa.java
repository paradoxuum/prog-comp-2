package model;

public class Tarefa {

	private Integer id_tarefa;
	private Integer id_pessoa;
	private String titulo;
	private String prazo_estimado;
	private String descricao;
	private String dt_inicio;
	private String dt_termino;
	
	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public Integer getId_tarefa() {
		return id_tarefa;
	}
	
	public void setId_tarefa(Integer id_tarefa) {
		this.id_tarefa = id_tarefa;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getPrazo_estimado() {
		return prazo_estimado;
	}
	
	public void setPrazo_estimado(String prazo_estimado) {
		this.prazo_estimado = prazo_estimado;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDt_inicio() {
		return dt_inicio;
	}
	
	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	
	public String getDt_termino() {
		return dt_termino;
	}
	
	public void setDt_termino(String dt_termino) {
		this.dt_termino = dt_termino;
	}
}
