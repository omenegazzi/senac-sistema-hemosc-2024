/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.tolomeotti
 */
public class cCampanha {
    public void cadastrar(Connection conn) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO campanha (id_campanha, nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)");
            int id_campanha = 0;
            stmt.setInt(1, id_campanha);
            String nome = null;
            stmt.setString(2, nome);
            String descricao = null;
            stmt.setString(3, descricao);
            Date data_inicio = null;
            stmt.setDate(4, data_inicio);
            Date data_fim = null;
            stmt.setDate(5, data_fim);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Campanha cadastrada com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void excluir(Connection conn, int idCampanha) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM campanha WHERE id_campanha = ?");
            stmt.setInt(1, idCampanha);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Campanha excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Campanha não encontrada.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(cColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
