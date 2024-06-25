package model;

import java.sql.Date;

/**
 *
 * @author erica.matos1
 */
public class mSaidasDeSangue {
    private int id_saida_sangue;
    private mEntidades entidades;
    private mTiposanguineo tipo_sanguineo;
    private Date data;
    private String quantidade;

    public int getId_saida_sangue() {
        return id_saida_sangue;
    }

    public void setId_saida_sangue(int id_saida_sangue) {
        this.id_saida_sangue = id_saida_sangue;
    }

    public mEntidades getEntidades() {
        return entidades;
    }

    public void setEntidades(mEntidades entidades) {
        this.entidades = entidades;
    }

    public mTiposanguineo getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(mTiposanguineo tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
