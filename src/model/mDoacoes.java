/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;



/**
 *
 * @author gabriel.oliveira38
 */
public class mDoacoes {
   private int id_doacao;
   private Date data;
   private mDoadores doadores;
   private mTipoSanguineo tiposanguineo;
   private mColaboradores colaborador;

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public mDoadores getDoadores() {
        return doadores;
    }

    public void setDoadores(mDoadores doadores) {
        this.doadores = doadores;
    }

    public mTipoSanguineo getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(mTipoSanguineo tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public mColaboradores getColaborador() {
        return colaborador;
    }

    public void setColaborador(mColaboradores colaborador) {
        this.colaborador = colaborador;
    }
}
