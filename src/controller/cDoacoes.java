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
import model.mColaboradores;
import model.mDoacoes;
import model.mDoadores;
import model.mTiposanguineo;

/**
 *
 * @author ana.matos4
 */
public class cDoacoes {

    public List<mDoacoes> listar() {
        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<mDoacoes> lista = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select* from doacoes");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mDoacoes modele = new mDoacoes();
                modele.setId_doacao(rs.getInt("id_doacoes"));
                modele.setData(rs.getDate("data"));

                mDoadores modelD = new mDoadores();
                modelD.setId_doadores(rs.getInt("id_doador"));
                modele.setDoadores(modelD);

                mTiposanguineo modelT = new mTiposanguineo();
                modelT.setId_tipo_sanguíneo(rs.getInt("id_tipo_sanguineo"));
                modele.setTiposanguineo(modelT);

                mColaboradores modelC = new mColaboradores();
                modelC.setId_colaborador(rs.getInt("colaboradores"));
                lista.add(modele);
            }

        } catch (SQLException ex) {
            Logger.getLogger(mDoacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public void cadastrar(mDoacoes doacoes) {
        Connection conn = mysql.conexao();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO doacoes ( data, id_doador, id_tipo_sanguineo,id_colaborador) VALUES (?, ?, ?, ?, ?)");
            stmt.setDate(1, doacoes.getData());
            stmt.setInt(2, doacoes.getDoadores().getId_doadores());
            stmt.setInt(3, doacoes.getTiposanguineo().getId_tipo_sanguíneo());
            stmt.setInt(4, doacoes.getColaborador().getId_colaborador());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Doação cadastrada com sucesso !");

        } catch (SQLException ex) {
            Logger.getLogger(cDoacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<mDoacoes> pesquisar(String texto, int filtro) {

        Connection conn = mysql.conexao();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<mDoacoes> lista = new ArrayList<>();

        try {

            if (filtro == 0) {
                stmt = conn.prepareStatement("SELECT * FROM doacoes WHERE id_doacao = ?");
                stmt.setString(1, texto);
                rs = stmt.executeQuery();
            } else {
                stmt = conn.prepareStatement("SELECT * FROM doacoes WHERE nome LIKE ?");
                stmt.setString(1, "%" + texto + "%");
                rs = stmt.executeQuery();
            }

            stmt = conn.prepareStatement("SELECT ( id_doacao, data, id_doador, id_tipo_sanguineo, id_colaborador) VALUES\n" + "WHERE nome LIKE ?");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                mDoacoes modelE = new mDoacoes();
                modelE.setId_doacao(rs.getInt("id_doacao"));
                modelE.setData(rs.getDate("data"));

                mDoadores modelD = new mDoadores();
                modelD.setId_doadores(rs.getInt("id_doador"));
                modelE.setDoadores(modelD);

                mTiposanguineo modelB = new mTiposanguineo();
                modelB.setId_tipo_sanguíneo(rs.getInt("id_tipo_sanguineo"));
                modelE.setTiposanguineo(modelB);

                mColaboradores modelC = new mColaboradores();
                modelC.setId_colaborador(rs.getInt("id_colaborador"));
                modelE.setColaborador(modelC);

                lista.add(modelE);

            }

        } catch (SQLException ex) {
            Logger.getLogger(cDoacoes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
}
