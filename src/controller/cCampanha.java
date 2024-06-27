/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mCampanha;

/**
 *
 * @author rafael.tolomeotti
 */
public class cCampanha {

        public List<mCampanha> listar() {

        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mCampanha> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM campanha");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mCampanha modelE;
                modelE = new mCampanha();
                modelE.setId_campanha(rs.getInt("id_campanha"));
                modelE.setNome(rs.getString("nome"));

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cCampanha.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }
    
public List<mCampanha> listarCampanhas() {
    List<mCampanha> campanhas = new ArrayList<>();

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_sangue", "root", "root");
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT id_campanha, nome, data_inicio, data_fim FROM campanha");

        while (rs.next()) {
            int idCampanha = rs.getInt("id_campanha");
            String nomeCampanha = rs.getString("nome");
            String dataInicio = rs.getString("data_inicio");
            String dataFim = rs.getString("data_fim");

            mCampanha campanha = new mCampanha();
            campanha.setId_campanha(idCampanha);
            campanha.setNome(nomeCampanha);
            campanha.setDataInicio(dataInicio);
            campanha.setDataFim(dataFim);


            campanhas.add(campanha);
        }
    } catch (SQLException e) {
        System.out.println("Erro ao listar campanhas: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar recursos: " + e.getMessage());
        }
    }

    return campanhas;
}
        
        
    public void cadastrar(mCampanha modelE) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = mysql.conexao();
            stmt = conn.prepareStatement("INSERT INTO campanha (nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?)");
            stmt.setString(1, modelE.getNome());
            stmt.setString(2, modelE.getDescricao());
            stmt.setString(3, modelE.getDataInicio());
            stmt.setString(4, modelE.getDataFim());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException ex) {
            // Tratar exceção SQL
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());

        } finally {
            // Fechar recursos
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Iterable<mCampanha> pesquisar(String text, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
