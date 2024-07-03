/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.mysql;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fagner.bussacro
 */
public class cRelPeriodoData {

    public static void gerarPdf() {
        Connection conn = mysql.conexao();
        JasperPrint jasperPrint = null;
        try {
            JasperReport relatorioCompilado
                    = JasperCompileManager.compileReport("src/relatorios/relatorio-periodo-data.jrxml");
            jasperPrint = JasperFillManager.fillReport(relatorioCompilado, null, conn);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio");
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
    }

}
