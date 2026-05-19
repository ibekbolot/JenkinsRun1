package kg.db.db_utils;

import kg.utils.file.ConfigurationManager;
import lombok.Getter;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.*;

public class DB_Connection {

    @Getter
    private static Connection connection;
    private static Statement statement;

    private DB_Connection(){
        // singleton pattern
    }

    private static PGSimpleDataSource getBaseDataSource(String dataBase){
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource(){{
            setServerName(ConfigurationManager.getBaseConfig().server());
            setPortNumber(ConfigurationManager.getBaseConfig().port());
            setUser(ConfigurationManager.getBaseConfig().user());
            setPassword("1234");
            setDatabaseName(dataBase);
        }};
        return pgSimpleDataSource;
    }

    public static void openConnection(String database) throws SQLException {
        if(connection == null){
            connection = getBaseDataSource(database).getConnection();
            statement = connection.createStatement();
        }
    }

    public static void closeConnection(){
        try{
            if (statement != null){
                statement.close();
                statement = null;
            }
            if (statement != null){
                statement.close();
                statement = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    // select * from users
    // select * from users where user.name = 'john'
    public static ResultSet makeQuery(String query, Object... params) throws SQLException {
        if (params.length == 0){
            return statement.executeQuery(query);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement.executeQuery();
        }
    }

    public static int executeUpdate(String query, Object... params) throws SQLException {
        if (params.length == 0) {
            return statement.executeUpdate(query);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeUpdate();
        }
    }



}
