package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import facade.AnimalFacade;
import facade.ClienteFacade;
import model.Animal;
import model.Cliente;

public class ClienteCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfNomeAnimal;
	private JTextField tfEspecie;
	private JTextField tfCodigoAnimal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCadastro frame = new ClienteCadastro();
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
	public ClienteCadastro() {
		setTitle("Cadastro de Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteCadastro.class.getResource("/images/861569845c98777ce528b0d4190f38ea.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		GridBagLayout gbl_panelTitle = new GridBagLayout();
		gbl_panelTitle.columnWidths = new int[]{386, 0, 0};
		gbl_panelTitle.rowHeights = new int[]{51, 0};
		gbl_panelTitle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panelTitle);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setIcon(new ImageIcon(ClienteCadastro.class.getResource("/images/861569845c98777ce528b0d4190f38ea.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelTitle.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnSalvar = new JButton();
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
			
			
		});
		
				
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBackground(new Color(245, 245, 245));
		btnSalvar.setIcon(new ImageIcon(ClienteCadastro.class.getResource("/images/floppy-disk.png")));
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 0;
		panelTitle.add(btnSalvar, gbc_btnSalvar);
		
		JPanel panelFiltros = new JPanel();
		contentPane.add(panelFiltros, BorderLayout.CENTER);
		GridBagLayout gbl_panelFiltros = new GridBagLayout();
		gbl_panelFiltros.columnWidths = new int[]{58, 204, 58, 208, 0};
		gbl_panelFiltros.rowHeights = new int[]{35, 35, 35, 35, 35, 0};
		gbl_panelFiltros.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFiltros.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelFiltros.setLayout(gbl_panelFiltros);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panelFiltros.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfCodigo = new JTextField();
		tfCodigo.setDisabledTextColor(Color.BLACK);
		tfCodigo.setEnabled(false);
		
		GridBagConstraints gbc_tfCodigo = new GridBagConstraints();
		gbc_tfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_tfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigo.gridx = 1;
		gbc_tfCodigo.gridy = 0;
		panelFiltros.add(tfCodigo, gbc_tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblCodigoAnimal = new JLabel("C\u00F3digo Animal");
		GridBagConstraints gbc_lblCodigoAnimal = new GridBagConstraints();
		gbc_lblCodigoAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoAnimal.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoAnimal.gridx = 2;
		gbc_lblCodigoAnimal.gridy = 0;
		panelFiltros.add(lblCodigoAnimal, gbc_lblCodigoAnimal);
		
		tfCodigoAnimal = new JTextField();
		tfCodigoAnimal.setDisabledTextColor(Color.BLACK);
		tfCodigoAnimal.setEnabled(false);
		GridBagConstraints gbc_tfCodigoAnimal = new GridBagConstraints();
		gbc_tfCodigoAnimal.insets = new Insets(0, 0, 5, 0);
		gbc_tfCodigoAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigoAnimal.gridx = 3;
		gbc_tfCodigoAnimal.gridy = 0;
		panelFiltros.add(tfCodigoAnimal, gbc_tfCodigoAnimal);
		tfCodigoAnimal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panelFiltros.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.insets = new Insets(0, 0, 5, 5);
		gbc_tfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNome.gridx = 1;
		gbc_tfNome.gridy = 1;
		panelFiltros.add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nome Animal");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 1;
		panelFiltros.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		tfNomeAnimal = new JTextField();
		GridBagConstraints gbc_tfNomeAnimal = new GridBagConstraints();
		gbc_tfNomeAnimal.insets = new Insets(0, 0, 5, 0);
		gbc_tfNomeAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNomeAnimal.gridx = 3;
		gbc_tfNomeAnimal.gridy = 1;
		panelFiltros.add(tfNomeAnimal, gbc_tfNomeAnimal);
		tfNomeAnimal.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panelFiltros.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfEndereco = new JTextField();
		GridBagConstraints gbc_tfEndereco = new GridBagConstraints();
		gbc_tfEndereco.insets = new Insets(0, 0, 5, 5);
		gbc_tfEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEndereco.gridx = 1;
		gbc_tfEndereco.gridy = 2;
		panelFiltros.add(tfEndereco, gbc_tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Esp\u00E9cie");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 2;
		panelFiltros.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		tfEspecie = new JTextField();
		GridBagConstraints gbc_tfEspecie = new GridBagConstraints();
		gbc_tfEspecie.insets = new Insets(0, 0, 5, 0);
		gbc_tfEspecie.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEspecie.gridx = 3;
		gbc_tfEspecie.gridy = 2;
		panelFiltros.add(tfEspecie, gbc_tfEspecie);
		tfEspecie.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panelFiltros.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tfTelefone = new JTextField();
		GridBagConstraints gbc_tfTelefone = new GridBagConstraints();
		gbc_tfTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_tfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelefone.gridx = 1;
		gbc_tfTelefone.gridy = 3;
		panelFiltros.add(tfTelefone, gbc_tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		panelFiltros.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.insets = new Insets(0, 0, 0, 5);
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.gridx = 1;
		gbc_tfEmail.gridy = 4;
		panelFiltros.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);
	}
		
	public void reload(int codigo){

		Cliente cliente = ClienteFacade.carregar(codigo);
		if(cliente != null) {
			Animal animal = cliente.getAnimal();
			tfCodigo.setText(Integer.toString(cliente.getCodigo()));
			tfNome.setText(cliente.getNome());
			tfEndereco.setText(cliente.getEndereco());
			tfTelefone.setText(cliente.getTelefone());
			tfEmail.setText(cliente.getEmail());
			tfCodigoAnimal.setText(Integer.toString(animal.getCodigo()));
			tfNomeAnimal.setText(animal.getNome());
			tfEspecie.setText(animal.getEspecie());
		}
	}

	private void salvar() {
		 if(validaCamposObrigatorios())
			 return;
		 
		 try {
			Cliente cliente = preencheClientePeloFormulario();
			
			Animal animal = new Animal();

			if(!"".equals(tfCodigoAnimal.getText()))
				animal.setCodigo(Integer.parseInt(tfCodigoAnimal.getText()));
			
			animal.setNome(tfNomeAnimal.getText());
			animal.setEspecie(tfEspecie.getText());
			cliente.setAnimal(animal);
			
			if(tfCodigo.getText().equals("")) {
				ClienteFacade.adicionar(cliente);
				AnimalFacade.adicionar(animal);
				JOptionPane.showMessageDialog(ClienteCadastro.this, "Registro inserido com sucesso!");
			}
			else {
				ClienteFacade.alterar(cliente);
				AnimalFacade.alterar(animal);
				JOptionPane.showMessageDialog(ClienteCadastro.this,  "Registro alterado com sucesso!");
			}
			ClientePesquisa.reLoadList();
			dispose();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(ClienteCadastro.this, "Existem dados inválidos no formulário");
		}
		
	}

	private Cliente preencheClientePeloFormulario() {

		Cliente cliente = new Cliente();
		
		if(!"".equals(tfCodigo.getText()))
			cliente.setCodigo(Integer.parseInt(tfCodigo.getText()));
		
		cliente.setNome(tfNome.getText());
		cliente.setEndereco(tfEndereco.getText());
		cliente.setTelefone(tfTelefone.getText());
		cliente.setEmail(tfEmail.getText());
		return cliente;
	}

	private boolean validaCamposObrigatorios() {
		String mensagem = "";
		
		if(tfNome.getText().trim().equals(""))
			mensagem +="\nCampo 'Nome' é obrigatório;'";
		
		if(!mensagem.equals("")) {
			JOptionPane.showMessageDialog(ClienteCadastro.this, "Campos obrigatórios não preenchidos: \n"+mensagem);
			return true;
		}
		return false;
	}
}
	
