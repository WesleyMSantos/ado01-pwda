package br.senac.pi3.pdwa.crudproduto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Abrir conexão com banco de dados MySQL

 */
public class ConnectionUtils {

    public static Connection obterConexao()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/produtodb",
                "root",
                "");
        return connection;
    }
}
