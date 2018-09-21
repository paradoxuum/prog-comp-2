package controller;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Pessoas;
import model.Tarefa;

public class PessoasJdbcDAO {

	private Connection conn;
	
	public PessoasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Pessoas p) throws SQLException {
		String sql = "insert into tb_pessoas (nome, email, sexo) values ('"+p.getNome()+"', '"+p.getEmail()+"', '"+p.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	//método do select
		public ResultSet select(int id) throws SQLException{
			String sql = "select id_pessoa from tb_pessoas where id_pessoa = '"+id+"'";
			System.out.println(sql);
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery(sql);
			while (rs.next()) {
				Integer id_pessoa = rs.getInt("id_pessoa");
				//Integer id_tarefa = rs.getInt("id_tarefa");
			}
			prepareStatement.close();
			
			return rs;
		}		
		
	public void update(Pessoas p, Integer id) throws SQLException {
		String sql = "update tb_pessoas set nome='"+p.getNome()+"', email='"+p.getEmail()+"', sexo='"+p.getSexo()+"' where id_pessoa='"+p.getId_pessoa()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete(Integer id) throws SQLException {
		String sql = "delete from tb_pessoas where id_pessoa='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Pessoas> listar(){
		String sql = "select * from tb_pessoas";
		System.out.println(sql);
		List<Pessoas> pessoas = new ArrayList<Pessoas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
				
				Pessoas p = new Pessoas();
				p.setId_pessoa(rs.getInt("id_pessoa"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setSexo(rs.getString("sexo"));
				
				pessoas.add(p);
				}
				prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pessoas;
	}
	
	public String[] infPessoa(Object id) throws SQLException {
		String sql = "select * from tb_pessoas where id_pessoa = '"+id+"' ";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		rs.next();
		String nome = rs.getString("nome");
		String email = rs.getString("email");
		String sexo = rs.getString("sexo");
		
		String[] inf = {nome, email, sexo};
		
		rs.close();
		prepareStatement.close();
		
		return inf;
	}
}
