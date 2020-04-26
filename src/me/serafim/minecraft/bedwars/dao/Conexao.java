package me.serafim.minecraft.bedwars.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static Connection conexao;

    public static Connection getConexao() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost/db_bedwars?useTimezone=true&serverTimezone=UTC";
            String user = "";
            String pass = "";
            conexao = DriverManager.getConnection(dbURL, user, pass);
        } catch(Exception erro) {
            erro.printStackTrace();
        }
        return conexao;
    }
}
