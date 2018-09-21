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
import controller.MetodologiaJdbcDAO;
import model.Metodologia;

public class ApagMetodologia extends JFrame{
	
	JLabel lblTitulo = new JLabel("Informe o ID da Metodologia que você deseja apagar: ");
	
	JLabel lblID = new JLabel("ID: ");
	JComboBox cboMetodologia = new JComboBox();
	
	JButton btnApagar = new JButton("Apagar");
	
	public ApagMetodologia() {
		super("Apagar - Metodologia");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		lblTitulo.setBounds(20, 10, 320, 30);
		paine.add(lblTitulo);
		
		lblID.setBounds(20, 50, 30, 30);
		paine.add(lblID);
		cboMetodologia.setBounds(60, 50, 120, 30);
		paine.add(cboMetodologia);
		cboMetodologia.addItem("");
		
		try {
			Connection connection = JdbUtil.getConnection();
			MetodologiaJdbcDAO m = new MetodologiaJdbcDAO(connection);
			
			List<Metodologia> metodologia = m.listar();
			
			for(int i=0; i<metodologia.size(); i++) {
				cboMetodologia.addItem(metodologia.get(i).getId_metodologia());
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
					Metodologia metodologia = new Metodologia();
					metodologia.setId_metodologia(Integer.parseInt(cboMetodologia.getSelectedItem().toString()));
					
					Connection connection = JdbUtil.getConnection();
					MetodologiaJdbcDAO metodologiaJdbcDAO = new MetodologiaJdbcDAO(connection);
					
					metodologiaJdbcDAO.delete(Integer.parseInt(cboMetodologia.getSelectedItem().toString()));
					
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
		ApagMetodologia apagar = new ApagMetodologia();
		

	}

}
