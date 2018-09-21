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
import controller.TarefaJdbcDAO;
import controller.TimeJdbcDAO;
import model.Pessoas;
import model.Tarefa;
import model.Time;

public class EditTime extends JFrame{
	
	
	JComboBox cboTime = new JComboBox();
	JLabel lblID = new JLabel("ID do Time: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome do Time: ");
	
	JComboBox cboIdPessoa = new JComboBox();
	JLabel lblIdPesooa = new JLabel("ID do Usuário: ");
	
	JButton btnEditar = new JButton("Editar");	
	
	public EditTime() {
		super("Editar - Time");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblID);
		paine.add(cboTime);	
		lblID.setBounds(35, 25, 70, 30);
		cboTime.setBounds(150, 30, 160, 25);
		cboTime.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			TimeJdbcDAO time1 = new TimeJdbcDAO(connection);
			
			List<Time> team = time1.listar();
			
			for (int i = 0; i<team.size(); i++) {
				cboTime.addItem(team.get(i).getId_time());
			}
			
		} catch(Exception e) {
			
		}
		
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(35, 95, 140, 30);
		txtNome.setBounds(150, 95, 310, 30);
		
		paine.add(lblIdPesooa);
		paine.add(cboIdPessoa);	
		lblIdPesooa.setBounds(35, 60, 140, 30);
		cboIdPessoa.setBounds(150, 60, 160, 25);
		cboIdPessoa.addItem("");;
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO p1 = new PessoasJdbcDAO(connection);
			
			List<Pessoas> people = p1.listar();
			
			for(int i = 0; i < people.size(); i++) {
				cboIdPessoa.addItem(people.get(i).getId_pessoa());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		paine.add(btnEditar);
		btnEditar.setBounds(45, 150, 400, 30);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setId_time(Integer.parseInt(cboTime.getSelectedItem().toString()));
					time.setNm_time(txtNome.getText());
					time.setId_pessoa(Integer.parseInt(cboIdPessoa.getSelectedItem().toString()));
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.update(time, Integer.parseInt(cboTime.getSelectedItem().toString()));
					
					dispose();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
			
		this.setVisible(true);
		this.setSize(500, 240);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		EditTime editar = new EditTime();

	}

}
