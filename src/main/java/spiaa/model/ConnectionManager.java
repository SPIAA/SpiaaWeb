package spiaa.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import org.postgresql.ds.PGPoolingDataSource;

public class ConnectionManager {

    //INICIO SINGLETON
    private static ConnectionManager instance = null;

    private ConnectionManager() {
        try {
            URI dbUri = new URI(System.getenv("DATABASE_URL")); // postgres://<username>:<password>@<host>:<port>/<dbname>

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            source = new PGPoolingDataSource();
            source.setDataSourceName("spiaa");
            source.setUser(username);
            source.setUrl(dbUrl);
            source.setPassword(password);
            source.setMaxConnections(30);
            source.setInitialConnections(10);
            source.setTcpKeepAlive(true);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }
    //FIM SINGLETON
    private PGPoolingDataSource source;

    public Connection getConnection() throws Exception {
        Connection conn = source.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }
}