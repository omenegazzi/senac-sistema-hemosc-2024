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
public class cCidades {

    public List<mCidades> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mCidades> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from cidades");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mCidades modele = new mCidades();
                modele.setId_cidade(rs.getInt("id_cidade"));
                modele.setCodigo_ibge(rs.getInt("codigo_ibge"));
                modele.setDescricao(rs.getString("descricao"));
                modele.setUf(rs.getString("uf"));
                lista.add(modele);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mCidades.class.getName()).log(Level.SEVERE, null, ex);
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
    
    

    public void alterar(mCidades modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE cidades SET codigo_ibge  = ?,descricao = ?,uf = ? "
                    + " WHERE id_cidade = ?");
            stmt.setInt(1, modelE.getCodigo_ibge());
            stmt.setString(2, modelE.getDescricao());
            stmt.setString(3, modelE.getUf());
            stmt.setInt(4, modelE.getId_cidade());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editora cadastrada com "
                    + "sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(mCidades.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

    }

    /*public void alterar(cCidades modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = conn.prepareStatement("UPDATE cidades SET nome = ?"
                    + " WHERE id_cidades = ?");
            stmt.setString(1, modelCidades.getId_cidade());
            stmt.setInt(2, modelCidades.getId_cidade());
            stmt.executeUpdate();

        } catch (SQLException ex) {Logger.getLogger(cCidades class.getName()).log(Level.SEVERE, null,
                    ex);

            JOptionPane.showMessageDialog(null, "Cidade Alterada com "
                    + "sucesso!");

        }
        try {

            stmt = conn.prepareStatement("UPDATE codigo SET nome = ?"
                    + " WHERE codigo_ibge = ?");
            stmt.setInt(modelCidades.getInt_codigo_ibge());
            stmt.executeUpdate();
            

        } catch (SQLException ex) {Logger.getLogger(cCidades class.getName()).log(Level.SEVERE, null,ex);

            JOptionPane.showMessageDialog(null, "Codigo Alterado com "
                    + "sucesso!");

        }

        try {

            stmt = conn.prepareStatement("UPDATE descricao SET nome = ?"
                    + " WHERE descricao = ?");
            stmt.setInt(modelCidades.getString_descricao());
            stmt.executeUpdate();

                  } catch (SQLException ex) { Logger.getLogger(cCidades class.getName()).log(Level.SEVERE, null ex);

            JOptionPane.showMessageDialog(null, "Descricao Alterada com "
                    + "sucesso!");

        }
        
          try {

            stmt = conn.prepareStatement("UPDATE uf SET nome = ?"
                    + " WHERE uf = ?");
            stmt.setInt(modelCidades.getString_uf());
            stmt.executeUpdate();

        } catch (SQLException ex) { Logger.getLogger(cCidades class.getName()).log(Level.SEVERE, null ex);

            JOptionPane.showMessageDialog(null, "UF Alterada com "
                    + "sucesso!");

        }
        
        
        
        

    }*/
}
