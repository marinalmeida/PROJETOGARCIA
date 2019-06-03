
package projeto.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import projeto.dao.CargoDao;
import projeto.dao.TipoUsuarioDao;
import projeto.model.Cargo;


public class CargoController {
    
    private final Cargo model_cargo;
    
    public CargoController(){
        model_cargo = new Cargo();
    }
    
    public void registrar(CargoDao cargo){           
        
        if(model_cargo.registrar(cargo)){
            JOptionPane.showMessageDialog(null, "\n***** Cargo atualizado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao adicionar Cargo *****");
        }
        
    } 
    
    public void atualizar(CargoDao cargo){       
        
        if(model_cargo.atualizar(cargo)){
            JOptionPane.showMessageDialog(null, "\n***** Cargo atualizado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao atualizar Cargo *****");
        }
        
    }
    
    public boolean existe(int id){       
               
        CargoDao data = model_cargo.selecionar(id);       
        
        if(data != null){
            return true;
        }
        
        return false;
    }  
    
    public void selecionar(int id){       
               
        CargoDao data = model_cargo.selecionar(id);       
        
        if(data != null){
            JOptionPane.showMessageDialog(null, "\n***** DADOS *****\n"+data.toString());
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao selecionar cargo *****");
        }
        
        
    }
        
    public String listar(String nome){       
               
        ArrayList<CargoDao> data = model_cargo.listar(nome);         
        String list = "\n***** DADOS *****\n";
        
        if(data != null){
            for(CargoDao i : data) {
                list += i.toString() + "\n";
            }  
            
        }else{
            list = "\n***** Erro ao listar Cargo *****";
        }
        
        return list;
    }
    
    public void deletar(int id){           
        
        if(model_cargo.deletar(id)){
            JOptionPane.showMessageDialog(null, "\n***** Cargo deletado com suscesso *****");
        }else{
            JOptionPane.showMessageDialog(null, "\n***** Erro ao deletar cargo *****");
        }
        
    } 
        
}
