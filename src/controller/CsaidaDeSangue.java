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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.mEntidades;
import model.mSaidasDeSangue;
import model.mTiposanguineo;

/**
 *
 * @author heber.gutierrez
 */
public class CsaidaDeSangue {

    public List<mSaidasDeSangue> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mSaidasDeSangue> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT  * FROM saida_sangue ");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mSaidasDeSangue modelE = new mSaidasDeSangue();
                modelE.setId_saida_sangue(rs.getInt("id_saida_sangue"));

                mEntidades model = new mEntidades();
                model.setId_entidades(rs.getInt("id_entidade"));
                modelE.setEntidades(model);

                mTiposanguineo modelT = new mTiposanguineo();
                modelT.setId_tipo_sanguíneo(rs.getInt("id_tipo_sanguineo"));

                modelE.setTipo_sanguineo(modelT);

                modelE.setData(rs.getDate("data"));
                modelE.setQuantidade(rs.getString("quantidade"));

                list.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CsaidaDeSangue.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return list;

    }
}
