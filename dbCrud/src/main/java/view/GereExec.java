package view;

import java.sql.Connection;

import controller.InfluenciadorJdbcDAO;
import controller.MetodologiaJdbcDAO;
import controller.PessoasJdbcDAO;
import controller.TarefasJdbcDAO;
import controller.JdbUtil;
import model.Influenciador;
import model.Metodologia;
import model.Pessoas;
import model.Tarefas;

public class GereExec {

	public static void main(String[] args) {
		Pessoas p = new Pessoas();
		
		Metodologia m = new Metodologia();
		Tarefas t = new Tarefas();
		
		try {
			p.setNome("Eduardo");
			p.setEmail("eduardo@email.com");
			p.setSexo("M");
				
			m.setNome("Design Thinking");
			
			Connection connection = JdbUtil.getConnection();
			MetodologiaJdbcDAO metodologiaJdbDAO = new MetodologiaJdbcDAO(connection);
			TarefasJdbcDAO tarefasJdbDAO = new TarefasJdbcDAO(connection);
			
			
			metodologiaJdbDAO.salvar(m);
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		

	}

}
