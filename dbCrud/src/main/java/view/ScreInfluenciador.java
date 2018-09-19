package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.InfluenciadorJdbcDAO;
import controller.JdbUtil;
import model.Influenciador;

public class ScreInfluenciador extends JFrame {
	
	
		Influenciador i = new Influenciador();
	
		JLabel lblNome = new JLabel("Nome");
		JTextField txtNome = new JTextField();
		JButton btnSalvar = new JButton("Salvar");
		
	
	
		public ScreInfluenciador() {
		
		super("Influenciador");	
			
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
				InfluenciadorJdbcDAO inlfuenciadorJdbcDAO = new InfluenciadorJdbcDAO (connection);
				i.setNome(txtNome.getText());
				inlfuenciadorJdbcDAO.salvar(i);
				}catch(Exception v){
					v.printStackTrace();					
				}
			}
		});
			
			
		this.setLayout(null);
		this.setSize(280, 200);
		this.setVisible(true);
		// para não fexar todo a aplicação em cada tela devera estar escrito HIDE_On_Close ao inves de EXIT_ON_CLOSE
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
