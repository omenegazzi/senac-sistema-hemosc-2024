package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mDoadores;
import model.mExames;

public class cExames {
        public void cadastrar(mExames modelE) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO autores (fk_doadores_id_doador, doacoes, tipo_exame, resultado, data_exame) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, modelE.getDoador().getId_doadores());
            stmt.setString(2, modelE.getDoacoes());
            stmt.setString(3, modelE.getTipo_exame());
            stmt.setString(4, modelE.getResultado());
            stmt.setDate(5, (java.sql.Date) modelE.getData_exame()); 
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cExames.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<mExames> listar() {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mExames> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM exames");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mExames modelE = new mExames();
                modelE.setId_exame(rs.getInt("id_exame"));
                
                mDoadores modelD = new mDoadores();
                modelD.setId_doadores(rs.getInt("fk_doadores_id_doador"));
                modelE.setDoador(modelD);            
                
                modelE.setDoacoes(rs.getString("doacoes"));
                modelE.setTipo_exame(rs.getString("tipo_exame"));
                modelE.setResultado(rs.getString("resultado"));
                modelE.setData_exame(rs.getDate("data_exame"));
                                
                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cExames.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public List<mExames> pesquisar(String texto, int filtro) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mExames> lista = new ArrayList<>();

        try {
        
            if (filtro == 0) {
                stmt = conn.prepareStatement("SELECT * From exames WHERE id_exame = ?");
                stmt.setString(1, texto);
                rs = stmt.executeQuery();
            } 
            else if(filtro == 1){
                stmt = conn.prepareStatement("SELECT * From exames WHERE fk_doadores_id_doador like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 2){
                stmt = conn.prepareStatement("SELECT * From autores WHERE doacoes like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else {
                stmt = conn.prepareStatement("SELECT * From autores WHERE data_exame like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }

            while (rs.next()) {
                mExames modelE = new mExames();
                modelE.setId_exame(rs.getInt("id_exame"));
                
                mDoadores modelD = new mDoadores();
                modelD.setId_doadores(rs.getInt("fk_doadores_id_doador"));
                modelE.setDoador(modelD);
                
                modelE.setDoacoes(rs.getString("doacoes"));
                modelE.setTipo_exame(rs.getString("tipo_exame"));
                modelE.setResultado(rs.getString("resultado"));
                modelE.setData_exame(rs.getDate("data_exame"));
                
                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cExames.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
        
    } 
    
    public void alterar(mExames modelE) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE exames SET doacoes = ?, tipo_exame = ?, resultado = ?, data_exame = ?, WHERE id_exame = ?");
            stmt.setInt(1, modelE.getDoador().getId_doadores());
            stmt.setString(2, modelE.getDoacoes());
            stmt.setString(3, modelE.getTipo_exame());
            stmt.setString(4, modelE.getResultado());
            stmt.setDate(5, (java.sql.Date) (Date) modelE.getData_exame());
            stmt.setInt(6, modelE.getId_exame());           
          
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cExames.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void excluir(mExames modelE) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM exames WHERE id_exame = ?");
            stmt.setInt(1, modelE.getId_exame());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cExames.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
