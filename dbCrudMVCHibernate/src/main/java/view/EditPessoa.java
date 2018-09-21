package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;

public class EditPessoa extends JFrame{
	
	JLabel lblID = new JLabel("ID da Pessoa: ");
	JComboBox cboUsuario = new JComboBox();
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JTextField txtEmail = new JTextField();
	JLabel lblEmail = new JLabel("E-mail: ");

	JTextField txtSexo = new JTextField();
	JLabel lblSexo = new JLabel("Sexo: ");
	
	JRadioButton rbMasc = new JRadioButton("Masculino");
	JRadioButton rbFem = new JRadioButton("Feminino");
	ButtonGroup gpSexo = new ButtonGroup();
		
	JButton btnEditar = new JButton("Editar");
	
	public EditPessoa() {
		super("Editar - Pessoa");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(cboUsuario);
		paine.add(lblID);
		lblID.setBounds(30, 10, 100, 30);
		cboUsuario.setBounds(30, 40, 160, 30);
		cboUsuario.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO p1 = new PessoasJdbcDAO(connection);
			
			List<Pessoas> people = p1.listar();
			
			for(int i = 0; i < people.size(); i++) {
				cboUsuario.addItem(people.get(i).getId_pessoa());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(30, 70, 70, 30);
		txtNome.setBounds(30, 100, 270, 30);	
		
		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(30, 130, 70, 30);
		txtEmail.setBounds(30, 160, 270, 30);
		
		paine.add(lblSexo);
		lblSexo.setBounds(30, 200, 70, 30);
		
		gpSexo.add(rbMasc);
		gpSexo.add(rbFem);
		paine.add(rbMasc);
		paine.add(rbFem);
		rbMasc.setBounds(30, 220, 100, 30);
		rbFem.setBounds(130, 220, 100, 30);
					
		paine.add(btnEditar);
		btnEditar.setBounds(30, 270, 300, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					pessoas.setId_pessoa(Integer.parseInt(cboUsuario.getSelectedItem().toString()));
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
					
					Connection connection = JdbUtil.getConnection();
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					pessoasJdbcDAO.update(pessoas, Integer.parseInt(cboUsuario.getSelectedItem().toString()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(360, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		EditPessoa edP = new EditPessoa();
	}
}