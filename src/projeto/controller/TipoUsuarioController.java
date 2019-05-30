/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import projeto.model.TipoUsuario;
import projeto.dao.TipoUsuarioDao;
/**
 *
 * @author suporte
 */
public class TipoUsuarioController {
    
    private TipoUsuario model_tipo_usuario;
    private TipoUsuarioDao data_tipo_usuario;
    
    public TipoUsuarioController(){
        model_tipo_usuario = new TipoUsuario();
    }
    
    public void registrar(TipoUsuarioDao tipo_usuario){           
        
        if(model_tipo_usuario.registrar(tipo_usuario)){
            System.out.println("\n***** Tipo usuario adicionado com suscesso *****");
        }else{
            System.out.println("\n***** Erro ao adicionar tipo usuário *****");
        }
        
    }  
    
    public void atualizar(TipoUsuarioDao tipo_usuario){       
        
        if(model_tipo_usuario.atualizar(tipo_usuario)){
            System.out.println("\n***** Tipo usuario atualizado com suscesso *****");
        }else{
            System.out.println("\n***** Erro ao atualizar tipo usuário *****");
        }
        
    }  
    
    public void selecionar(int id){       
               
        TipoUsuarioDao data = model_tipo_usuario.selecionar(id);       
        
        if(data != null){
            System.out.println("\n***** DADOS *****");
            System.out.println(data.toString());    
        }else{
            System.out.println("\n***** Erro ao selecionar tipo usuário *****"); 
        }
        
        
    }  
    
    public void listar(String nome){       
               
        ArrayList<TipoUsuarioDao> data = model_tipo_usuario.listar(nome);         
        System.out.println("\n***** DADOS *****");
        
        if(data != null){
            for(TipoUsuarioDao i : data) {
                System.out.println(i.toString());
            }  
        }else{
            System.out.println("\n***** Erro ao listar tipo usuário *****"); 
        }
              
    }  
    
    public void deletar(int id){           
        
        if(model_tipo_usuario.deletar(id)){
            System.out.println("\n***** Tipo usuario deletado com suscesso *****");
        }else{
            System.out.println("\n***** Erro ao deletado tipo usuário *****");
        }
        
    }  
}
