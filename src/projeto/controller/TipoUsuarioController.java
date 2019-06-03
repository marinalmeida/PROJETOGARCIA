/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import projeto.model.TipoUsuario;
import projeto.dao.TipoUsuarioDao;
/**
 *
 * @author suporte
 */
public class TipoUsuarioController {
    
    private final TipoUsuario model_tipo_usuario;
    
    public TipoUsuarioController(){
        model_tipo_usuario = new TipoUsuario();
    }
    
    public void registrar(TipoUsuarioDao tipo_usuario){           
        
        if(model_tipo_usuario.registrar(tipo_usuario)){
            JOptionPane.showMessageDialog(null, "\n***** Tipo usuario adicionado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao adicionar tipo usuário *****");
        }
        
    }  
    
    public void atualizar(TipoUsuarioDao tipo_usuario){       
        
        if(model_tipo_usuario.atualizar(tipo_usuario)){
            JOptionPane.showMessageDialog(null, "\n***** Tipo usuario atualizado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao atualizar tipo usuário *****");
        }
        
    } 
    
    public boolean existe(int id){       
               
        TipoUsuarioDao data = model_tipo_usuario.selecionar(id); 
        
        if(data != null){
            return true;
        }
        
        return false;
    }  
    
    public void selecionar(int id){       
               
        TipoUsuarioDao data = model_tipo_usuario.selecionar(id);       
        
        if(data != null){
            JOptionPane.showMessageDialog(null, "\n***** DADOS *****\n"+data.toString());
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao selecionar tipo usuário *****");
        }
        
        
    }  
    
    public String listar(String nome){       
               
        ArrayList<TipoUsuarioDao> data = model_tipo_usuario.listar(nome);       
        String list = "\n***** DADOS *****\n";
        
        if(data != null){
            for(TipoUsuarioDao i : data) {
                list += i.toString() + "\n";
            }  
            
            return list;
        }else{
            list = "\n***** Erro ao listar tipo usuário *****";
        }
        
        return list;
    }
    
    public ArrayList<TipoUsuarioDao> listar(){       
               
        return model_tipo_usuario.listar(null);
              
    }  
    
    public void deletar(int id){           
        
        if(model_tipo_usuario.deletar(id)){
            JOptionPane.showMessageDialog(null, "\n***** Tipo usuario deletado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao deletado tipo usuário *****");
        }
        
    }  
}
