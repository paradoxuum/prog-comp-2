package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ScrePanel extends JFrame {

	//Painel principal que vai receber a barra de menu
	JDesktopPane painel = new JDesktopPane();
	
	//barra de menu que vai receber os componentes do menu
	JMenuBar barra = new JMenuBar();
	
	//Componentes da barra de menu
	JMenu menuP = new JMenu("Pessoas");
	JMenu menuT = new JMenu("Tarefas");
	JMenu menuM = new JMenu("Metodologia");
	JMenu menuI = new JMenu("Influencia");
	
	// sub itens ou sub componentes das barras
	JMenuItem cadPessoa;//ex: este item só fica visivel clicando no componente "PESSOAS" do menu, instancia menuP
	JMenuItem updPessoa;
	JMenuItem cadTarefa;
	JMenuItem updTarefa;
	JMenuItem cadMetodologia;
	JMenuItem cadInfluencia;
	
	public ScrePanel () {
		
		super("Gerenciador de Tarefas"); 
		
		Container paine = this.getContentPane();
		//adicionando a barra do menu no painel
		this.setJMenuBar(barra);
		
		//adicionando os componentes a barra do menu
		barra.add(menuP);
		barra.add(menuT);
		barra.add(menuM);
		barra.add(menuI);
		
		//adcionando os sub-componentes e a ação de abrir as suas respectivas telas
		menuP.add(cadPessoa = new JMenuItem("Cadastro"));
		menuP.add(updPessoa = new JMenuItem("Atualizar Dados"));
		cadPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ScrePessoas app = new ScrePessoas();
			}
		});
		updPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ScrePessoasUPD app = new ScrePessoasUPD();
			}
		});
		
		menuT.add(cadTarefa = new JMenuItem("Criar Tarefa"));
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreTarefas tare = new ScreTarefas();
			}
		});
		
		menuM.add(cadMetodologia = new JMenuItem("Adicionar Metodologia"));
		cadMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreMetodologia meto = new ScreMetodologia();
			}
		});
		
		menuI.add(cadInfluencia = new JMenuItem("Adicionar Influência"));
		cadInfluencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreInfluenciador inf = new ScreInfluenciador();
			}
		});
		
		
		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
	}
	
	
	
}
