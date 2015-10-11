/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.base.service;

import java.util.List;
import spiaa.model.base.BaseService;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author Felipe de Souza
 */
public interface BaseUsuarioBairroService extends BaseService<UsuarioBairro> {

    public void deleteByUsuarioId(Long id) throws Exception;

    public void deleteByBairroId(Long id) throws Exception;

    public void createByUsuario(List<UsuarioBairro> usuarioBairroList) throws Exception;
    
    public void createByBairro(List<UsuarioBairro> usuarioBairroList) throws Exception;
}
