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
import model.mColaboradores;
import model.mDoacoes;
import model.mDoadores;
import model.mTiposanguineo;

/**
 *
 * @author ana.matos4
 */
public class cDoacoes {
    
    public List<mDoacoes> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mDoacoes> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from doacoes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mDoacoes modele = new mDoacoes();
                modele.setId_doacao(rs.getInt("id_doacoes"));
                modele.setData(rs.getDate("data"));
                
                mDoadores modelD = new mDoadores();
                modelD.setId_doadores(rs.getInt("id_doador"));
                modele.setDoadores(modelD);
                
                mTiposanguineo modelT = new mTiposanguineo();
                modelT.setId_tipo_sanguíneo(rs.getInt("id_tipo_sanguineo"));
                modele.setTiposanguineo(modelT);
                
                
                mColaboradores modelC = new mColaboradores();              
                modelC.setId_colaborador(rs.getInt("colaboradores"));
                lista.add(modele);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mDoacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
}
