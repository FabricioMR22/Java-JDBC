package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private DataSource dataSource;
    public ConnectionFactory() {
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true$serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("1234");

        this.dataSource = pooledDataSource;
    }

    public Connection recuperaConexion() throws SQLException{
        return this.dataSource.getConnection();
    }
}
