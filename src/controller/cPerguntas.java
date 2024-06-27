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
import model.mPerguntas;

/**
 *
 * @author yasmim.oliveira3
 */
public class cPerguntas {
    
    public void cadastrar(mPerguntas modelP) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO perguntas (descricao) VALUES (?)");
            stmt.setString(1, modelP.getDescricao());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pergunta cadastrada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(cPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<mPerguntas> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<mPerguntas> lista = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM perguntas");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               mPerguntas modelP = new mPerguntas();
               modelP.setId_pergunta(rs.getInt("id_pergunta"));
               modelP.setDescricao(rs.getString("descricao"));

               
               lista.add(modelP);
            }

        } catch (SQLException ex) {
            Logger.getLogger(cPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public void alterar(mPerguntas modelP) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE perguntas SET descricao = ? WHERE id_pergunta = ? ");
            stmt.setString(1, modelP.getDescricao());
            stmt.setInt(2, modelP.getId_pergunta());
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Pergunta alterada com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(cChecklist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(mPerguntas modelP) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        //Exclui primeiro o registro se existir no checklist
        try {
            stmt = conn.prepareStatement("DELETE FROM checklst where fk_perguntas_id_pergunta = ? ");
            stmt.setInt(1, modelP.getId_pergunta());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(cChecklist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Exclui a pergunta na tabela perguntas por último
        try {
            stmt = conn.prepareStatement("DELETE FROM perguntas where id_pergunta = ? ");
            stmt.setInt(1, modelP.getId_pergunta());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pergunta excluída com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(cChecklist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
