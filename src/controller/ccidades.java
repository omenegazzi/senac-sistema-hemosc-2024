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
import model.mCidades;

/**
 *
 * @author leandrison.ribeiro
 */
public class ccidades {

    public List<mcidades> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mcidades> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from cidades");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mcidades modele = new mcidades();
                modele.setIdcidade(rs.getInt("id_cidade"));
                modele.setCodigo_ibge(rs.getInt("codigo_ibge"));
                modele.setDescricao(rs.getString("descricao"));
                modele.setUf(rs.getString("uf"));
                lista.add(modele);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ccidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public void ExcluirCidades(mCidades modelCidades) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareCall("DELETE FROM cidades WHERE id_cidade = ?");
            stmt.setInt(1, modelCidades.getId_cidade());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cCidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Cidade excluida com sucesso");

    }
}
