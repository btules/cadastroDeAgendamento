package FuncoesSQL;

import java.sql.Connection;


import com.mysql.jdbc.PreparedStatement;


import Cadastro.Servico;
import ConnectSQL.ConexaoSQL;

public class UpdateHorarioSQL {
	public void RemarcarHorario(Servico atendimento) {
		String sql = "UPDATE atendimentos INNER JOIN clientes SET dataAgendada = (?), func_hora_atenl = (?) WHERE atendimentos.id = (?)  ";
		
		Connection conn = null;
		PreparedStatement conSql = null;
		
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			
			conSql.setString(1, atendimento.getData());
			conSql.setInt(2, atendimento.getCodigoHorario());
			conSql.setInt(3, atendimento.getId());
			
			conSql.executeUpdate();
			conSql.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conSql != null && conn != null) {
					conSql.close();
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	}
	

// 