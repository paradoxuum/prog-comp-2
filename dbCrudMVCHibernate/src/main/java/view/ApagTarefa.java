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
import controller.TarefaJdbcDAO;
import model.Tarefa;

public class ApagTarefa extends JFrame{
	
	JLabel lblTitulo = new JLabel("Informe o ID da Tarefa que você deseja apagar: ");
	
	JLabel lblID = new JLabel("ID: ");
	JComboBox cboTarefa = new JComboBox();
	
	JButton btnApagar = new JButton("Apagar");
	
	public ApagTarefa() {
		super("Apagar - Tarefa");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		lblTitulo.setBounds(20, 10, 300, 30);
		paine.add(lblTitulo);
		
		lblID.setBounds(20, 50, 30, 30);
		paine.add(lblID);
		cboTarefa.setBounds(60, 55, 120, 25);
		paine.add(cboTarefa);
		cboTarefa.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			TarefaJdbcDAO t = new TarefaJdbcDAO(connection);
			
			List<Tarefa> tarefa = t.listar();
			
			for (int i = 0; i< tarefa.size(); i++) {
				cboTarefa.addItem(tarefa.get(i).getId_tarefa());
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
					Tarefa tarefa = new Tarefa();
					tarefa.setId_tarefa(Integer.parseInt(cboTarefa.getSelectedItem().toString()));
					
					Connection connection = JdbUtil.getConnection();
					TarefaJdbcDAO tarefaJdbcDAO = new TarefaJdbcDAO(connection);
					
					tarefaJdbcDAO.delete(Integer.parseInt(cboTarefa.getSelectedItem().toString()));
							
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
		ApagTarefa apagar = new ApagTarefa();		
	}
}