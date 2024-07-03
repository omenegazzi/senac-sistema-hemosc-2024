/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author yasmim.oliveira3
 */
public class mChecklist {
    private int id_checklist;
    private Boolean resposta;
    private mPerguntas pergunta;
    private mDoadores doador;

    public int getId_checklist() {
        return id_checklist;
    }

    public void setId_checklist(int id_checklist) {
        this.id_checklist = id_checklist;
    }

    public Boolean getResposta() {
        return resposta;
    }

    public void setResposta(Boolean resposta) {
        this.resposta = resposta;
    }

    public mPerguntas getPergunta() {
        return pergunta;
    }

    public void setPergunta(mPerguntas pergunta) {
        this.pergunta = pergunta;
    }
    
    public int getIdPergunta() {
        return getPergunta().getId_pergunta();
    }
    
    public int setIdPergunta() {
        return getPergunta().getId_pergunta();
    }

    public mDoadores getDoador() {
        return doador;
    }

    public void setDoador(mDoadores doador) {
        this.doador = doador;
    }
    
    @Override
    public String toString() {
        return getPergunta().getDescricao();
    }
    

}
