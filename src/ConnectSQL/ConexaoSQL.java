package ConnectSQL;


import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoSQL {
	private static final String USERNAME = getEnv("CADASTRO_DB_USER", "root");
	private static final String DATABASE_URL = getEnv("CADASTRO_DB_URL", "jdbc:mysql://localhost:3306/cadastro");
	
	public static Connection Conexao () throws Exception {
		String password = System.getenv("CADASTRO_DB_PASSWORD");
		if (password == null) {
			throw new IllegalStateException("Defina a variável de ambiente CADASTRO_DB_PASSWORD.");
		}

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(DATABASE_URL, USERNAME, password);
	}

	private static String getEnv(String name, String defaultValue) {
		String value = System.getenv(name);
		return value == null ? defaultValue : value;
	}

	public static void main(String[] args) throws Exception{
		Connection conexao = Conexao();
		
		if( conexao != null) {
			System.out.println("Conectado");
			conexao.close();
		}
	}
}