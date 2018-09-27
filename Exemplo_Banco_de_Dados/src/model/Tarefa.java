package model;

public class Tarefa {
	
	private Integer id_tarefa;
	private String titulo;
	private String prazo_estimado;
	private String descricao;
	private String data_inicio;
	private String data_termino;
	
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
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_termino() {
		return data_termino;
	}
	public void setData_termino(String data_termino) {
		this.data_termino = data_termino;
	}
}
