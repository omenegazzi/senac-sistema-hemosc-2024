package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class cCidades {
    
    public void ExcluirCidades(mCidades modelCidades){
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
