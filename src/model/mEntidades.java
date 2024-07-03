/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabriel.oliveira38
 */
public class mEntidades {

    private int id_entidades;
    private mCidades cidades;
    private String nome;
    private String endereco;

    public int getId_entidades() {
        return id_entidades;
    }

    public void setId_entidades(int id_entidades) {
        this.id_entidades = id_entidades;
    }

    public mCidades getCidades() {
        return cidades;
    }

    public void setCidades(mCidades cidades) {
        this.cidades = cidades;
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

    @Override
    public String toString() {
        return getNome();
    }
}
