/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.mProdutos;

/**
 *
 * @author mauro.vargas
 */
public class cProdutos2 {
    public void cadastrar(mProdutos modelPr) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO produtos (nome,endereco,numero,bairro,cidade) VALUES (?,?,?,?,?)");
            stmt.setString(1, modelPr.getDescricao());
            stmt.setString(2, modelPr.getTipo());
            stmt.setDate(3, modelPr.getData_aquisicao());
            stmt.setString(4, modelPr.getEstado());
            stmt.setDate(5, modelPr.getData_ultima_aquisicao());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produtos cadastrados com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(mProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
