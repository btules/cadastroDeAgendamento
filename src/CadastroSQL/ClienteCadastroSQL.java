package CadastroSQL;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;

import Cadastro.Cliente;
import ConnectSQL.ConexaoSQL;
// Um arquivo é pra cliente e outro para funcionario, esse SERA PARA CLIENTES!!
public class ClienteCadastroSQL {
	public void InserindoDados(Cliente pessoa) {
		String sql = "INSERT INTO clientes (nome, sexo, email, telefone, cpf, endereco, dataNasc, estadoCivil, situacao, fk_funcionario) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		Connection conn = null;
		PreparedStatement conSql = null;
		
		try {
			conn = ConexaoSQL.Conexao();
			conSql = (PreparedStatement) conn.prepareStatement(sql);
			conSql.setString(1, pessoa.getNome());
			conSql.setString(2, pessoa.getSexo());
			conSql.setString(3, pessoa.getEmail());
			conSql.setString(4, pessoa.getTelefone());
			conSql.setString(5, pessoa.getCpf());
			conSql.setString(6, pessoa.getEndereco());
			conSql.setString(7,pessoa.getDataDeNasc());
			conSql.setString(8, pessoa.getEstadoCivil());
			conSql.setBoolean(9, pessoa.isSituacao());
			conSql.setInt(10, pessoa.getCodigoFuncionario());
			
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
