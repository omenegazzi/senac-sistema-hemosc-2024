/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author rafael.tolomeotti
 */
public class mCampanha {

    private int id_campanha;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;

    public void setDataInicio(String text) {
        this.dataInicio = text;
    }

    public void setDataFim(String text) {
        this.dataFim = text;
    }

    public void setId_campanha(int id_campanha) {
        this.id_campanha = id_campanha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }
    public int getId_campanha() {
        return id_campanha;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
