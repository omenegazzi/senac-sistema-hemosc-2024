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
}
    
