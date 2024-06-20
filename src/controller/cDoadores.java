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
                modelE.setId_doador(rs.getInt("id_doador"));
                modelE.setNome(rs.getString("nome"));
                modelE.setEndereco(rs.getString("endereco"));
                modelE.setData_nascimento(rs.getString("data_nascimento"));
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

}
