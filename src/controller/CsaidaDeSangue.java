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
import model.mEntidades;
import model.mSaidasDeSangue;
import model.mTipoSanguineo;

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

                mTipoSanguineo modelT = new mTipoSanguineo();
                modelT.setId_tipo_sanguineo(rs.getInt("id_tipo_sanguineo"));

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

    public List<mSaidasDeSangue> pesquisar(String texto, int filtro) {

        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mSaidasDeSangue> lista = new ArrayList<>();

        try {

            switch (filtro) {
                case 0:
                    stmt = conn.prepareStatement("SELECT * FROM saida_sangue WHERE id_saida_sangue like ?");
                    break;
                case 1:
                    stmt = conn.prepareStatement("SELECT * FROM saida_sangue WHERE entidades like ?");
                    break;
                case 2:
                    stmt = conn.prepareStatement("SELECT * FROM saida_sangue WHERE tipo_sanguineo like ?");
                    break;
                case 3:
                    stmt = conn.prepareStatement("SELECT * FROM saida_sangue WHERE data like ?");
                    break;
                case 4:
                    stmt = conn.prepareStatement("SELECT * FROM saida_sangue WHERE quantidade like ?");
                    break;
            }
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mSaidasDeSangue modelE = new mSaidasDeSangue();
                modelE.setId_saida_sangue(rs.getInt("id_saida_sangue"));

                mEntidades entidade = new mEntidades();
                entidade.setId_entidades(rs.getInt("id_entidade"));
                modelE.setEntidades(entidade);

                mTipoSanguineo TipoSanguineo = new mTipoSanguineo();
                TipoSanguineo.setId_tipo_sanguineo(rs.getInt("id_tipo_sanguineo"));
                modelE.setTipo_sanguineo(TipoSanguineo);

                modelE.setData(rs.getDate("data"));
                modelE.setQuantidade(rs.getString("quantidade"));

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CsaidaDeSangue.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }
}
