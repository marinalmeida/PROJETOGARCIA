/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import projeto.dao.CargoDao;
import projeto.dao.TipoUsuarioDao;
import projeto.dao.UsuarioDao;
import projeto.dao.UsuarioTipoUsuarioCargoDao;
import projeto.model.Cargo;
import projeto.model.TipoUsuario;
import projeto.model.Usuario;

/**
 *
 * @author suporte
 */
public class UsuarioController {
    
    private final Cargo model_cargo;
    private final TipoUsuario model_tipo_usuario;
    private final Usuario model_usuario;
    
    public UsuarioController(){
        model_cargo = new Cargo();
        model_tipo_usuario = new TipoUsuario();
        model_usuario = new Usuario();
    }
    
    public void registrar(UsuarioDao usuario, TipoUsuarioDao tipo_usuario, CargoDao cargo)  {
        
        if(model_usuario.registrar(usuario, tipo_usuario, cargo)){
            JOptionPane.showMessageDialog(null, "\n***** Usuário adicionado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao adicionar usuário *****");
        }
        
    }
    
    public void atualizar(UsuarioDao usuario, TipoUsuarioDao tipo_usuario, CargoDao cargo){       
        
        if(model_usuario.atualizar(usuario, tipo_usuario, cargo)){
            JOptionPane.showMessageDialog(null, "\n***** Usuario atualizado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao usuario Cargo *****");
        }
        
    }
    
    public void selecionar(int id){       
               
        UsuarioTipoUsuarioCargoDao data = model_usuario.selecionar(id);       
         
        if(data != null){
            JOptionPane.showMessageDialog(null, "\n***** DADOS *****\n"+data.toString());
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao selecionar usuario *****");
        }
        
        
    }
    
    public String listar(String nome){       
               
        ArrayList<UsuarioTipoUsuarioCargoDao> data = model_usuario.listar(nome);         
        String list = "\n***** DADOS *****\n";
        
        if(data != null){
            for(UsuarioTipoUsuarioCargoDao i : data) {
                list += i.toString() + "\n";
            }  
            
        }else{
            list = "\n***** Erro ao listar Usuario *****";
        }
        
        return list;
    }
    
    public void deletar(int id){           
        
        if(model_usuario.deletar(id)){
            JOptionPane.showMessageDialog(null, "\n***** Usuario deletado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao deletar usuario *****");
        }
        
    } 
}
