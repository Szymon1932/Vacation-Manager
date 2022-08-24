package DatabaseConnection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    static DBConnection dbConnection = new DBConnection();
    public static QueryRunner queryRunner;

    private DBConnection() {
        System.out.println("connected to database");
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        DBConnection.connect();
        return dbConnection;
    }


    private static QueryRunner connect() {
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties prop = new Properties();
        try {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String dbUser = prop.getProperty("dbUser");
        String dbPassword = prop.getProperty("dbPassword");
        String url = prop.getProperty("url");

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl(url);
        basicDataSource.setUsername(dbUser);
        basicDataSource.setPassword(dbPassword);
        basicDataSource.setDriverClassName("org.postgresql.Driver");

        try {
            basicDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        queryRunner = new QueryRunner(basicDataSource);
        return queryRunner;
    }



}
