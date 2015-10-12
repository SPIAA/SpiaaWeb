package spiaa.model.entity;

import spiaa.model.base.BaseEntity;

/**
 *
 * @author Felipe de Souza
 */
public class Parametros extends BaseEntity {

    private String smtp;
    private String caminhoHostName;
    private Integer porta;
    private String email;
    private String senha;

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCaminhoHostName() {
        return caminhoHostName;
    }

    public void setCaminhoHostName(String caminhoHostName) {
        this.caminhoHostName = caminhoHostName;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

}
