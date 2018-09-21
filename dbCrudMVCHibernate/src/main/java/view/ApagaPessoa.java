package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;

public class ApagaPessoa extends JFrame{
	
	JLabel lblTitulo = new JLabel("Informe o ID da Pessoa que você deseja apagar: ");
	
	JLabel lblID = new JLabel("ID: ");
	JComboBox cboPessoa = new JComboBox();
	
	JButton btnApagar = new JButton("Apagar");
	
	public ApagaPessoa() {
		super("Apagar - Pessoa");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
	
		lblTitulo.setBounds(20, 10, 300, 30);
		paine.add(lblTitulo);
		
		lblID.setBounds(20, 50, 30, 30);
		paine.add(lblID);
		
		cboPessoa.setBounds(60, 50, 150, 30);
		paine.add(cboPessoa);
		cboPessoa.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO p = new PessoasJdbcDAO(connection);
			
			List<Pessoas> pessoa = p.listar();
			
			for(int i=0; i<pessoa.size(); i++) {
				cboPessoa.addItem(pessoa.get(i).getId_pessoa());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		btnApagar.setBounds(40, 100, 260, 30);
		paine.add(btnApagar);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setId_pessoa(Integer.parseInt(cboPessoa.getSelectedItem().toString()));
										
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);					
					
					pessoasJdbcDAO.delete(Integer.parseInt(cboPessoa.getSelectedItem().toString()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(350,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);		
	}
	
	public static void main(String[] args) {
		ApagaPessoa ap = new ApagaPessoa();

	}

}
