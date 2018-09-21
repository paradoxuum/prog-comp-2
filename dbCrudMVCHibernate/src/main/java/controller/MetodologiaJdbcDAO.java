package controller;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Metodologia;

public class MetodologiaJdbcDAO {
	
private Connection conn;
	
	public MetodologiaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Metodologia m) throws SQLException {
		String sql = "insert into tb_metodologia (metodo_nome) values ('"+m.getMetodo_nome()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(Metodologia m, Integer id) throws SQLException {
		String sql = "update tb_metodologia set metodo_nome='"+m.getMetodo_nome()+"' where id_metodologia='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete(Integer id) throws SQLException {
		String sql = "delete from tb_metodologia where id_metodologia='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Metodologia> listar(){
		String sql = "select * from tb_metodologia";
		System.out.println(sql);
		List<Metodologia> metodologia = new ArrayList<Metodologia>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
				
				Metodologia m = new Metodologia();
				m.setId_metodologia(rs.getInt("id_metodologia"));
				m.setMetodo_nome(rs.getString("metodo_nome"));
				
				metodologia.add(m);
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return metodologia;
	}
}
