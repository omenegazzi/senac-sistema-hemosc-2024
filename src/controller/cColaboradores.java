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
import model.mColaboradores;

/**
 *
 * @author gabriel.oliveira38
 */
public class cColaboradores {

    public List<mColaboradores> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mColaboradores> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM id_colaborador");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mColaboradores modelE = new mColaboradores();
                modelE.setId_colaborador(rs.getInt("id_colaborador"));
                modelE.setNome(rs.getString("nome"));
                modelE.setEndereco(rs.getString("endereco"));
                modelE.setFuncao(rs.getString("funcao"));
                mCidades Cidades = new mCidades();

                lista.add(modelE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(cColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void alterar(mColaboradores modele) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("UPDATE colaboradores set nome = ? where id_colaborador =?");
            stmt.setInt(1, modele.getId_colaborador());
            stmt.setInt(2, modele.getFk_cidades_id_cidade());
            stmt.setString(3, modele.getNome());
            stmt.setString(4, modele.getEndereco());
            stmt.setString(5, modele.getFuncao());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "colaborador alterado com sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(centidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(mColaboradores modele) {

        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM colaboradores WHERE id_colaborador = ?");
            stmt.setInt(1, modele.getId_colaborador());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Colaborador excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Colaborador não encontrado.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(cColaboradores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
