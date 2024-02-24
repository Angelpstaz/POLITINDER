package DataAccessComponent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
|--------------------------------------|
| (©)2k24 EPN-FIS, All right reserved. |       
|                                      |
|isabellahq29@gmail.com       lalabell |
|______________________________________|
Autor: lalabell
Fecha: 16/02/1014
src: Creación del SQLiteJavaHelper
*/

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database/POLITINDER.sqlite";
    private static Connection connection = null;

    protected SQLiteDataHelper(){
    }

    protected static synchronized Connection openConnection() throws Exception{
        try {
            if (connection == null) {
            connection = DriverManager.getConnection(DBPathConnection);
            }
        } catch (SQLException e) {
            throw e;
        }
        return connection;
    }
}