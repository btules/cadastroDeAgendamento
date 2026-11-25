package Funcionalidades;

import java.util.Scanner;

import Cadastro.Servico;


public class AtendimentosRealizados {
	public static void main(String[] args) {
		Scanner informacoes = new Scanner (System.in);
		//SELEC FROM ATENDIMENTOS REALIZADOS NO DIA INFORMADO
		Servico atendimento1 = new Servico();
		System.out.println("Informe o dia que você quer saber os atendimentos: ");
		atendimento1.setData(informacoes.nextLine());
		atendimento1.AgendamentoRealizacoes(atendimento1);

		informacoes.close();
	}
}
