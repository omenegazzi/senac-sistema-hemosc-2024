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
import model.mChecklist;
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
            stmt = conn.prepareStatement("SELECT * FROM checklists INNER JOIN "
                    + "perguntas ON perguntas.id_pergunta = checklists.fk_perguntas_id_pergunta");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               mChecklist modelC = new mChecklist();
                modelC.setId_checklist(rs.getInt("id_checklist"));

                mPerguntas modelP = new mPerguntas();
                modelP.setDescricao(rs.getString("descricao"));

                modelC.setPergunta(modelP);
                modelC.setResposta(rs.getBoolean("resposta"));

               
               lista.add(modelC);
            }

        } catch (SQLException ex) {
            Logger.getLogger(cPerguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
