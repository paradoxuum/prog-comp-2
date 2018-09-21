package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;

public class ListPessoa extends JFrame {
	
	JLabel lblIDPessoa = new JLabel("Selecione o ID da Pessoa: ");
	
	JLabel lblNome = new JLabel("Nome: ");
	JLabel lblEmail = new JLabel("E-mail: ");	
	JLabel lblSexo = new JLabel("Sexo: ");
	
	JLabel txtEmail = new JLabel("");
	JLabel txtNome = new JLabel("");
	JLabel txtSexo = new JLabel("");
	
	JComboBox<String> cboPessoas = new JComboBox<String>();
	
	public ListPessoa() {
		super("Lista dos Usuários");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblIDPessoa);
		paine.add(cboPessoas);
		lblIDPessoa.setBounds(20, 20, 150, 20);
		cboPessoas.setBounds(180, 20, 100, 25);
		cboPessoas.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO p = new PessoasJdbcDAO(connection);
			
			List<Pessoas> pessoa = p.listar();
			
			for(int i=0; i<pessoa.size(); i++) {
				cboPessoas.addItem(Integer.toString(pessoa.get(i).getId_pessoa()));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		paine.add(lblNome);
		paine.add(txtNome);		
		lblNome.setBounds(20, 40, 50, 30);
		txtNome.setBounds(80, 40, 100, 30);
				
		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(20, 75, 50, 30);
		txtEmail.setBounds(80, 75, 250, 30);
				
		paine.add(lblSexo);
		paine.add(txtSexo);
		lblSexo.setBounds(20, 110, 50, 30);
		txtSexo.setBounds(80, 110, 100, 30);
		
		cboPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retornaListPessoa(Integer.parseInt(cboPessoas.getSelectedItem().toString()));
			}

			private void retornaListPessoa(int id) {
				try {
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO p = new PessoasJdbcDAO(connection);
					
					String[] resultado = p.infPessoa(id);
					
					txtNome.setText(resultado[0]);
					txtEmail.setText(resultado[1]);
					txtSexo.setText(resultado[2]);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		/*
		public void retornaListPessoa(int id) {
			try {
				Connection connection = JdbUtil.getConnection();
				PessoasJdbcDAO p = new PessoasJdbcDAO(connection);
				
				String[] resultado = p.infPessoa(id);
				
				txtNome.setText(resultado[0]);
				txtEmail.setText(resultado[1]);
				txtSexo.setText(resultado[2]);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/	
		
		this.setVisible(true);
		this.setSize(350, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}	
	
	public static void main(String[] args) {
		ListPessoa lp = new ListPessoa();
	}

}
