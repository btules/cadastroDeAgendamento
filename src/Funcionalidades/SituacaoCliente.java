package Funcionalidades;

import java.util.Scanner;

import Cadastro.Cliente;

public class SituacaoCliente {
	public static void main(String[] args) {
		Scanner informacoes = new Scanner(System.in);
		Cliente situacao = new Cliente();
		System.out.println("Informe a situacão que deseja true ou false");
		situacao.setSituacao(informacoes.hasNextLine());
		situacao.SituacaoClientes(situacao);
		
		informacoes.close();
	}
}
