/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.entity;

import spiaa.model.base.BaseEntity;

public class Quarteirao extends BaseEntity {

  private String Descricao;
  private Bairro bairro;

  public String getDescricao() {
    return Descricao;
  }

  public void setDescricao(String Descricao) {
    this.Descricao = Descricao;
  }

  public Bairro getBairro() {
    return bairro;
  }

  public void setBairro(Bairro bairro) {
    this.bairro = bairro;
  }

}
