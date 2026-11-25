package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cadastro.Cliente;

import javax.swing.JDesktopPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaPrincipalGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalGUI frame = new TelaPrincipalGUI();
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
	public TelaPrincipalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setForeground(Color.BLACK);
		desktopPane.setBounds(428, 258, -423, -249);
		contentPane.add(desktopPane);
		
		JButton inserirCliente = new JButton("Cadastro Cliente");
		inserirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastroGUI().setVisible(true);
			}
		});
		inserirCliente.setBounds(149, 89, 158, 35);
		contentPane.add(inserirCliente);
		
		JButton inserirFuncionario = new JButton("Cadastro Funcionario");
		inserirFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FuncionarioGUI().setVisible(true);
			}
		});
		inserirFuncionario.setBounds(147, 132, 162, 40);
		contentPane.add(inserirFuncionario);
		
		JButton dadosServicos = new JButton("Servi\u00E7o");
		dadosServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RelatorioServicoGUI().setVisible(true);
			}
		});
		dadosServicos.setBounds(149, 230, 162, 34);
		contentPane.add(dadosServicos);
		
		JButton inserirAtendimento = new JButton("Deletar Servico");
		inserirAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeletarGUI().setVisible(true);
			}
		});
		inserirAtendimento.setBounds(149, 183, 160, 40);
		contentPane.add(inserirAtendimento);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento de Atendimento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 9, 313, 41);
		contentPane.add(lblNewLabel);
	}
}
