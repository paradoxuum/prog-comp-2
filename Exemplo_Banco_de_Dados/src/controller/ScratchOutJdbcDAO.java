package controller;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Pessoas;
import model.Tarefa;

public class ScratchOutJdbcDAO {
	
	private Connection conn;
	
	public ScratchOutJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Pessoas c) throws SQLException {
		String sql = "insert into tb_pessoa (nome, email, sexo) values ('"+c.getNome()+"','"+c.getEmail()+"', '"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void salvar(Tarefa c) throws SQLException {
		String sql = "insert into tb_tarefa (titulo, prazo_estimado, descricao, data_inicio, data_termino) values ('"+c.getTitulo()+"','"+c.getPrazo_estimado()+"', '"+c.getDescricao()+"' , '"+c.getData_inicio()+"', '"+c.getData_termino()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void updatePessoa(Pessoas c, Integer id) throws SQLException {
		String sql = "update tb_pessoas set nome='"+c.getNome()+"', email='"+c.getEmail()+"', sexo='"+c.getSexo()+"' where id='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void updateTarefa(Tarefa c, Integer id) throws SQLException {
		String sql = "update tb_tarefa set titulo='"+c.getTitulo()+"', prazo_estimado='"+c.getPrazo_estimado()+"', descricao='"+c.getDescricao()+"' , data_inicio='"+c.getData_inicio()+"', data_termino='"+c.getData_inicio()+"' where id='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletarPessoa(int id) throws SQLException {
		String sql = "delete from tb_pessoas where tb_pessoas.id='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletarTarefa(int id) throws SQLException {
		String sql = "delete from tb_tarefa where tb_tarefa.id='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Pessoas> listar() {
		String sql = "select * from tb_pessoas";
		System.out.println(sql);
		List<Pessoas> p1 = new ArrayList<Pessoas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				System.out.println(id+" "+nome+" "+email+" "+sexo);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p1;
	}
	
	public List<Pessoas> listarPessoa() {
		String sql = "select * from tb_pessoas";
		System.out.println(sql);
		List<Pessoas> p1 = new ArrayList<Pessoas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String sexo = rs.getString("sexo");
				System.out.println(id+" "+nome+" "+email+" "+sexo);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p1;
	}
	
}
