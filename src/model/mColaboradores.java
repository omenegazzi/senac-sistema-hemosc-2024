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
public class mColaboradores {
    private int id_colaborador;
    private int fk_cidades_id_cidade;
    private String nome;
    private String endereco;
    private String funcao;

    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public int getFk_cidades_id_cidade() {
        return fk_cidades_id_cidade;
    }

    public void setFk_cidades_id_cidade(int fk_cidades_id_cidade) {
        this.fk_cidades_id_cidade = fk_cidades_id_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
}
