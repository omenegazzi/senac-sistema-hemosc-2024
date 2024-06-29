/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author diegomenegazzi
 */
public class mysql {
    public static Connection conexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/banco_sangue?"
                    + "user=root&password=root");
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao conectar no banco de dados");
        }
    }
}
