package Funcionalidades;

import Cadastro.Cliente;
import Cadastro.Funcionario;
import Cadastro.Servico;

public class RelatorioTodos {
	public static void main(String[] args) {
		Cliente relatorio = new Cliente();
		relatorio.RelatorioClientes();
		
		Funcionario relatorioFuncionario = new Funcionario();
		
		relatorioFuncionario.RelatorioFuncionarios();
		
		Servico relatorioServicos = new Servico();
		relatorioServicos.RelatorioServicos();
		
	}
}
