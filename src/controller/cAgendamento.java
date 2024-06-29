package Controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.mAgendamentos;
import model.mColaboradores;
import model.mDoacoes;
import model.mDoadores;
import model.mTiposanguineo;

/**
 *
 * @author ana.matos4
 */
public class cAgendamento {
    
     public List<mAgendamentos> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mAgendamentos> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from agendamento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                mAgendamentos modele = new mAgendamentos();
                modele.setId_Agendamento(rs.getInt("id_agendamento"));
                
                modele.setData(rs.getDate("data"));
                modele.setHora(rs.getTime("hora"));
                
                mDoadores modelD = new mDoadores();
                modelD.setId_doadores(rs.getInt("id_doador"));
                modele.setDoadores(modelD);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(mAgendamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
}


