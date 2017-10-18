package sg.edu.nus.iss.vmcs.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlLoaderStrategy implements LoadPropertyStrategy {
	Connection connection;
	@Override
	public Properties loadProperties(String dbName) {
		openConnection();
		Properties prop = new Properties();
		String sql = "SELECT * FROM " + dbName;
		try {
			ResultSet result = connection.prepareStatement(sql).executeQuery();
			while (result.next()) {
				prop.setProperty(result.getString(0), result.getString(1));
			}
			result.close();
		}catch(Exception e) {
			System.out.println("Load exception");
		}
		return prop;
	}
	
    private void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(Environment.getDBString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
