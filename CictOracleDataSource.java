import java.sql.*;


import oracle.jdbc.pool.OracleDataSource;

public class CictOracleDataSource extends OracleDataSource{
	
	public CictOracleDataSource() throws SQLException {
		this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr:1521:etupre");
		this.setUser("mnf4376a") ;
		this.setPassword("$iutinfo") ;

	}
	
	public static void main(String[] args) throws SQLException{
		CictOracleDataSource bd = new CictOracleDataSource();
		Connection cn = bd.getConnection() ;
		System.out.println("Connexion établie...") ;
		cn.close() ;
	}

}
