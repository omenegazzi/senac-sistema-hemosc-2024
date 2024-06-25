/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mAgendamentos;

/**
 *
 * @author gabriel.montibeller
 */
public class cAgendamentos {
      public void excluir(mAgendamentos modele) {
        Connection conn = mysql.conexao();
 
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        try {
            stmt = conn.prepareStatement("DELETE FROM agendamento WHERE  = ?");
            stmt.setInt(1, modele.getId_Agendamento());
 
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso!");
 
        } catch (SQLException ex) {
            Logger.getLogger(cAgendamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}
