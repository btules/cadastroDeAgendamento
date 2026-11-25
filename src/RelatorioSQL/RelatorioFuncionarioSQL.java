package RelatorioSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Cadastro.Funcionario;
import ConnectSQL.ConexaoSQL;

public class RelatorioFuncionarioSQL {

		public List<Funcionario> RelatoriosDeFuncionarios(){
			String sql = "SELECT * FROM funcionarios";
			 
			List<Funcionario> RelatorioDeFuncionarios = new ArrayList<Funcionario>();

			
			Connection conn = null;
			PreparedStatement conSql = null;
			
			//Recupera os dados do banco
			ResultSet resultadoSQL= null;
			
			try {
				conn = ConexaoSQL.Conexao();
				conSql = (PreparedStatement) conn.prepareStatement(sql);
				resultadoSQL = conSql.executeQuery();
				
				while(resultadoSQL.next()) {
					Funcionario relatorioFuncionario = new Funcionario();

					relatorioFuncionario.setId(resultadoSQL.getInt("id"));
					relatorioFuncionario.setNome(resultadoSQL.getNString("funcionario"));
					relatorioFuncionario.setCpf(resultadoSQL.getNString("cpf"));
					relatorioFuncionario.setTelefone(resultadoSQL.getNString("telefone"));
					relatorioFuncionario.setEmail(resultadoSQL.getNString("email"));				
				
					//array
					RelatorioDeFuncionarios.add(relatorioFuncionario);
					
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
			return RelatorioDeFuncionarios;
			
			
		}
}
