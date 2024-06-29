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
import model.mEntidades;

/**
 *
 * @author leandrison.ribeiro
 */
public class centidades {
    public void alterar(mEntidades modele) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("UPDATE entidades set nome = ? where id_entidade =?");
            stmt.setInt(1, modele.getId_entidades());
            stmt.setInt (2,modele.getCidades().getId_cidade());
            stmt.setString(3,modele.getNome());
            stmt.setString(4,modele.getEndereco());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "entidade alterada com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(centidades.class.getName()).log(Level.SEVERE, null, ex);
        }

   }
    public List<mEntidades> listar() {
        Connection conn = mysql.conexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mEntidades> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from entidades");
            rs= stmt.executeQuery();
            
            while (rs.next()){
                mEntidades modele=new mEntidades();
                modele.setId_entidades(rs.getInt("id_entidade"));
                
                mCidades modelM = new mCidades();
                modelM.setId_cidade(rs.getInt("fk_cidades_id_cidade"));
                modele.setCidades(modelM);

                modele.setNome(rs.getString("nome"));
                modele.setEndereco(rs.getString("endereco"));
                lista.add(modele);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(centidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
      public void excluir(mEntidades modele) {
        Connection conn = mysql.conexao();
 
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        try {
            stmt = conn.prepareStatement("DELETE FROM entidades WHERE id_editora = ?");
            stmt.setInt(1, modele.getId_entidades());
 
            stmt.executeUpdate();
 
            JOptionPane.showMessageDialog(null, "Editora excluída com sucesso!");
 
        } catch (SQLException ex) {
            Logger.getLogger(centidades.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}
