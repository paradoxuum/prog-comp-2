package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Influenciador;

public class InfluenciadorJdbcDAO {
	private Connection conn;
	
	public InfluenciadorJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Influenciador c) throws SQLException {
		String sql="insert into influenciador (nome) values ('"+c.getNome()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="delete from `influenciador` where `influenciador`.`id` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, String string) throws SQLException{
		String sql="update `influenciador` set `nome` = '"+string+"' where `influenciador`.`id` = "+b+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

}
