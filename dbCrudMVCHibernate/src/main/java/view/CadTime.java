package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.TimeJdbcDAO;
import controller.JdbUtil;
import controller.PessoasJdbcDAO;
import model.Pessoas;
import model.Time;

public class CadTime extends JFrame{
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome do Time: ");

	JLabel lblIdPesooa = new JLabel("ID do Usuário: ");
	JComboBox cboUsuario = new JComboBox();

	JButton btnSalvar = new JButton("Salvar");
	
	public CadTime() {
		super("Cadastro de Times");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		paine.add(lblIdPesooa);
		paine.add(cboUsuario);	
		lblIdPesooa.setBounds(25, 20, 140, 30);
		cboUsuario.setBounds(140, 25, 310, 25);	
		
		cboUsuario.addItem("");		
		
		try {
			Connection connection = JdbUtil.getConnection();
			PessoasJdbcDAO p = new PessoasJdbcDAO(connection);
			
			List<Pessoas> people = p.listar();
			
			for(int i=0; i<people.size(); i++) {
				cboUsuario.addItem(people.get(i).getId_pessoa());			
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(25, 60, 140, 30);
		txtNome.setBounds(140, 60, 310, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(35, 115, 405, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setNm_time(txtNome.getText());
					time.setId_pessoa(Integer.parseInt(cboUsuario.getSelectedItem().toString()));
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.salvar(time);
					
					dispose();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(485, 210);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}	
	
	public static void main(String[] args) {
		CadTime cadTime = new CadTime();
	}

}
