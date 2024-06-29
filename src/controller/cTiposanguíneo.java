/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mTiposanguíneo;

/**
 *
 * @author guilherme.anjos
 */
public class cTiposanguíneo {

    public void alterar(mTiposanguíneo modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE saida_de_sangue SET nome = ? WHERE id_Tipo_sanguíneo = ? ");
            stmt.setInt(1, modelE.getId_tipo_sanguíneo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo sanguíneo alterado com êxito!");

        } catch (SQLException ex) {
            Logger.getLogger(mTiposanguíneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(mTiposanguíneo modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM tipo sanguíneo WHERE id_Tipo_sanguíneo = ?");
            stmt.setInt(1, modelE.getId_tipo_sanguíneo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo sanguíneo excluído com êxito!");

        } catch (SQLException ex) {
            Logger.getLogger(mTiposanguíneo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
