package Funcionalidades;

import java.util.Scanner;

import Cadastro.AgendarHorario;
import Cadastro.Cliente;
import Cadastro.Servico;

import CadastroSQL.ClienteCadastroSQL;
import CadastroSQL.ServicoSQL;

public class CadastroCliente {

	public static void main(String[] args) {
//		Entrada de dados
		Scanner informacoes = new Scanner(System.in);

//		loop do while
		String sistema = "sim";

//		Inserir no banco de dados
		ClienteCadastroSQL cadastro = new ClienteCadastroSQL();
		ServicoSQL inserindoAtendimentos = new ServicoSQL();

//		Pega as informacoes necessarias		
		Servico atendimento1 = new Servico();
		Cliente novoCliente = new Cliente();
		AgendarHorario marcarHorario = new AgendarHorario();

		while(sistema.equals("sim")){
		System.out.println("Informe o dia deseja marcar atendimento");
		atendimento1.setData(informacoes.nextLine());
		System.out.println("Escolha um horario para atendimento");
		marcarHorario.HorarioDisponivel(atendimento1);
		System.out.println("Informe o horario: ");
		atendimento1.horarioMarcado(informacoes.nextLine());
		System.out.println("Informe o Funcionario: ");
		novoCliente.setCodigoFuncionario(informacoes.nextInt());

//		(nome, sexo, email, telefone, cpf, endereco, dataNasc, estadoCivil, situacao)
		System.out.println("Nome do cliente : ");
		novoCliente.setNome(informacoes.nextLine()); // Vou ter que fazer assim para adicionar.
		System.out.println("Sexo: ");
		novoCliente.setSexo(informacoes.nextLine());
		System.out.println("Email: ");
		novoCliente.setEmail(informacoes.nextLine());
		System.out.println("Telefone: ");
		novoCliente.setTelefone(informacoes.nextLine());
		System.out.println("CPF: ");
		novoCliente.setCpf(informacoes.nextLine());
		System.out.println("Endereço: ");
		novoCliente.setEndereco(informacoes.nextLine());
		System.out.println("Data de Nascimento: ");
		novoCliente.setDataDeNasc(informacoes.nextLine());
		System.out.println("Estado Civil: ");
		novoCliente.setEstadoCivil(informacoes.nextLine());
		System.out.println("Situação: 1- Ativo ou 2- Não Ativo ");
		novoCliente.setSituacao(informacoes.hasNextLine());
		cadastro.InserindoDados(novoCliente);
		
//	nome, descricao, data, hora, status
		System.out.println("Nome do Veiculo: ");
		atendimento1.setServico(informacoes.nextLine());
		System.out.println("Descrição do Problema: ");
		atendimento1.setDescricao(informacoes.nextLine());
		System.out.println("Status do Atendimento: ");
		atendimento1.setStatus(informacoes.nextLine());
		atendimento1.setCodigoServico(novoCliente.getCodigoFuncionario());
				
		inserindoAtendimentos.RegistrandoAtendimento(atendimento1);
		
		System.out.println("Deseja continuar agendando?  sim ou nao");
		sistema = informacoes.nextLine(); 
		}

		informacoes.close();
	}

}
