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
import model.mAgendamentos;
import model.mDoadores;

/**
 *
 * @author gabriel.montibeller
 */
public class cAgendamentos {

    public void excluir(mAgendamentos modele) {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM agendamento WHERE  = ?");
            stmt.setInt(1, modele.getId_Agendamento());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(cAgendamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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
