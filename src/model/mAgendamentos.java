package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author erica.matos1
 */
public class mAgendamentos {
    private int id_Agendamento;
    private mDoadores doadores;
    private Date data;
    private Time hora;

    public int getId_Agendamento() {
        return id_Agendamento;
    }

    public void setId_Agendamento(int id_Agendamento) {
        this.id_Agendamento = id_Agendamento;
    }

    public mDoadores getDoadores() {
        return doadores;
    }

    public void setDoadores(mDoadores doadores) {
        this.doadores = doadores;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
    
    
    
    
    
}
