package Funcionalidades;

import java.util.Scanner;

import Cadastro.Cliente;
import FuncoesSQL.DeletarAtendimentoSQL;

public class DeletarAtendimentos {
	public static void main(String[] args) {
		Scanner informacoes = new Scanner(System.in);
		Cliente excluirCliente = new Cliente();
		
		//método SQL que exclui o atendimento
		DeletarAtendimentoSQL excluir = new DeletarAtendimentoSQL();
		System.out.println("Informe qual atendimento quer excluir");
		
		excluirCliente.setId(informacoes.nextInt());
		excluir.ExcluirCliente(excluirCliente);
		
		informacoes.close();
	}
}
