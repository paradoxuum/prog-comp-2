package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

import controller.MetodologiaJdbcDAO;
import controller.PessoasJdbcDAO;
import controller.JdbUtil;
import model.Metodologia;
import model.Pessoas;

public class CadMetodologia extends JFrame{
		
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Metodologia: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	public CadMetodologia() {
		super("Cadastro de Metodologias");
		
		Container paine = this.getContentPane();
		this.setLayout(null);
				
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(20, 25, 100, 30);
		txtNome.setBounds(120, 25, 310, 30);
	
		paine.add(btnSalvar);
		btnSalvar.setBounds(30, 80, 390, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Metodologia metodologia = new Metodologia();
					metodologia.setMetodo_nome(txtNome.getText());
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.salvar(metodologia);
					
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
	this.setVisible(true);
	this.setSize(460, 180);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		CadMetodologia cadMetodologia = new CadMetodologia();
	}
}
