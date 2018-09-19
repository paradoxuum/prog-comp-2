package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.InfluenciadorJdbcDAO;
import controller.JdbUtil;
import controller.MetodologiaJdbcDAO;
import controller.PessoasJdbcDAO;
import controller.TarefasJdbcDAO;
import model.Pessoas;

public class ScrePessoasUPD extends JFrame {
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID:");
	JTextField txtNome = new JTextField();
	JLabel lblnome = new JLabel("Nome:");
	JTextField txtEmail = new JTextField();
	JLabel lblEmail = new JLabel("Email:");
	JButton btnAtualizar = new JButton("Atualizar");
	
  public ScrePessoasUPD() {
	   	
	  super("Atualização de Dados");
	   
	   Container paine = this.getContentPane();
	  
	   paine.add(lblID);
	   paine.add(txtID);
	   lblID.setBounds(20, 20, 80, 30);
	   txtID.setBounds(60, 20, 250, 30);
	   
	   paine.add(lblnome);
	   paine.add(txtNome);
	   lblnome.setBounds(20, 40, 80, 30);
	   txtNome.setBounds(60, 40, 250, 30);
	   
	   paine.add(lblEmail);
	   paine.add(txtEmail);
	   lblEmail.setBounds(20, 60, 80, 30);
	   txtEmail.setBounds(60, 60, 250, 30);
	   
	   
	   paine.add(btnAtualizar);
	   btnAtualizar.setBounds(125, 190, 90, 65);
	  
	   btnAtualizar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO PessoasJdbDAO = new PessoasJdbcDAO(connection);
			
			 Pessoas p = new Pessoas();
			 p.setId(Integer.parseInt(txtID.getText()));
			 p.setNome(txtNome.getText());
			 p.setEmail(txtEmail.getText());
			 PessoasJdbDAO.update(p, p);
			
			 //comando para fechar a janela depois da ação
			 dispose();
			 	
		}catch(Exception v) {
			v.printStackTrace();
		}
		
		}

		
		   
	   });
	   
	  
	  this.setLayout(null);
	  this.setSize(350, 320);
	  this.setVisible(true);
	// para não fexar todo a aplicação em cada tela devera estar escrito HIDE_On_Close ao inves de EXIT_ON_CLOSE
	  this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  
  }

}
