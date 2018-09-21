package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class JanEditar extends JFrame{

	JLabel lblTitle = new JLabel("O que deseja editar/apagar?");
	
	JRadioButton rbPessoa = new JRadioButton("Pessoa");
	JRadioButton rbTarefa = new JRadioButton("Tarefa");
	JRadioButton rbMetodologia = new JRadioButton("Metodologia");
	JRadioButton rbTime = new JRadioButton("Time");
	
	ButtonGroup grpEditar = new ButtonGroup();
	
	JButton btnEdicao = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");
		
	public JanEditar() {
		super("Alteração de Dados");
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		grpEditar.add(rbPessoa);
		grpEditar.add(rbTarefa);
		grpEditar.add(rbMetodologia);
		grpEditar.add(rbTime);
		
		lblTitle.setBounds(10, 10, 320, 20);
		paine.add(lblTitle);	
		
		rbPessoa.setBounds(30, 40, 100, 20);
		paine.add(rbPessoa);
		
		rbTarefa.setBounds(30, 70, 100, 20);
		paine.add(rbTarefa);
		
		rbMetodologia.setBounds(140, 40, 100, 20);
		paine.add(rbMetodologia);
		
		rbTime.setBounds(140, 70, 100, 20);
		paine.add(rbTime);
		
		btnEdicao.setBounds(15, 110, 120, 35);
		paine.add(btnEdicao);
		btnEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbPessoa.isSelected()) {
					EditPessoa editar = new EditPessoa();
				}
				
				if(rbTarefa.isSelected()) {
					EditTarefa editar = new EditTarefa();
				}
				
				if(rbMetodologia.isSelected()) {
					EditMetodologia editar = new EditMetodologia();
				}

				if(rbTime.isSelected()) {
					EditTime editar = new EditTime();	
				}
				
			}
		});
		
		btnApagar.setBounds(145, 110, 120, 35);
		paine.add(btnApagar);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbPessoa.isSelected()) {
					ApagaPessoa apagar = new ApagaPessoa();
				}
				
				if(rbTarefa.isSelected()) {
					ApagTarefa apagar = new ApagTarefa();
				}
				
				if(rbMetodologia.isSelected()) {
					ApagMetodologia apagar = new ApagMetodologia();
				}
				
				if(rbTime.isSelected()) {
					ApagTime apagar = new ApagTime();
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(290, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		JanEditar janelaEditar = new JanEditar();
	}
}