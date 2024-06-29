package model;

import java.util.Date;

public class mExames {
    private int id_exame;
    private String tipo_exame;
    private String resultado;
    private Date data_exame;
    private mDoadores Doador;
    private String Doacoes;

    public int getId_exame() {
        return id_exame;
    }

    public void setId_exame(int id_exame) {
        this.id_exame = id_exame;
    }

    public String getTipo_exame() {
        return tipo_exame;
    }

    public void setTipo_exame(String tipo_exame) {
        this.tipo_exame = tipo_exame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getData_exame() {
        return data_exame;
    }

    public void setData_exame(Date data_exame) {
        this.data_exame = data_exame;
    }

    public mDoadores getDoador() {
        return Doador;
    }

    public void setDoador(mDoadores Doador) {
        this.Doador = Doador;
    }

    public String getDoacoes() {
        return Doacoes;
    }

    public void setDoacoes(String Doacoes) {
        this.Doacoes = Doacoes;
    }
   
}
