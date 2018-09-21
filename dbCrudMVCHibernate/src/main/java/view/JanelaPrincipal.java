package view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JanelaPrincipal extends JFrame {
	
	//Janela que recebe a barra de menu e abre as outras janelas dentro
	JDesktopPane jdPane = new JDesktopPane();
	
	//Barra do menu
	JMenuBar barra = new JMenuBar();
	
	//Componentes da barra
	JMenu menuPessoas = new JMenu("Pessoas");
	JMenu menuTarefas = new JMenu("Tarefas");//exibe a lista de tarefas
	JMenu menuMetodologia = new JMenu("Metodologias");//exibe a lista de metodologias
	JMenu menuTime = new JMenu("Times");//exibe a lista de times
	JMenu menuEditarApagar = new JMenu("Editar/Apagar");
	
	//Itens dos componentes	
	JMenuItem cadPessoa = new JMenuItem("Cadastrar Usuários");//cadastra pessoa
	JMenuItem listPessoas = new JMenuItem("Lista de Usuários");//exibe a lista de pessoas
	
	JMenuItem cadTarefa = new JMenuItem("Inserir Tarefa");
	//JMenuItem listTarefas = new JMenuItem("Lista de Tarefas");
	
	JMenuItem cadMetodologia = new JMenuItem("Inserir Metodologia");
	//JMenuItem listMetodologias = new JMenuItem("Lista de Metodologias");
	
	JMenuItem cadTime = new JMenuItem("Entrar em um Time");
	//JMenuItem listTimes = new JMenuItem("Lista de Times");
	
	JMenuItem editar = new JMenuItem("Alteração");
	
	public JanelaPrincipal() {	
		super ("Scratch Out - Gerenciador de Tarefas");
		
		getContentPane().add(jdPane);
		
		Container paine = this.getContentPane();
		this.setJMenuBar(barra);
		
		barra.add(menuPessoas);
		barra.add(menuTarefas);
		barra.add(menuMetodologia);
		barra.add(menuTime);
		barra.add(menuEditarApagar);
						
		menuPessoas.add(cadPessoa);
		cadPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instância da janela que abre o cadastro das pessoas;
				CadPessoas cadPessoas = new CadPessoas();
			}
		});
		
		menuTarefas.add(cadTarefa);
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de tarefas
				CadTarefas cadTarefas = new CadTarefas();
			}
		});
		
		menuMetodologia.add(cadMetodologia);
		cadMetodologia.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de metodologias
				CadMetodologia cadMetodologia = new CadMetodologia();
			}
		});
		
		menuTime.add(cadTime);
		cadTime.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//instancia da janela de Times
				CadTime cadTime = new CadTime();
			}
		});
		
		menuEditarApagar.add(editar);
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanEditar edit = new JanEditar();
			}
		});
				
		menuPessoas.add(listPessoas);
		listPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPessoa lp = new ListPessoa();
			}
		});
			
		/*
		menuTarefas.add(listTarefas);
		listTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de tarefas
			}
		});
		*/
						
		/*
		menuMetodologia.add(listMetodologias);
		listMetodologias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de metodologias
			}
		});
		*/
				
		/*
		menuTime.add(listTimes);
		listTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instancia a janela da lista de times
			}
		});
		*/
				
		this.setVisible(true);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		JanelaPrincipal jp = new JanelaPrincipal();		
	}
}
