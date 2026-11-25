package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cadastro.Cliente;
import Cadastro.Servico;
import CadastroSQL.ClienteCadastroSQL;
import CadastroSQL.ServicoSQL;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.TextField;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class CadastroGUI extends JFrame {

	private JPanel contentPane;
	private JTextField inserirNome;
	private JTextField inserirCPF;
	private JTextField inserirDataNsc;
	private JTextField inserirTelefone;
	private JTextField inserirEmail;
	private JTextField inserirEndereco;
	private JTextField inserirData;
	private JTextField inserirHora;
	private JTextField inserirNomeServico;
	
	ClienteCadastroSQL cadastro = new ClienteCadastroSQL();
	ServicoSQL inserindoAtendimentos = new ServicoSQL();
	
	Servico atendimento1 = new Servico();
	Cliente novoCliente = new Cliente();
	
	private JTextField inserirFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroGUI frame = new CadastroGUI();
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
	public CadastroGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		  JLabel tituloCadastro = new JLabel("CADASTRO DE CLIENTES");
		  tituloCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		  tituloCadastro.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		  tituloCadastro.setBounds(165, 11, 396, 42); contentPane.add(tituloCadastro);
		  
		  JLabel lblcpf = new JLabel("CPF: "); lblcpf.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblcpf.setBounds(20, 121, 75, 24);
		  contentPane.add(lblcpf);
		  
		  JLabel lblnome = new JLabel("Nome: "); lblnome.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblnome.setBounds(20, 79, 75, 24);
		  contentPane.add(lblnome);
		  
		  inserirNome = new JTextField(); inserirNome.setBounds(87, 80, 455, 29);
		  contentPane.add(inserirNome); inserirNome.setColumns(10);
		  
		  inserirCPF = new JTextField(); inserirCPF.setColumns(10);
		  inserirCPF.setBounds(84, 122, 248, 29); contentPane.add(inserirCPF);
		  
		  JLabel lbldataNasc = new JLabel("Data Nascimento: "); lbldataNasc.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lbldataNasc.setBounds(351, 121,
		  166, 24); contentPane.add(lbldataNasc);
		  
		  inserirDataNsc = new JTextField(); inserirDataNsc.setColumns(10);
		  inserirDataNsc.setBounds(500, 122, 192, 29); contentPane.add(inserirDataNsc);
		  
		  JLabel lblestadoCivil = new JLabel("Estado Civil: ");
		  lblestadoCivil.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		  lblestadoCivil.setBounds(18, 179, 118, 24); contentPane.add(lblestadoCivil);
		  
		  JLabel lblSexo = new JLabel("Sexo: "); lblSexo.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblSexo.setBounds(298, 179, 75,
		  24); contentPane.add(lblSexo);
		  
		  final JComboBox inserirEstadoCivil = new JComboBox();
		  inserirEstadoCivil.setModel(new DefaultComboBoxModel(new String[]
		  {"Selecione", "Solteiro", "Casado", "Viuvo", "Divorciado"}));
		  inserirEstadoCivil.setBounds(129, 182, 146, 24);
		  contentPane.add(inserirEstadoCivil);
		  
		  final JComboBox<Object> inserirGenero = new JComboBox<Object>(); inserirGenero.setModel(new
		  DefaultComboBoxModel<Object>(new String[] {"Genero", "Masculino", "Feminino",
		  "Outros"})); inserirGenero.setBounds(351, 179, 132, 24);
		  contentPane.add(inserirGenero);
		  
		  JLabel lblTelefone = new JLabel("Telefone : "); lblTelefone.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblTelefone.setBounds(20, 218, 95,
		  24); contentPane.add(lblTelefone);
		  
		  inserirTelefone = new JTextField(); inserirTelefone.setColumns(10);
		  inserirTelefone.setBounds(103, 217, 192, 29);
		  contentPane.add(inserirTelefone);
		  
		  JLabel lblEmail = new JLabel("E-mail: "); lblEmail.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblEmail.setBounds(298, 218, 75,
		  24); contentPane.add(lblEmail);
		  
		  inserirEmail = new JTextField(); inserirEmail.setColumns(10);
		  inserirEmail.setBounds(369, 219, 248, 29); contentPane.add(inserirEmail);
		  
		  JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o: "); lblSituao.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblSituao.setBounds(482, 268, 79,
		  26); contentPane.add(lblSituao);
		  
		  final JComboBox inserirSituacao = new JComboBox();
		  inserirSituacao.setModel(new DefaultComboBoxModel(new String[] {"Ativo",
		  "Inativo"})); inserirSituacao.setBounds(564, 270, 95, 24);
		  contentPane.add(inserirSituacao);
		  
		  JLabel lblEndereo = new JLabel("Endere\u00E7o: "); lblEndereo.setFont(new
		  Font("Times New Roman", Font.PLAIN, 20)); lblEndereo.setBounds(20, 268, 95,
		  24); contentPane.add(lblEndereo);
		  
		  inserirEndereco = new JTextField(); inserirEndereco.setColumns(10);
		  inserirEndereco.setBounds(109, 269, 363, 29);
		  contentPane.add(inserirEndereco);
		 
		
		
		JLabel lblNomeDoVeiculo = new JLabel("Nome do veiculo : ");
		lblNomeDoVeiculo.setBounds(20, 442, 133, 23);
		contentPane.add(lblNomeDoVeiculo);
		
		inserirNomeServico = new JTextField();
		inserirNomeServico.setColumns(10);
		inserirNomeServico.setBounds(143, 443, 472, 20);
		contentPane.add(inserirNomeServico);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o : ");
		lblDescrio.setBounds(20, 488, 116, 23);
		contentPane.add(lblDescrio);
		
		final JTextArea inserirDescricao = new JTextArea();
		inserirDescricao.setBounds(120, 487, 497, 129);
		contentPane.add(inserirDescricao);
		
		JLabel lblNewLabel_1 = new JLabel("Data : ");
		lblNewLabel_1.setBounds(70, 408, 50, 23);
		contentPane.add(lblNewLabel_1);
		
		inserirData = new JTextField();
		inserirData.setBounds(103, 408, 86, 20);
		contentPane.add(inserirData);
		inserirData.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora :");
		lblHora.setBounds(206, 408, 50, 23);
		contentPane.add(lblHora);
		
		inserirHora = new JTextField();
		inserirHora.setColumns(10);
		inserirHora.setBounds(239, 408, 86, 20);
		contentPane.add(inserirHora);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(363, 408, 50, 23);
		contentPane.add(lblStatus);
		
		final JComboBox inserirStatus = new JComboBox();
		inserirStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo"}));
		inserirStatus.setBounds(411, 409, 94, 20);
		contentPane.add(inserirStatus);
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				novoCliente.setNome(inserirNome.getText()); // Vou ter que fazer assim para adicionar.
				
				novoCliente.setCodigoFuncionario(Integer.parseInt(inserirFuncionario.getText()));
				
				novoCliente.setSexo(inserirGenero.getSelectedItem().toString());
				
				novoCliente.setEmail(inserirEmail.getText());
				
				novoCliente.setTelefone(inserirTelefone.getText());
				
				novoCliente.setCpf(inserirCPF.getText());
				
				novoCliente.setEndereco(inserirEndereco.getText());
				
				novoCliente.setDataDeNasc(inserirDataNsc.getText());
				
				novoCliente.setEstadoCivil(inserirEstadoCivil.getSelectedItem().toString());
				if(inserirSituacao.getSelectedIndex() == 0) {
					novoCliente.setSituacao(true);
				}else {
					novoCliente.setSituacao(false);
				}
				
				
				
				atendimento1.setServico(inserirNomeServico.getText());
				atendimento1.setData(inserirData.getText());
				atendimento1.setHora(inserirHora.getText());
				atendimento1.setDescricao(inserirDescricao.getText());
				
				atendimento1.setStatus(inserirStatus.getToolTipText());
				atendimento1.setCodigoServico(novoCliente.getCodigoFuncionario());
						
				inserindoAtendimentos.RegistrandoAtendimento(atendimento1);
				
				
				cadastro.InserindoDados(novoCliente);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				
				inserirNome.setText("");
				inserirGenero.setSelectedItem("");
				inserirEmail.setText("");
				inserirTelefone.setText("");
				inserirCPF.setText("");
				inserirEndereco.setText("");
				inserirDataNsc.setText("");
				inserirEstadoCivil.setSelectedItem("");
				inserirDescricao.setText("");
				inserirNomeServico.setText("");
				inserirData.setText("");
				inserirHora.setText("");
				
				
				inserirNome.requestFocus();
				
			}
		});
		btnNewButton.setBounds(239, 631, 111, 29);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroGUI.this.dispose();
			}
		});
		btnCancelar.setBounds(363, 631, 111, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblCodFuncionario = new JLabel("Cod. Funcionario :");
		lblCodFuncionario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCodFuncionario.setBounds(20, 309, 153, 24);
		contentPane.add(lblCodFuncionario);
		
		inserirFuncionario = new JTextField();
		inserirFuncionario.setColumns(10);
		inserirFuncionario.setBounds(173, 311, 67, 26);
		contentPane.add(inserirFuncionario);
		
		JLabel lblCadastroDeServios = new JLabel("CADASTRO DE SERVI\u00C7OS");
		lblCadastroDeServios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeServios.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblCadastroDeServios.setBounds(183, 355, 396, 42);
		contentPane.add(lblCadastroDeServios);
	}
}
