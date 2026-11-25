package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cadastro.Funcionario;
import CadastroSQL.FuncionariosSQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncionarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField inserirNome;
	private JTextField inserirCPF;
	private JTextField inserirTelefone;
	private JTextField inserirEmail;

	
	FuncionariosSQL cadastroFuncionario = new FuncionariosSQL();
	
	Funcionario novoFuncionario = new Funcionario();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioGUI frame = new FuncionarioGUI();
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
	public FuncionarioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO FUNCION\u00C1RIOS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(60, 25, 393, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNome.setBounds(36, 90, 108, 25);
		contentPane.add(lblNome);
		
		inserirNome = new JTextField();
		inserirNome.setBounds(46, 125, 375, 34);
		contentPane.add(inserirNome);
		inserirNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("CPF:");
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTelefone.setBounds(36, 170, 108, 25);
		contentPane.add(lblTelefone);
		
		inserirCPF = new JTextField();
		inserirCPF.setColumns(10);
		inserirCPF.setBounds(46, 206, 259, 34);
		contentPane.add(inserirCPF);
		
		JLabel label = new JLabel("Telefone:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(36, 333, 108, 25);
		contentPane.add(label);
		
		inserirTelefone = new JTextField();
		inserirTelefone.setColumns(10);
		inserirTelefone.setBounds(46, 369, 259, 34);
		contentPane.add(inserirTelefone);
		
		inserirEmail = new JTextField();
		inserirEmail.setColumns(10);
		inserirEmail.setBounds(46, 288, 375, 34);
		contentPane.add(inserirEmail);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(36, 252, 108, 25);
		contentPane.add(lblEmail);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//nome, cpf, telefone, email
				
				novoFuncionario.setNome(inserirNome.getText());
				
				novoFuncionario.setCpf(inserirCPF.getText());
				
				novoFuncionario.setTelefone(inserirTelefone.getText());
				
				novoFuncionario.setEmail(inserirEmail.getText());
				cadastroFuncionario.CadastrandoFuncionario(novoFuncionario);
				
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				
				inserirNome.setText("");
				inserirEmail.setText("");
				inserirTelefone.setText("");
				inserirCPF.setText("");
				inserirNome.requestFocus();
				
			}
		});
		btnNewButton.setBounds(123, 432, 118, 35);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioGUI.this.dispose();
			}
		});
		btnCancelar.setBounds(257, 432, 118, 35);
		contentPane.add(btnCancelar);
	}

}
