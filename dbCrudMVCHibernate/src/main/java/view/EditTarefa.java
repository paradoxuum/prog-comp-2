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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import controller.TarefaJdbcDAO;
import model.Pessoas;
import model.Tarefa;

public class EditTarefa extends JFrame{
	
	JLabel lblID = new JLabel("ID da Tarefa: ");
	JComboBox cboTarefa = new JComboBox();
	
	JComboBox cboIDUser = new JComboBox();
	JLabel lblIDUser = new JLabel("ID do Usuário: ");
	
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
	
	JButton btnEditar = new JButton("Editar");
	
	public EditTarefa() {
		super("Editar - Tarefa");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(cboTarefa);
		paine.add(lblID);
		lblID.setBounds(20, 25, 140, 30);
		cboTarefa.setBounds(150, 25, 160, 25);
		cboTarefa.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			TarefaJdbcDAO t1 = new TarefaJdbcDAO(connection);
			
			List<Tarefa> task = t1.listar();
			
			for (int i = 0; i<task.size(); i++) {
				cboTarefa.addItem(task.get(i).getId_tarefa());
			}
		} catch (Exception e){
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
		
		paine.add(lblIDUser);
		paine.add(cboIDUser);
		lblIDUser.setBounds(20, 320, 140, 30);
		cboIDUser.setBounds(150, 325, 160, 25);
		cboIDUser.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO p1 = new PessoasJdbcDAO(connection);
			
			List<Pessoas> people = p1.listar();
			
			for(int i = 0; i < people.size(); i++) {
				cboIDUser.addItem(people.get(i).getId_pessoa());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		paine.add(btnEditar);
		btnEditar.setBounds(40, 375, 410, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Tarefa tarefa = new Tarefa();
					tarefa.setId_tarefa(Integer.parseInt(cboTarefa.getSelectedItem().toString()));
					tarefa.setId_pessoa(Integer.parseInt(cboIDUser.getSelectedItem().toString()));
					tarefa.setTitulo(txtTitulo.getText());
					tarefa.setPrazo_estimado(txtPrazoEstimado.getText());
					tarefa.setDescricao(txtDescricao.getText());
					tarefa.setDt_inicio(txtDtInicio.getText());
					tarefa.setDt_termino(txtDtTermino.getText());
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					
					tarefaJdbcDAO.update(tarefa, Integer.parseInt(cboTarefa.getSelectedItem().toString()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	
		this.setVisible(true);
		this.setSize(490, 465);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EditTarefa editar = new EditTarefa();
	}

}
