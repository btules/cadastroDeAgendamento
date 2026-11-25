package Cadastro;

import Agendamentos.AgendaHorarioSQL;


public class AgendarHorario extends Funcionario {
	protected String horaLivre;
	
	public String getHoraLivre() {
		return horaLivre;
	}
	public void setHoraLivre(String horaLivre) {
		this.horaLivre = horaLivre;
	}

	//BUSCA OS HORARIOS DISPONIVEIS
	public void HorarioDisponivel (Servico AgendaDoDia) {
		AgendaHorarioSQL novoHorario = new AgendaHorarioSQL();
		for(AgendarHorario c: novoHorario.MarcarHorario(AgendaDoDia)) {
			System.out.println("Horario: " + c.getHoraLivre() + " " + " Cod. Funcionario:  " + c.getId() + " " + c.getNome());
						
		}
	}

	
}
