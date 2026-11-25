package Cadastro;


import FuncoesSQL.LocalizaSituacaoSQL;
import RelatorioSQL.ClientesSQL;

public class Cliente extends Cadastro {
	
	protected boolean situacao;
	protected String dataDeNasc; 
	protected String estadoCivil;
	protected int codigoFuncionario;
	protected int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigoFuncionario() {
		return codigoFuncionario;
	}
	public void setCodigoFuncionario(int codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	public String getDataDeNasc() {
		return dataDeNasc;
	}
	public void setDataDeNasc(String dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
	//Todos os clientes
		public void RelatorioClientes () {
			ClientesSQL geraRelatorio = new ClientesSQL();
			for(Cliente c: geraRelatorio.RelatoriosDeClientes()) {
				System.out.println("Código: " + c.getId());
				System.out.println("Nome do Cliente: " + c.getNome());
				System.out.println("Sexo: " + c.getSexo());
				System.out.println("Email: " + c.getEmail());
				System.out.println("Telefone: " + c.getTelefone());
				System.out.println("CPF: " + c.getCpf());
				System.out.println("Endereço: " + c.getEndereco());
				System.out.println("Data de Nascimento: "+ c.getDataDeNasc());
				System.out.println("Estado Civil: " + c.getEstadoCivil());
				System.out.println("Situação: " + c.isSituacao());
				System.out.println();
			}
		}
		
	// Situacao 
		public void SituacaoClientes (Cliente situacao) {
			LocalizaSituacaoSQL geraLocalizacao = new LocalizaSituacaoSQL();
			for(Cliente c: geraLocalizacao.LocalizarPorSituacao(situacao)) {
				System.out.println("Código: " + c.getId());
				System.out.println("Nome do Cliente: " + c.getNome());
				System.out.println("Sexo: " + c.getSexo());
				System.out.println("Email: " + c.getEmail());
				System.out.println("Telefone: " + c.getTelefone());
				System.out.println("CPF: " + c.getCpf());
				System.out.println("Endereço: " + c.getEndereco());
				System.out.println("Data de Nascimento: "+ c.getDataDeNasc());
				System.out.println("Estado Civil: " + c.getEstadoCivil());
				System.out.println("Situação: " + c.isSituacao());
				System.out.println();
			}
		}
}
