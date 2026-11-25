package Cadastro;

import RelatorioSQL.RelatorioFuncionarioSQL;

public class Funcionario extends Cadastro{
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//Todos os Funcionarios
			public void RelatorioFuncionarios () {
				RelatorioFuncionarioSQL geraRelatorio = new RelatorioFuncionarioSQL();
				for(Funcionario c: geraRelatorio.RelatoriosDeFuncionarios()) {
					System.out.println("Código: " + c.getId());
					System.out.println("Nome do Funcionario: " + c.getNome());
					System.out.println("CPF: " + c.getCpf());
					System.out.println("Telefone: " + c.getTelefone());
					System.out.println("Email: " + c.getEmail());
					System.out.println();
				}
			}
}
