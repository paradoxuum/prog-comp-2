package controller;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Time;

public class TimeJdbcDAO {

private Connection conn;
	
	public TimeJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar(Time t) throws SQLException {
		String sql = "insert into tb_time (nm_time, id_pessoa) values ('"+t.getNm_time()+"', '"+t.getId_pessoa()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void update(Time t, Integer id) throws SQLException {
		String sql = "update tb_time set nm_time='"+t.getNm_time()+"', id_pessoa='"+t.getId_pessoa()+"' where id_time='"+t.getId_time()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void delete(Integer id) throws SQLException {
		String sql = "delete from tb_time where id_time='"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Time> listar(){
		String sql = "select * from tb_time";
		System.out.println(sql);
		List<Time> time = new ArrayList<Time>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
			//int id = rs.getInt("id");
				
				Time ti = new Time();
				
				ti.setId_time(rs.getInt("id_time"));
				ti.setId_pessoa(rs.getInt("id_pessoa"));
				ti.setNm_time(rs.getString("nm_time"));
				
				time.add(ti);
			}
			prepareStatement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
	}
	
}
