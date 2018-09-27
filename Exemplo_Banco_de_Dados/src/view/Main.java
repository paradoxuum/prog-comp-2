package view;

import java.sql.Connection;

import controller.ScratchOutJdbcDAO;
import controller.JdbUtil;
import model.Pessoas;

public class Main {

	public static void main(String[] args) {
		
		Pessoas p1 = new Pessoas();
		try {
			p1.setNome("Eduardo Lima");
			p1.setEmail("eduardo@scratchout.com.br");
			p1.setSexo("M");
			
			Connection connection = JdbUtil.getConnection();
			ScratchOutJdbcDAO scratchOutJdbcDAO = new ScratchOutJdbcDAO(connection);
			
			scratchOutJdbcDAO.salvar(p1);
			scratchOutJdbcDAO.updatePessoa(p1, 1);
			scratchOutJdbcDAO.deletarPessoa(2); //colocar número do ID
			scratchOutJdbcDAO.listarPessoa();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
