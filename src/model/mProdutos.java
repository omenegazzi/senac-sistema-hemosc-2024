/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author mauro.vargas
 */
public class mProdutos {
   
    private int id_produto;
    private String descricao;
    private String tipo;
    private Date data_aquisicao;
    private String estado;
    private Date data_ultima_manutencao;
    
    
    
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getData_ultima_manutencao() {
        return data_ultima_manutencao;
    }

    public void setData_ultima_manutencao(Date data_ultima_manutencao) {
        this.data_ultima_manutencao = data_ultima_manutencao;
    }
        
    
    
}
