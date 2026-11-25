package Agendamentos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Cadastro.Servico;
import ConnectSQL.ConexaoSQL;

public class AtendimentoSQL extends Servico {
		
	public  List<Servico>  Agendamentos(Servico atendimento) {
		 
		String sql = "SELECT * FROM atendimentos join funcionarios on funcionarios.id = atendimentos.fk_servico join clientes on clientes.fk_funcionario = atendimentos.fk_servico join horariolivre on horariolivre.id = atendimentos.func_hora_atenl WHERE dataAgendada = (?)";
		
		List<Servico> agendamentoRealizados = new ArrayList<Servico>();
//		List<Cliente> agendamentoCliente = new ArrayList<Cliente>();
//		List<Funcionario> agendamentoComFuncionario = new ArrayList<Funcionario>();
		Connection conn = null;
		PreparedStatement conSql = null;
		
		//Recupera os dados do banco
		ResultSet resultadoSQL= null;
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			conSql.setString(1, atendimento.getData());
			resultadoSQL = conSql.executeQuery();
			
			while(resultadoSQL.next()) {
				Servico atendimentoErealizacao = new Servico();
				
				atendimentoErealizacao.setServico(resultadoSQL.getString("veiculo"));
				atendimentoErealizacao.setDescricao(resultadoSQL.getString("descricao"));
				atendimentoErealizacao.setStatus(resultadoSQL.getString("status"));
				atendimentoErealizacao.setData(resultadoSQL.getNString("dataAgendada"));
				atendimentoErealizacao.setHora(resultadoSQL.getNString("horaLivre"));
				atendimentoErealizacao.setCodigoServico(resultadoSQL.getInt("fk_servico"));
				atendimentoErealizacao.setNome(resultadoSQL.getNString("funcionario"));
				
				
				//array
				agendamentoRealizados.add(atendimentoErealizacao);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conSql != null && conn != null && resultadoSQL != null) {
					conSql.close();
					resultadoSQL.close();
					conn.close();
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return agendamentoRealizados;
		
		
	}
	
//	Deve haver um módulo no programa que exiba a agenda completa de um dia, exibindo todos os
//	atendimentos agendados/realizados naquele dia;

}
