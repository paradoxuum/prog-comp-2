package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JFrame;

import controller.PessoasJdbcDAO;
import controller.JdbUtil;
import model.Pessoas;

public class CadPessoas extends JFrame{
	
	JLabel lblTitle = new JLabel("Informe os dados do usuário: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JTextField txtEmail = new JTextField();
	JLabel lblEmail = new JLabel("E-mail: ");
	
	JRadioButton rbMasc = new JRadioButton("Masculino");
	JRadioButton rbFem = new JRadioButton("Feminino");
	ButtonGroup gpSexo = new ButtonGroup();
	
	JTextField txtSexo = new JTextField();
	JLabel lblSexo = new JLabel("Sexo: ");
	
	JButton btnSalvar = new JButton("Salvar");
	
	public CadPessoas() {
		super("Usuários");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblTitle);
		lblTitle.setBounds(70, 15, 300, 30);
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(70, 60, 70, 30);
		txtNome.setBounds(150, 60, 310, 30);	
		
		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(70, 95, 70, 30);
		txtEmail.setBounds(150, 95, 310, 30);
		
		gpSexo.add(rbMasc);
		gpSexo.add(rbFem);
		paine.add(rbMasc);
		paine.add(rbFem);
		rbMasc.setBounds(150, 130, 100, 30);
		rbFem.setBounds(260, 130, 100, 30);
		
		paine.add(lblSexo);
		lblSexo.setBounds(70, 130, 70, 30);
		
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(90, 180, 360, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setNome(txtNome.getText());
					pessoas.setEmail(txtEmail.getText());
					if (gpSexo.getSelection() != null) {
						String sexo = "";
						if(rbMasc.isSelected()) {
							pessoas.setSexo("Masculino");
						}
						else {
							pessoas.setSexo("Feminino");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos!, Pessoas");
					}
					
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					pessoasJdbcDAO.salvar(pessoas);
					
					//Fecha a janela depois da ação
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
	this.setVisible(true);
	this.setSize(540, 280);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE); //para não fechar toda a aplicação
	}		
	
	public static void main(String[] args) {
		CadPessoas cadPessoas = new CadPessoas();
	}
}
