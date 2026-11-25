package CadastroSQL;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

import Cadastro.Funcionario;
import ConnectSQL.ConexaoSQL;

public class FuncionariosSQL {
	
	public void CadastrandoFuncionario(Funcionario colaborador) {
		String sql = "INSERT INTO funcionarios (funcionario, cpf, telefone, email) VALUES ( ?, ?, ?, ?) ";

		Connection conn = null;
		PreparedStatement conSql = null;
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			conSql.setString(1, colaborador.getNome());
			conSql.setString(2, colaborador.getCpf());
			conSql.setString(3, colaborador.getTelefone());
			conSql.setString(4, colaborador.getEmail());
			
			
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
