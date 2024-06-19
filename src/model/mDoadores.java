package model;

import java.sql.Date;

/**
 *
 * @author fagner.bussacro
 */
public class mDoadores {

    private int id_doadores;
    private mCidades fkIdCidades;
    private mTipoSanguineo fkIdTipoSangue;
    private String nome;
    private String endereco;
    private Date dataNasc;
    private String telefone;
    private String email;
    private String cpf;

    public int getId_doadores() {
        return id_doadores;
    }

    public void setId_doadores(int id_doadores) {
        this.id_doadores = id_doadores;
    }

    public mCidades getFkIdCidades() {
        return fkIdCidades;
    }

    public void setFkIdCidades(mCidades fkIdCidades) {
        this.fkIdCidades = fkIdCidades;
    }

    public mTipoSanguineo getFkIdTipoSangue() {
        return fkIdTipoSangue;
    }

    public void setFkIdTipoSangue(mTipoSanguineo fkIdTipoSangue) {
        this.fkIdTipoSangue = fkIdTipoSangue;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
