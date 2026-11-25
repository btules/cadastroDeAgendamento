package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cadastro.Cliente;
import FuncoesSQL.DeletarAtendimentoSQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletarGUI extends JFrame {

	private JPanel contentPane;
	private JTextField inserirCod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarGUI frame = new DeletarGUI();
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
	public DeletarGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deletar Servi\u00E7o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 11, 235, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informe o codigo do Cliente: ");
		lblNewLabel_1.setBounds(24, 97, 155, 20);
		contentPane.add(lblNewLabel_1);
		
		inserirCod = new JTextField();
		inserirCod.setBounds(189, 97, 74, 20);
		contentPane.add(inserirCod);
		inserirCod.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente excluirCliente = new Cliente();
				
				//método SQL que exclui o atendimento
				DeletarAtendimentoSQL excluir = new DeletarAtendimentoSQL();
				
				
				excluirCliente.setId(Integer.parseInt(inserirCod.getText()));
				excluir.ExcluirCliente(excluirCliente);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				
				inserirCod.setText("");
				
			}
		});
		btnNewButton.setBounds(78, 144, 114, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletarGUI.this.dispose();
			}
		});
		button.setBounds(202, 144, 89, 23);
		contentPane.add(button);
	}
}
