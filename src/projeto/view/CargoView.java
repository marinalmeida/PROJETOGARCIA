
package projeto.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import projeto.controller.CargoController;
import projeto.dao.CargoDao;

public class CargoView {
    
    private CargoController data_cargo;
    private String dados;
    
    public void adicionarCargo(){
        
        data_cargo = new CargoController();
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o cargo: *****").toUpperCase();    
        CargoDao cargo = new CargoDao(nome);
        
        data_cargo.registrar(cargo);
    }
    
    public void atualizarCargo(){
        data_cargo = new CargoController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do cargo *****");
        int id = Integer.parseInt(dados); 
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o nome do cargo *****").toUpperCase();  
        
        CargoDao cargo = new CargoDao(id, nome);
        
        data_cargo.atualizar(cargo);          
        
    }
    
    public void selecionarCargo() {
        CargoDao data = null;
        data_cargo = new CargoController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do cargo *****");
        int id = Integer.parseInt(dados); 
            
        data_cargo.selecionar(id);
        
    }
    
    public void listarCargo(){
        data_cargo = new CargoController();
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o nome do Cargo *****").toUpperCase();     
           
        String list = data_cargo.listar(nome); 
        
        JOptionPane.showMessageDialog(null, list);
    }
        
    public void deletarCargo(){
        ArrayList<CargoDao> data = null;
        data_cargo = new CargoController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do cargo *****");
        int id = Integer.parseInt(dados); 
                    
        data_cargo.deletar(id);          
        
    }

}
