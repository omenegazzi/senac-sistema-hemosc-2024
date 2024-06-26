/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mCampanha;

/**
 *
 * @author rafael.tolomeotti
 */
public class cCampanha {

    public void cadastrar(mCampanha modelE) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = mysql.conexao();
            stmt = conn.prepareStatement("INSERT INTO campanha (nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?)");
            stmt.setString(1, modelE.getNome());
            stmt.setString(2, modelE.getDescricao());
            stmt.setString(3, modelE.getDataInicio());
            stmt.setString(4, modelE.getDataFim());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException ex) {
            // Tratar exceção SQL
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());

        } finally {
            // Fechar recursos
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
