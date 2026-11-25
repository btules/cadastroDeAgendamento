package RelatorioSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Cadastro.Servico;
import ConnectSQL.ConexaoSQL;

public class RelatorioServicosSQL {
	public  List<Servico>  RelatorioDeServico() {
		 
		String sql = "SELECT * FROM atendimentos join funcionarios on funcionarios.id = atendimentos.fk_servico join clientes on clientes.fk_funcionario = atendimentos.fk_servico join horariolivre on horariolivre.id = atendimentos.func_hora_atenl  ";
		
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
		
			resultadoSQL = conSql.executeQuery();
			
			while(resultadoSQL.next()) {
				Servico atendimentoErealizacao = new Servico();
				
				atendimentoErealizacao.setId(resultadoSQL.getInt("id"));
				atendimentoErealizacao.setServico(resultadoSQL.getString("veiculo"));
				atendimentoErealizacao.setDescricao(resultadoSQL.getString("descricao"));
				atendimentoErealizacao.setStatus(resultadoSQL.getString("status"));
				atendimentoErealizacao.setData(resultadoSQL.getNString("dataAgendada"));
				atendimentoErealizacao.setHora(resultadoSQL.getNString("horaLivre"));
				
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
	
}
