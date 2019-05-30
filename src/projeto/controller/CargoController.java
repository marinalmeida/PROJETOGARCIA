
package projeto.controller;

import projeto.dao.CargoDao;
import projeto.dao.TipoUsuarioDao;
import projeto.model.Cargo;


public class CargoController {
    
    private Cargo model_cargo;
    private CargoDao data_cargo;
    
    public CargoController(){
        model_cargo = new Cargo();
    }
    
    public void registrar(CargoDao cargo){           
        
        if(model_cargo.registrar(cargo)){
            System.out.println("\n***** Cargo adicionado com suscesso *****");
        }else{
            System.out.println("\n***** Erro ao adicionar Cargo *****");
        }
        
    } 
    
        public void atualizar(CargoDao cargo){       
        
        if(model_cargo.atualizar(cargo)){
            System.out.println("\n***** Cargo atualizado com suscesso *****");
        }else{
            System.out.println("\n***** Erro ao atualizar Cargo *****");
        }
        
    } 
}
