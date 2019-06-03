/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;

import projeto.dao.CargoDao;
import projeto.dao.TipoUsuarioDao;
import projeto.dao.UsuarioDao;

/**
 *
 * @author DTGI
 */
public class UsuarioTipoUsuarioCargoDao {
    
    CargoDao cargo;
    TipoUsuarioDao tipo_usuario;
    UsuarioDao usuario;
    
    public UsuarioTipoUsuarioCargoDao(CargoDao cargo, TipoUsuarioDao tipo_usuario, UsuarioDao usuario){
        this.cargo = cargo;
        this.tipo_usuario = tipo_usuario;
        this.usuario = usuario;
    }
    
    public CargoDao getCargo(){
        return this.cargo;
    }
    
    public TipoUsuarioDao getTipoUsuario(){
        return this.tipo_usuario;
    }
    
    public UsuarioDao getUsuario(){
        return this.usuario;
    }
    
    @Override
    public String toString() {
        return "Id: " + this.usuario.getId() + 
               ", Nome: " + this.usuario.getNome() + 
               ", Email: " + this.usuario.getEmail() +
               ", Cargo: " + this.cargo.getNome()+ 
               ", Tipo: " + this.tipo_usuario.getNome();
    }
}
