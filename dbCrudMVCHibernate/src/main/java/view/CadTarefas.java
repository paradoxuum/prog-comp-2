package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.TarefaJdbcDAO;
import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;
import model.Tarefa;


public class CadTarefas extends JFrame {

	JLabel lblComboBox = new JLabel("Selecione o usuário: ");
	JComboBox cboUsuario = new JComboBox();
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID da Tarefa: ");
	
	JLabel lblTitulo = new JLabel("Título: ");
	JTextField txtTitulo = new JTextField();
	
	JLabel lblPrazoEstimado = new JLabel("Prazo Estimado: ");
	JTextField txtPrazoEstimado = new JTextField();
	
	JLabel lblDescricao = new JLabel("Descrição: ");
	JTextArea txtDescricao = new JTextArea();
	JScrollPane Scrollpane = new JScrollPane(txtDescricao);
	
	JLabel lblDtInicio = new JLabel("Data de Início: ");
	JTextField txtDtInicio = new JTextField();
	
	JLabel lblDtTermino = new JLabel("Data de Término: ");
	JTextField txtDtTermino = new JTextField();
	
	JButton btnSalvar = new JButton("Salvar");
	
	public CadTarefas() {
		super("Cadastro de Tarefas");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblComboBox);
		paine.add(cboUsuario);
		lblComboBox.setBounds(20, 20, 150, 30);
		cboUsuario.setBounds(150, 25, 150, 25);
		
		cboUsuario.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO pessoa1 = new PessoasJdbcDAO(connection);
			
			List<Pessoas> people = pessoa1.listar();
			
			for(int i=0; i<people.size(); i++) {
				cboUsuario.addItem(people.get(i).getId_pessoa());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		paine.add(lblTitulo);
		paine.add(txtTitulo);
		lblTitulo.setBounds(20, 60, 140, 30);
		txtTitulo.setBounds(150, 60, 310, 30);
		
		paine.add(lblPrazoEstimado);
		paine.add(txtPrazoEstimado);
		lblPrazoEstimado.setBounds(20, 95, 140, 30);
		txtPrazoEstimado.setBounds(150, 95, 310, 30);
		
		paine.add(lblDescricao);
		paine.add(Scrollpane);	
		lblDescricao.setBounds(20, 165, 140, 30);
		Scrollpane.setBounds(150, 130, 310, 115);
		
		paine.add(lblDtInicio);
		paine.add(txtDtInicio);
		lblDtInicio.setBounds(20, 250, 140, 30);
		txtDtInicio.setBounds(150, 250, 310, 30);
		
		paine.add(lblDtTermino);
		paine.add(txtDtTermino);
		lblDtTermino.setBounds(20, 285, 140, 30);
		txtDtTermino.setBounds(150, 285, 310, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(40, 345, 400, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoas pessoas = new Pessoas();
					Tarefa tarefa = new Tarefa();
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					PessoasJdbcDAO pessoasJdbcDAO = new PessoasJdbcDAO(connection);
					
					tarefa.setId_pessoa(Integer.parseInt(cboUsuario.getSelectedItem().toString()));
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
										
					tarefaJdbcDAO.salvar(tarefa);
										
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
		this.setVisible(true);
		this.setSize(490, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);		
	}

	public static void main(String[] args) {
		CadTarefas cadTarefas = new CadTarefas();
	}
}
