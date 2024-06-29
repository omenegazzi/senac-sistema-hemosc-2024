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
import model.mTipoSanguineo;

/**
 *
 * @author gabriel.oliveira38
 */
public class cTipoSanguineo {

    public List<mTipoSanguineo> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mTipoSanguineo> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM tipos_sanguineo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mTipoSanguineo modelE = new mTipoSanguineo();
                modelE.setId_tipo_sanguineo(rs.getInt("id_tipo_sanguineo"));
                modelE.setDescricao(rs.getString("descricao"));
                modelE.setFator_rh(rs.getString("fator_rh"));
                modelE.setEstoque(rs.getInt("estoque"));
                modelE.setEstoque_minimo(rs.getInt("estoque_minimo"));

                lista.add(modelE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(mTipoSanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterar(mTipoSanguineo modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE saida_de_sangue SET nome = ? WHERE id_Tipo_sanguíneo = ? ");
            stmt.setInt(1, modelE.getId_tipo_sanguineo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo sanguíneo alterado com êxito!");

        } catch (SQLException ex) {
            Logger.getLogger(mTipoSanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(mTipoSanguineo modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM tipo sanguíneo WHERE id_Tipo_sanguíneo = ?");
            stmt.setInt(1, modelE.getId_tipo_sanguineo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo sanguíneo excluído com êxito!");

        } catch (SQLException ex) {
            Logger.getLogger(mTipoSanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
