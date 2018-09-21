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
import controller.TimeJdbcDAO;
import model.Time;

public class ApagTime extends JFrame{
	
JLabel lblTitulo = new JLabel("Informe o ID do Time que você deseja apagar: ");
	
	JLabel lblID = new JLabel("ID: ");
	JComboBox cboTime = new JComboBox();
	
	JButton btnApagar = new JButton("Apagar");
	
	public ApagTime() {
		super("Apagar - Time");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
	
		lblTitulo.setBounds(20, 10, 300, 30);
		paine.add(lblTitulo);
		
		lblID.setBounds(20, 50, 30, 30);
		paine.add(lblID);
		cboTime.setBounds(60, 50, 120, 30);
		paine.add(cboTime);
		cboTime.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			TimeJdbcDAO t = new TimeJdbcDAO(connection);
			
			List<Time> time = t.listar();
			
			for (int i=0; i<time.size(); i++) {
				cboTime.addItem(time.get(i).getId_time());
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		btnApagar.setBounds(40, 100, 260, 30);
		paine.add(btnApagar);
		btnApagar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Time time = new Time();
					time.setId_time(Integer.parseInt(cboTime.getSelectedItem().toString()));
					
					Connection connection = JdbUtil.getConnection();
					TimeJdbcDAO timeJdbcDAO = new TimeJdbcDAO(connection);
					
					timeJdbcDAO.delete(Integer.parseInt(cboTime.getSelectedItem().toString()));
					
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
		ApagTime apagar = new ApagTime();
	}
}
