package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Metodologia;

public class MetodologiaJdbcDAO {
	private Connection conn;
	
	public MetodologiaJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Metodologia c) throws SQLException{
		String sql="insert into metodologia (titulo) values ('"+c.getNome()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void delete (int a) throws SQLException{
		String sql="delete from `metodologia` where `metodologia`.`id` ="+a+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void update (int b, String string) throws SQLException{
		String sql="update `metodologia` set `nome` = '"+string+"' where `alunos`.`id` = "+b+"";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}
