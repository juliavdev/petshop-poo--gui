package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import facade.AnimalFacade;
import facade.ClienteFacade;
import model.Animal;
import model.Cliente;

public class ClientePesquisa extends JFrame {
	private static JTextField textFieldNome;
	private static JTextField textFieldAnimal;
	private static JTable table;
	private JButton btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientePesquisa frame = new ClientePesquisa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientePesquisa() {
		setBackground(new Color(192, 192, 192));
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Arial", Font.BOLD, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientePesquisa.class.getResource("/images/861569845c98777ce528b0d4190f38ea.png")));
		setTitle("Pet Shop Tio Patinhas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 516);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sobre");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ClientePesquisa.this, "Criado por Julia Vargas");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JPanel panelCabecalho = new JPanel();
		panelCabecalho.setBackground(new Color(245, 245, 245));
		panelCabecalho.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, null, null));
		
		JPanel panelFundo = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelFundo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
						.addComponent(panelCabecalho, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCabecalho, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelFundo, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
					.addGap(8))
		);
		panelFundo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelFundo.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable() {
			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};
		scrollPane.setViewportView(table);
		GridBagLayout gbl_panelCabecalho = new GridBagLayout();
		gbl_panelCabecalho.columnWidths = new int[]{739, 0};
		gbl_panelCabecalho.rowHeights = new int[]{61, 40, 0};
		gbl_panelCabecalho.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCabecalho.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelCabecalho.setLayout(gbl_panelCabecalho);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {  
					int codigo = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
					ClienteCadastro cad = new ClienteCadastro();
					cad.setLocationRelativeTo(null);
					cad.reload(codigo);
					cad.setVisible(true);
				}
			}
		});
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_panelTitulo = new GridBagConstraints();
		gbc_panelTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTitulo.anchor = GridBagConstraints.NORTH;
		gbc_panelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitulo.gridx = 0;
		gbc_panelTitulo.gridy = 0;
		panelCabecalho.add(panelTitulo, gbc_panelTitulo);
		GridBagLayout gbl_panelTitulo = new GridBagLayout();
		gbl_panelTitulo.columnWidths = new int[]{465, 86, 86, 86, 0};
		gbl_panelTitulo.rowHeights = new int[]{66, 0};
		gbl_panelTitulo.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTitulo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitulo.setLayout(gbl_panelTitulo);
		
		JLabel lblTitulo = new JLabel("Pet Shop Tio Patinhas!");
		lblTitulo.setForeground(new Color(255, 165, 0));
		lblTitulo.setBackground(new Color(245, 245, 245));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setIcon(new ImageIcon(ClientePesquisa.class.getResource("/images/861569845c98777ce528b0d4190f38ea.png")));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitulo.anchor = GridBagConstraints.WEST;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panelTitulo.add(lblTitulo, gbc_lblTitulo);
		
		JButton btnPesquisa = new JButton("");
		btnPesquisa.setToolTipText("Gerar Dados Aleat\u00F3rios");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarDadosAleatorios();
			}
		});
		btnPesquisa.setBackground(new Color(245, 245, 245));
		btnPesquisa.setIcon(new ImageIcon(ClientePesquisa.class.getResource("/images/lupa.png")));
		GridBagConstraints gbc_btnPesquisa = new GridBagConstraints();
		gbc_btnPesquisa.anchor = GridBagConstraints.EAST;
		gbc_btnPesquisa.insets = new Insets(0, 0, 0, 5);
		gbc_btnPesquisa.gridx = 1;
		gbc_btnPesquisa.gridy = 0;
		panelTitulo.add(btnPesquisa, gbc_btnPesquisa);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar cliente");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteCadastro cad = new ClienteCadastro();
				cad.setLocationRelativeTo(null);
				cad.setVisible(true);
			}
		});
		btnAdicionar.setBackground(new Color(245, 245, 245));
		btnAdicionar.setIcon(new ImageIcon(ClientePesquisa.class.getResource("/images/add.png")));
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.EAST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 2;
		gbc_btnAdicionar.gridy = 0;
		panelTitulo.add(btnAdicionar, gbc_btnAdicionar);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.setToolTipText("Deletar sele\u00E7\u00E3o");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRows().length==0){
					JOptionPane.showMessageDialog(ClientePesquisa.this, "Nenhum registro foi selecionado!");
					return;
				}

				int opcao = JOptionPane.showConfirmDialog(ClientePesquisa.this,"Deseja excluir os itens selecionados?","Atenção",JOptionPane.YES_NO_OPTION);
				if(opcao==0){
					for(int linha : table.getSelectedRows()){
						int codigo = (int) table.getModel().getValueAt(linha, 0);
						ClienteFacade.remover(codigo);
					}

					reLoadList();
					JOptionPane.showMessageDialog(ClientePesquisa.this, "Registros excluídos com sucesso!");
				}
			}
		});
		
		btnDeletar.setBackground(new Color(245, 245, 245));
		btnDeletar.setIcon(new ImageIcon(ClientePesquisa.class.getResource("/images/trash.png")));
		GridBagConstraints gbc_btnDeletar = new GridBagConstraints();
		gbc_btnDeletar.anchor = GridBagConstraints.EAST;
		gbc_btnDeletar.gridx = 3;
		gbc_btnDeletar.gridy = 0;
		panelTitulo.add(btnDeletar, gbc_btnDeletar);
		
		JPanel panel_Filtros = new JPanel();
		panel_Filtros.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_panel_Filtros = new GridBagConstraints();
		gbc_panel_Filtros.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_Filtros.gridx = 0;
		gbc_panel_Filtros.gridy = 1;
		panelCabecalho.add(panel_Filtros, gbc_panel_Filtros);
		GridBagLayout gbl_panel_Filtros = new GridBagLayout();
		gbl_panel_Filtros.columnWidths = new int[]{74, 264, 74, 264, 55, 0};
		gbl_panel_Filtros.rowHeights = new int[]{26, 0};
		gbl_panel_Filtros.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_Filtros.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_Filtros.setLayout(gbl_panel_Filtros);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_Filtros.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldNome = new JTextField();
		GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
		gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldNome.gridx = 1;
		gbc_textFieldNome.gridy = 0;
		panel_Filtros.add(textFieldNome, gbc_textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisar.doClick();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Animal:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		panel_Filtros.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldAnimal = new JTextField();
		GridBagConstraints gbc_textFieldAnimal = new GridBagConstraints();
		gbc_textFieldAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldAnimal.gridx = 3;
		gbc_textFieldAnimal.gridy = 0;
		panel_Filtros.add(textFieldAnimal, gbc_textFieldAnimal);
		textFieldAnimal.setColumns(10);
		
		JButton btnPesquisar = new JButton("Buscar");
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.anchor = GridBagConstraints.EAST;
		gbc_btnPesquisar.gridx = 4;
		gbc_btnPesquisar.gridy = 0;
		panel_Filtros.add(btnPesquisar, gbc_btnPesquisar);
		getContentPane().setLayout(groupLayout);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(getModel());
			}
		});
	}
	
	private void gerarDadosAleatorios() {
		for(int i = 0; i < 5; i++) {
			Cliente cliente = new Cliente();
			Animal animal = new Animal();
			cliente.setNome(generateString());
			animal.setNome(generateString());
			animal.setEspecie(generateString());
			cliente.setAnimal(animal);
			cliente.setEndereco(generateString());
			cliente.setTelefone(generateNumeros());
			cliente.setEmail(generateString());
			ClienteFacade.adicionar(cliente);
			AnimalFacade.adicionar(animal);
		}
		reLoadList();
	}

	public static String generateString(){
		Random rng = new Random();
		String characters = "abcdefghi";
		int length = 16;

		char[] text = new char[length];
		for (int i = 0; i < length; i++)
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		return new String(text);
	}
	
	public static String generateNumeros(){
		Random rng = new Random();
		String characters = "0123456789";
		int length = 11;

		char[] text = new char[length];
		for (int i = 0; i < length; i++)
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		return new String(text);
	}
	
	public static void reLoadList(){
		table.setModel(getModel());
	}	

	private static DefaultTableModel getModel() {     

		String[] columnNames = {"Código", "Nome", "Nome Animal", "Espécie", "Endereço", "Telefone", "Email"};  
		DefaultTableModel modelo = new DefaultTableModel(columnNames,0);  

		for(Cliente cliente : ClienteFacade.clientes) {
					
			if(filtraCliente(cliente))
				continue;

					modelo.addRow(new Object[] { 
					cliente.getCodigo(),
					cliente.getNome(),
					cliente.getAnimal().getNome(),
					cliente.getAnimal().getEspecie(),
					cliente.getEndereco(),
					cliente.getTelefone(),
					cliente.getEmail()
			} );
		}
		return modelo;
	}
	
	private static boolean filtraCliente(Cliente cliente) {

		if(textFieldNome.getText().equals("") 
				&& textFieldAnimal.getText().equals("")){
			return false;
		}

		boolean filtra = true;
		if(!textFieldNome.getText().equals("")
				&& textFieldNome.getText().equals(cliente.getNome())) {
			filtra=false;
		}
		
		if(!textFieldAnimal.getText().equals("")
				&& textFieldAnimal.getText().equals(cliente.getAnimal().getNome())) {
			filtra=false;
		}
		return filtra;
	}
}
		
		
