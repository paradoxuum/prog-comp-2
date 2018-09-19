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

public class ScrePessoas extends JFrame {
	
	JTextField txtNome = new JTextField();
	JLabel lblnome = new JLabel("Nome:");
	JTextField txtEmail = new JTextField();
	JLabel lblEmail = new JLabel("Email:");
	JCheckBox chMasculino = new JCheckBox("Masculino");
	JCheckBox chFeminino = new JCheckBox("Feminino");
	JLabel lblSexo = new JLabel("Sexo");
	JButton btnSalvar = new JButton("Salvar");
	
  public ScrePessoas() {
	   	
	  super("Cadastrar Pessoas");
	   
	   Container paine = this.getContentPane();
	  
	   paine.add(lblnome);
	   paine.add(txtNome);
	   lblnome.setBounds(20, 20, 80, 30);
	   txtNome.setBounds(60, 20, 250, 30);
	   
	   paine.add(lblEmail);
	   paine.add(txtEmail);
	   lblEmail.setBounds(20, 65, 80, 30);
	   txtEmail.setBounds(60, 65, 250, 30);
	   
	   paine.add(lblSexo);
	   paine.add(chMasculino);
	   paine.add(chFeminino);
	   lblSexo.setBounds(20, 110, 80, 30);
	   chMasculino.setBounds(65, 110, 120, 30);
	   chFeminino.setBounds(65, 135, 120, 30);
	   
	   paine.add(btnSalvar);
	   btnSalvar.setBounds(125, 190, 90, 65);
	  
	   btnSalvar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO PessoasJdbDAO = new PessoasJdbcDAO(connection);
			
			 Pessoas p = new Pessoas();
			 p.setNome(txtNome.getText());
			 p.setEmail(txtEmail.getText());
			 if(chMasculino.isSelected()) {
			 p.setSexo("M");
			 }else {
				 p.setSexo("F");
			 }
			 PessoasJdbDAO.salvar(p);
			
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
