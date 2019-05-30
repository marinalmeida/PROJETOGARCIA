/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.sql.SQLException;
import projeto.model.Usuario;
import projeto.dao.UsuarioDao;
/**
 *
 * @author suporte
 */
public class UsuarioController {
    
    public void registrar() throws SQLException, ClassNotFoundException{
        Usuario model_usuario;
        UsuarioDao data_usuario;
        
        data_usuario = new UsuarioDao("OSMARINA BANANA", 55, "osmarinabanana@banana.com.br", 10);
        model_usuario = new Usuario();
        
        if(model_usuario.registrar(data_usuario)){
            
        }else{
            System.out.println("Tabela criada com sucesso");
        }
        
    }  
}
