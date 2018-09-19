package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.MetodologiaJdbcDAO;
import model.Metodologia;

public class ScreMetodologia extends JFrame {


	JLabel lblNome = new JLabel("Nome");
	JTextField txtNome = new JTextField();
	JButton btnSalvar = new JButton("Salvar");
	


	public ScreMetodologia() {
	
	super("Metodologia");	
		
	Container paine = this.getContentPane();
	
	paine.add(lblNome);
	paine.add(txtNome);
	lblNome.setBounds(10, 20,40, 20);
	txtNome.setBounds(50, 20, 120, 25);
	
	paine.add(btnSalvar);
	btnSalvar.setBounds(50, 60, 80, 50);
	
	btnSalvar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
			Connection connection = JdbUtil.getConnection();
			MetodologiaJdbcDAO MetodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
			
			 Metodologia m = new Metodologia();
			 m.setNome(txtNome.getText());
			 MetodologiaJdbcDAO.salvar(m);
			 dispose();
			 	
			}catch(Exception v) {
				v.printStackTrace();
			}
		}   
	});
		
		
	this.setLayout(null);
	this.setSize(280, 200);
	this.setVisible(true);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	this.setLocationRelativeTo(null);
}
}