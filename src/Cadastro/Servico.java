package Cadastro;

import Agendamentos.AtendimentoSQL;
import RelatorioSQL.RelatorioServicosSQL;

public class Servico {
	protected int id;
	protected String servico;
	protected String descricao;
	protected String data;
	protected String hora;
	protected String status;
	protected int codigoServico;
	protected int codigoHorario;
	protected String nome;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(int codigoHorario) {
		this.codigoHorario = codigoHorario;
	}

	public int getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(int codigoFuncionario) {
		this.codigoServico = codigoFuncionario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void AgendamentoRealizacoes(Servico AgendaDoDia) {
		AtendimentoSQL novoAtendimento = new AtendimentoSQL();
		for (Servico c : novoAtendimento.Agendamentos(AgendaDoDia)) {
			System.out.println("Servico: " + c.getServico());
			System.out.println("Descrição do serviço: " + c.getDescricao());
			System.out.println("Data / Hora: " + c.getData() + " " + c.getHora()); // A hora deve vir da tabela de horario
			System.out.println("Situacao: " + c.getStatus());
			System.out.println("Funcionario: " +c.getCodigoServico()+ " "  + c.getNome());
			System.out.println();

		}
	}
	
	public void RelatorioServicos() {
		RelatorioServicosSQL relatorioAtendimento = new RelatorioServicosSQL();
		for (Servico c : relatorioAtendimento.RelatorioDeServico()) {
			System.out.println("Servico: " + c.getServico());
			System.out.println("Descrição do serviço: " + c.getDescricao());
			System.out.println("Data / Hora: " + c.getData() + " " + c.getHora()); // A hora deve vir da tabela de horario
			System.out.println("Situacao: " + c.getStatus());
			System.out.println();

		}
	}

	public void horarioMarcado(String hora) {
		if (hora.equals("08:00")) {
			this.setCodigoHorario(1);
		} else if (hora.equals("10:00")) {
			this.setCodigoHorario(2);
		} else if (hora.equals("14:00")) {
			this.setCodigoHorario(3);
		} else if (hora.equals("16:00")) {
			this.setCodigoHorario(4);
		}

	}
}
