
package projeto.view;

import java.util.Scanner;
import projeto.controller.CargoController;
import projeto.controller.TipoUsuarioController;
import projeto.dao.CargoDao;
import projeto.dao.TipoUsuarioDao;

public class CargoView {
    
    private CargoController data_cargo;
    private static Scanner dados;
    
    public void adicionarCargo(){
        
        data_cargo = new CargoController();
        
        dados = new Scanner(System.in);
        System.out.println("\n***** Digite o cargo: *****");
        String nome = dados.nextLine().toUpperCase();
        
        CargoDao cargo = new CargoDao(nome);
        
        data_cargo.registrar(cargo);
    }
    
    public void atualizarCargo(){
        data_cargo = new CargoController();
        
        dados = new Scanner(System.in);
        System.out.println("\n***** Digite a ID do cargo *****");
        int id = dados.nextInt();
        
        System.out.println("\n***** Digite o nome do cargo *****");
        String nome = dados.next().toUpperCase();
        
        CargoDao cargo = new CargoDao(id, nome);
        
        data_cargo.atualizar(cargo);          
        
    }
}
