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

/**
 *
 * @author gabriel.oliveira38
 */
public class cTipoSanguineo {
     public List<mTiposSanguineo> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mCTipoSanguineo> lista = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM tipos_sanguineo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mTiposSanguineo modelE = new  mTiposSanguineo();
                modelE.setId_tipo_sanguineo(rs.getInt("id_tipo_sanguineo"));
                modelE.setdescricao(rs.getString("descricao"));
                modelE.setfator_rh(rs.getString("fator_rh"));
                modelE.setestoque(rs.getString("estoque"));
                modelE.setestoque_minimo(rs.getString("estoque_minimo"));

                lista.add(modelE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(cTiposSanguineo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
}
