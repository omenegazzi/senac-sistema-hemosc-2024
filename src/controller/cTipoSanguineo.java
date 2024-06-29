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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mTiposanguineo;

/**
 *
 * @author gabriel.oliveira38
 */
public class cTipoSanguineo {

    public List<mTiposanguineo> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mTiposanguineo> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM tipos_sanguineo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mTiposanguineo modelE = new mTiposanguineo();
                modelE.setId_tipo_sanguíneo(rs.getInt("id_tipo_sanguineo"));
                modelE.setDescricao(rs.getString("descricao"));
                modelE.setFator_rh(rs.getString("fator_rh"));
                modelE.setEstoque(rs.getInt("estoque"));
                modelE.setEstoque_minimo(rs.getInt("estoque_minimo"));

                lista.add(modelE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(mTiposanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterar(mTiposanguineo modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE saida_de_sangue SET nome = ? WHERE id_Tipo_sanguíneo = ? ");
            stmt.setInt(1, modelE.getId_tipo_sanguíneo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo sanguíneo alterado com êxito!");

        } catch (SQLException ex) {
            Logger.getLogger(mTiposanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(mTiposanguineo modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM tipo sanguíneo WHERE id_Tipo_sanguíneo = ?");
            stmt.setInt(1, modelE.getId_tipo_sanguíneo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo sanguíneo excluído com êxito!");

        } catch (SQLException ex) {
            Logger.getLogger(mTiposanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
