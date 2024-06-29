
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel.montibeller
 */
public class mTipoSanguineo {
    private int id_tipo_sanguineo;
    private String descricao;
    private String fator_rh;
    private int estoque;
    private int estoque_minimo;

    public int getId_tipo_sanguineo() {
        return id_tipo_sanguineo;
    }

    public void setId_tipo_sanguineo(int id_tipo_sanguineo) {
        this.id_tipo_sanguineo = id_tipo_sanguineo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFator_rh() {
        return fator_rh;
    }

    public void setFator_rh(String fator_rh) {
        this.fator_rh = fator_rh;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }
}
