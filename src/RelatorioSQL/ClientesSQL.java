package RelatorioSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Cadastro.Cliente;
import ConnectSQL.ConexaoSQL;

public class ClientesSQL {
	public List<Cliente> RelatoriosDeClientes(){
		String sql = "SELECT * FROM clientes";
		 
		List<Cliente> RelatorioDeClientes = new ArrayList<Cliente>();

		
		Connection conn = null;
		PreparedStatement conSql = null;
		
		//Recupera os dados do banco
		ResultSet resultadoSQL= null;
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			resultadoSQL = conSql.executeQuery();
			
			while(resultadoSQL.next()) {
				Cliente relatorioClientes = new Cliente();

				relatorioClientes.setId(resultadoSQL.getInt("id"));
				relatorioClientes.setNome(resultadoSQL.getNString("nome"));
				relatorioClientes.setSexo(resultadoSQL.getNString("sexo"));
				relatorioClientes.setEmail(resultadoSQL.getNString("email"));
				relatorioClientes.setTelefone(resultadoSQL.getNString("telefone"));
				relatorioClientes.setCpf(resultadoSQL.getNString("cpf"));
				relatorioClientes.setEndereco(resultadoSQL.getNString("endereco"));
				relatorioClientes.setDataDeNasc(resultadoSQL.getNString("dataNasc"));
				relatorioClientes.setEstadoCivil(resultadoSQL.getNString("estadoCivil"));
				relatorioClientes.setSituacao(resultadoSQL.getBoolean("situacao"));
				
			
				//array
				RelatorioDeClientes.add(relatorioClientes);
				
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
		return RelatorioDeClientes;
		
		
	}

}
