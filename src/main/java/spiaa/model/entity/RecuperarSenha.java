/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.entity;

import java.sql.Timestamp;
import spiaa.model.base.BaseEntity;

/**
 *
 * @author Felipe de Souza
 */
public class RecuperarSenha extends BaseEntity{
    
    private Usuario usuario;
    private String token;
    private Timestamp dataPedido;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Timestamp dataPedido) {
        this.dataPedido = dataPedido;
    }
}
