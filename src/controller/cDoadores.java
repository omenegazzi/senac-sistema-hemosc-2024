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
import java.util.Date;

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
                stmt = conn.prepareStatement("SELECT * FROM doadores WHERE nome like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 1){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE id_doador = ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 2){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE cpf like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            } 
            else if(filtro == 3){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE fk_TipoSanguino_id_tipo_sanguineo like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 4){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE data_nascimento like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 5){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE fk_cidades_id_cidade like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 6){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE endereco like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else if(filtro == 7){
                stmt = conn.prepareStatement("SELECT * From doadores WHERE email like ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }
            else {
                stmt = conn.prepareStatement("SELECT * FROM doadores WHERE telefone like ? ");
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
            stmt = conn.prepareStatement("INSERT INTO autores (nome, cpf, data_nascimento, fk_TipoSanguino_id_tipo_sanguineo, fk_cidades_id_cidade, endereco, "
                    + "email, telefone) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1, modelA.getNome());
            stmt.setString(2, modelA.getCpf());
            stmt.setDate(3, modelA.getDataNasc());
            stmt.setInt(4, modelA.getFkIdTipoSangue().getId_tipo_sanguineo());
            stmt.setInt(5, modelA.getFkIdCidades().getId_cidade());
            stmt.setString(6, modelA.getEndereco());
            stmt.setString(7, modelA.getEmail());
            stmt.setString(8, modelA.getTelefone());

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
            rs = stmt.executeQuery();

            while (rs.next()) {
                mDoadores modelE = new mDoadores();
                modelE.setId_doadores(rs.getInt("id_doador"));
                modelE.setNome(rs.getString("nome"));
                modelE.setEndereco(rs.getString("endereco"));
                modelE.setTelefone(rs.getString("telefone"));
                modelE.setCpf(rs.getString("cpf"));
                modelE.setEmail(rs.getString("email"));
                
                mCidades modelC = new mCidades();
                modelC.setId_cidade(rs.getInt("id_cidade"));
                
                
                mTipoSanguineo modelT = new mTipoSanguineo();
                modelT.setId_tipo_sanguineo(rs.getInt("id_tipo_sanguineo"));

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

    public void alterar(mDoadores modelE) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("UPDATE doador SET nome = ?, cpf = ?, data_de_nascimento = ?, fk_TipoSanguino_id_tipo_sanguineo = ?, fk_cidades_id_cidade = ?, "
                    + "endereco = ?, email = ?, telefone = ? WHERE id_doador = ? ");
            stmt.setString(1, modelE.getNome());
            stmt.setString(2, modelE.getCpf());
            stmt.setDate(3, modelE.getDataNasc());
            stmt.setInt(4, modelE.getFkIdTipoSangue().getId_tipo_sanguineo());
            stmt.setInt(5, modelE.getFkIdCidades().getId_cidade());
            stmt.setString(6, modelE.getEndereco());
            stmt.setString(7, modelE.getEmail());
            stmt.setString(8, modelE.getTelefone());
            stmt.setInt(9, modelE.getId_doadores());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doador(a) alterado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cDoadores.class
                    .getName()).log(Level.SEVERE, null,
                            ex);
        }

    }

}
