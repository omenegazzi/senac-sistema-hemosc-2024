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
import model.mUsuarios;

/**
 *
 * @author ana.silva157
 */
public class cUsuarios {
    
    public void excluir(mUsuarios modelE) {
        Connection conn = mysql.conexao();
 
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        try {
            stmt = conn.prepareStatement("DELETE FROM usuarios where id_usuario = ?");
            stmt.setInt(1, modelE.getId_usuario());
 
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
 
        } catch (SQLException ex) {
            Logger.getLogger(cUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }         
}
