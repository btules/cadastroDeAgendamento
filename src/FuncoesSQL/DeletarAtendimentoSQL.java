package FuncoesSQL;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import Cadastro.Cliente;
import ConnectSQL.ConexaoSQL;

public class DeletarAtendimentoSQL {
	public void ExcluirCliente(Cliente excluir) {
		String sql = "DELETE FROM clientes WHERE clientes.id = (?)  ";
		
		Connection conn = null;
		PreparedStatement conSql = null;
		
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			
			conSql.setInt(1, excluir.getId());
			
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
