import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Principal {

	public static void main(String[] args) {
		try {
			Class.forName( "org.postgresql.Driver" );
			} catch (ClassNotFoundException e ) {
				
			}	
		
	String url = "jdbc:postgresql://10.10.39.8:5432/ZIL_DB";
	String login = "jefferson";
	String senha = "m230jpg.";
	
	try{
		Connection con = DriverManager.getConnection(url, login, senha);
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("SELECT * FROM conta WHERE STATUS IS TRUE");
	while (rs.next()){
		int id = rs.getInt(0);
		String numero = rs.getString("numero");
		double saldo = rs.getDouble(0);
		boolean status = rs.getBoolean(1);
		String titular = rs.getString("titular");
		System.out.println("ID: "+ id + "Numero:"+ numero + "Saldo:"+ saldo+ "Status:"+ status+ "Titular:"+titular);
		
	}
	rs.close();
	st.close();
	con.close();
} catch ( SQLException e){
}
	
}
}
