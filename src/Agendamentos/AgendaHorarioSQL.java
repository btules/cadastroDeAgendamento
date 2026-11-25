package Agendamentos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Cadastro.AgendarHorario;

import Cadastro.Servico;
import ConnectSQL.ConexaoSQL;

public class AgendaHorarioSQL extends Servico {
// codigo sql para inserir os dados na tabela
// 

	public List<AgendarHorario> MarcarHorario(Servico atendimento){
			String sql = "SELECT horariolivre.horaLivre , funcionarios.id, funcionarios.funcionario FROM horariolivre INNER JOIN funcionarios WHERE NOT EXISTS (SELECT func_hora_atenl FROM atendimentos  WHERE atendimentos.func_hora_atenl = horariolivre.id and atendimentos.fk_servico = funcionarios.id and atendimentos.dataAgendada = (?))";
			 
			List<AgendarHorario> agendamentoRealizados = new ArrayList<AgendarHorario>();

			
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
					AgendarHorario horarioDisponivel = new AgendarHorario();
					
					horarioDisponivel.setHoraLivre(resultadoSQL.getNString("horaLivre"));
					horarioDisponivel.setId(resultadoSQL.getInt("id"));
					horarioDisponivel.setNome(resultadoSQL.getNString("funcionario"));
					

					//array
					agendamentoRealizados.add(horarioDisponivel);
					
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
