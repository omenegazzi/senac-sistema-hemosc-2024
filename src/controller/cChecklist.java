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
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mChecklist;
import model.mDoadores;
import model.mPerguntas;

/**
 *
 * @author yasmim.oliveira3
 */
public class cChecklist {
 
    public List<mChecklist> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<mChecklist> lista = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM checklists RIGHT JOIN "
                    + "perguntas ON perguntas.id_pergunta = checklists.fk_perguntas_id_pergunta");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                mChecklist modelM = new mChecklist();
                
                modelM.setId_checklist(rs.getInt("id_checklist"));

                mPerguntas modelP = new mPerguntas();
                modelP.setId_pergunta(rs.getInt("id_pergunta"));
                modelP.setDescricao(rs.getString("descricao"));

                modelM.setPergunta(modelP);
                modelM.setResposta(rs.getBoolean("resposta"));

               
               lista.add(modelM);
            }

        } catch (SQLException ex) {
            Logger.getLogger(cPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
     public void cadastrar(mChecklist modelM, mPerguntas modelP) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO checklists (fk_perguntas_id_pergunta, resposta) VALUES (?,?)");
//            modelP.setId_pergunta(rs.getInt(modelP.getId_pergunta()));

            modelM.setPergunta(modelP);
            
            stmt.setInt(1, modelM.getPergunta().getId_pergunta());
            stmt.setBoolean(2, modelM.getResposta());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(cPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
