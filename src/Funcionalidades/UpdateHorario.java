package Funcionalidades;


import java.util.Scanner;

import Cadastro.AgendarHorario;
import Cadastro.Servico;
import FuncoesSQL.UpdateHorarioSQL;

public class UpdateHorario {
public static void main(String[] args) {
	Scanner informacoes = new Scanner(System.in);
	Servico atualizaDataHora = new Servico();
	AgendarHorario marcarHorario = new AgendarHorario();
	
	UpdateHorarioSQL novoHorarioData = new UpdateHorarioSQL();
	
	System.out.println("Informe o dia deseja marcar atendimento");
	atualizaDataHora.setData(informacoes.nextLine());
	System.out.println("Escolha um horario para remarcar atendimento");
	marcarHorario.HorarioDisponivel(atualizaDataHora);
	System.out.println("Informe o horario: ");
	atualizaDataHora.horarioMarcado(informacoes.nextLine());
	System.out.println("Informe o codigo do atendimento: ");
	atualizaDataHora.setId(informacoes.nextInt());
	
	
	novoHorarioData.RemarcarHorario(atualizaDataHora);
	
	informacoes.close();
}
}
