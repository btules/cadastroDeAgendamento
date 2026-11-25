package CadastroSQL;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;


import Cadastro.Servico;
import ConnectSQL.ConexaoSQL;
public class ServicoSQL{

	public void RegistrandoAtendimento(Servico atendimento) {
		String sql = "INSERT INTO atendimentos (veiculo, descricao, dataAgendada, status, fk_servico, func_hora_atenl) VALUES ( ?, ?, ?, ?, ?, ?) ";
		
		Connection conn = null;
		PreparedStatement conSql = null;
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			conSql.setString(1, atendimento.getServico());
			conSql.setString(2, atendimento.getDescricao());
			conSql.setString(3, atendimento.getData());
			conSql.setString(4, atendimento.getStatus());
			conSql.setInt(5, atendimento.getCodigoServico());
			conSql.setInt(6, atendimento.getCodigoHorario());

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

