package Funcionalidades;

import java.util.Scanner;

import Cadastro.Funcionario;
import CadastroSQL.FuncionariosSQL;

public class CadastrarFuncionario {
	public static void main(String[] args) {
		Scanner informacoes = new Scanner (System.in);
		FuncionariosSQL cadastroFuncionario = new FuncionariosSQL();
		
		Funcionario novoFuncionario = new Funcionario();
		
		
		//nome, cpf, telefone, email
		System.out.println("Nome Funcionario: ");
		novoFuncionario.setNome(informacoes.nextLine());
		System.out.println("CPF: ");
		novoFuncionario.setCpf(informacoes.nextLine());
		System.out.println("Telefone: ");
		novoFuncionario.setTelefone(informacoes.nextLine());
		System.out.println("Email: ");
		novoFuncionario.setEmail(informacoes.nextLine());
		cadastroFuncionario.CadastrandoFuncionario(novoFuncionario);
		informacoes.close();
	}
}
