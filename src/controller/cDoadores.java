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
import model.mCidades;
import model.mDoadores;
import model.mTipoSanguineo;

/**
 *
 * @author gabriel.oliveira38
 */
public class cDoadores {

    public List<mDoadores> pesquisar(String texto, int filtro) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mDoadores> lista = new ArrayList<>();

        try {

            if (filtro == 0) {
                stmt = conn.prepareStatement("SELECT * FROM doadores WHERE id_doador = ?");
                stmt.setString(1, texto);
                rs = stmt.executeQuery();
            } else {
                stmt = conn.prepareStatement("SELECT * FROM doadores WHERE nome like ? ");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }

            while (rs.next()) {
                mDoadores modelE = new mDoadores();
                modelE.setId_doadores(rs.getInt("id_doador"));
                modelE.setNome(rs.getString("nome"));
                modelE.setEndereco(rs.getString("endereco"));
                modelE.setDataNasc(rs.getDate("data_nascimento"));
                modelE.setTelefone(rs.getString("telefone"));
                modelE.setEmail(rs.getString("email"));
                modelE.setCpf(rs.getString("cpf"));

                lista.add(modelE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void cadastrar(mDoadores modelA) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO autores (nome,endereco,numero,bairro,cidade,cpf) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, modelA.getNome());
            stmt.setString(2, modelA.getEndereco());
            //stmt.setString(3, modelA.getNumero());
            ///stmt.setString(4, modelA.getBairro());
            //stmt.setString(5, modelA.getCidade());
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

        List<mDoadores> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM doadores");

            while (rs.next()) {
                mDoadores modelE = new mDoadores();
                modelE.setId_doadores(rs.getInt("id_doadores"));
                modelE.setNome(rs.getString("nome"));
                modelE.setEndereco(rs.getString("endereco"));
                modelE.setTelefone(rs.getString("numero"));
                modelE.setCpf(rs.getString("cpf"));
                modelE.setEmail(rs.getString("cpf"));
                
                mCidades modelC = new mCidades();
                modelC.setId_cidade(rs.getInt("fk_cidades_id_cidade"));
                
                
                mTipoSanguineo modelT = new mTipoSanguineo();
                modelT.setId_tipo_sanguineo(rs.getInt("fk_TipoSanguino_id_tipo_sanguineo"));

                modelE.setFkIdCidades(modelC);
                modelE.setFkIdTipoSangue(modelT);

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public void alterar(cDoadores modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE doador SET nome = ?, endereco = ?, bairro = ?, numero = ?, cidade = ?, cpf = ? WHERE id_doador = ? ");
            //stmt.setString(1, modelE.getNome());
            //stmt.setString(2, modelE.getEndereco());
           //stmt.setString(3, modelE.getBairro());
           // stmt.setString(4, modelE.getNumero());
           // stmt.setString(5, modelE.getCidade());
           // stmt.setString(6, modelE.getCpf());
           // stmt.setInt(7, modelE.getId_autor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador(a) alterado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class
                    .getName()).log(Level.SEVERE, null,
                            ex);
        }

    }

}
