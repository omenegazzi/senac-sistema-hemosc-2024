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
import model.mDoadores;

/**
 *
 * @author guest01
 */
public class cDoadores {

    public void cadastrar(mDoadores modelA) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO autores (nome,endereco,numero,bairro,cidade,cpf) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, modelA.getNome());
            stmt.setString(2, modelA.getEndereco());
            stmt.setString(3, modelA.getNumero());
            stmt.setString(4, modelA.getBairro());
            stmt.setString(5, modelA.getCidade());
            stmt.setString(6, modelA.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador(a) cadastrado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<mDoadores> listar() {

        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<cDoadores> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM doadores")

            while (rs.next()) {
                mDoadores modelE = new mDoadores();
                modelE.setId_autor(rs.getInt("id_autor"));
                modelE.setNome(rs.getString("nome"));
                modelE.setEndereco(rs.getString("endereco"));
                modelE.setBairro(rs.getString("bairro"));
                modelE.setNumero(rs.getString("numero"));
                modelE.setCidade(rs.getString("cidade"));
                modelE.setCpf(rs.getString("cpf"));

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

 
    
    }

    public void alterar(cDoadores modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE doador SET nome = ?, endereco = ?, bairro = ?, numero = ?, cidade = ?, cpf = ? WHERE id_doador = ? ");
            stmt.setString(1, modelE.getNome());
            stmt.setString(2, modelE.getEndereco());
            stmt.setString(3, modelE.getBairro());
            stmt.setString(4, modelE.getNumero());
            stmt.setString(5, modelE.getCidade());
            stmt.setString(6, modelE.getCpf());
            stmt.setInt(7, modelE.getId_autor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador(a) alterado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

    }
}
   