
package projeto.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import projeto.controller.CargoController;
import projeto.controller.TipoUsuarioController;
import projeto.controller.UsuarioController;
import projeto.dao.CargoDao;
import projeto.dao.TipoUsuarioDao;
import projeto.dao.UsuarioDao;
import projeto.dao.UsuarioTipoUsuarioCargoDao;


public class UsuarioView {
    
    private CargoController data_cargo;
    private TipoUsuarioController data_tipo_usuario;
    private UsuarioController data_usuario;
    
    private String dados;
    
    private int input_id;
    private String input_nome;
    private int input_idade;
    private String input_email;
    private int input_tipo_usuario;
    private int input_cargo;
    
    public void adicionarUsuario() {
                        
        this.input_nome = JOptionPane.showInputDialog("\n***** Digite o nome: *****").toUpperCase();    
        
        this.dados = JOptionPane.showInputDialog("\n***** Digite a idade *****");
        this.input_idade = Integer.parseInt(dados); 
        
        this.input_email = JOptionPane.showInputDialog("\n***** Digite o email (opcional) *****");
        
        UsuarioDao usuario = new UsuarioDao(this.input_nome, this.input_idade, this.input_email);
        
        this.data_tipo_usuario = new TipoUsuarioController();
        String list = this.data_tipo_usuario.listar(""); 
        
        this.selecionarTipoUsuario(list);           
        
        TipoUsuarioDao tipo_usuario = new TipoUsuarioDao(this.input_tipo_usuario);
        
        this.data_cargo = new CargoController();
        list = this.data_cargo.listar(""); 
        
        this.selecionarCargo(list);           
        
        this.data_cargo = new CargoController();
        CargoDao cargo = new CargoDao(this.input_cargo);
                
        this.data_usuario = new UsuarioController();
        data_usuario.registrar(usuario, tipo_usuario, cargo);        
    }
    
    public void atualizarUsuario(){
        data_usuario = new UsuarioController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do usuário *****");
        this.input_id = Integer.parseInt(dados); 
        
        this.input_nome = JOptionPane.showInputDialog("\n***** Digite o nome: *****").toUpperCase();    
        
        this.dados = JOptionPane.showInputDialog("\n***** Digite a idade *****");
        this.input_idade = Integer.parseInt(dados); 
        
        this.input_email = JOptionPane.showInputDialog("\n***** Digite o email (opcional) *****"); 
        
        UsuarioDao usuario = new UsuarioDao(this.input_nome, this.input_idade, this.input_email);
        
        this.data_tipo_usuario = new TipoUsuarioController();
        String list = this.data_tipo_usuario.listar(""); 
        
        this.selecionarTipoUsuario(list);           
        
        TipoUsuarioDao tipo_usuario = new TipoUsuarioDao(this.input_tipo_usuario);
        
        this.data_cargo = new CargoController();
        list = this.data_cargo.listar(""); 
        
        this.selecionarCargo(list);           
        
        this.data_cargo = new CargoController();
        CargoDao cargo = new CargoDao(this.input_cargo);
                
        this.data_usuario = new UsuarioController();
        this.data_usuario.atualizar(usuario, tipo_usuario, cargo);          
        
    }
    
    private void selecionarTipoUsuario(String list) {           
        
        this.data_tipo_usuario = new TipoUsuarioController();        
        
        this.dados = JOptionPane.showInputDialog("\n***** Escolha o tipo do usuário *****\n"+list);
        int id_tipo_usuario = "".equals(this.dados) ? 0 : Integer.parseInt(this.dados);
            
        boolean verificador = this.data_tipo_usuario.existe(id_tipo_usuario);
            
        if(verificador){
            this.input_tipo_usuario = id_tipo_usuario;
        }else{
            this.selecionarTipoUsuario(list);
        }
        
    }
    
    private void selecionarCargo(String list) {         
        
        this.data_cargo = new CargoController();
        
        this.dados = JOptionPane.showInputDialog("\n***** Escolha o cargo *****\n"+list);
        int id_cargo = Integer.parseInt(this.dados);
            
        boolean verificador = this.data_cargo.existe(id_cargo);
            
        if(verificador){
            this.input_cargo = id_cargo;
        }else{
            this.selecionarCargo(list);
        }
        
    }
    
    public void selecionarUsuario() {
        CargoDao data = null;
        data_usuario = new UsuarioController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do usuário *****");
        int id = Integer.parseInt(dados); 
            
        data_usuario.selecionar(id);
        
    }
    
    public void listarUsuario(){
        data_usuario = new UsuarioController();
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o nome do usuario *****").toUpperCase();     
           
        String list = data_usuario.listar(nome); 
        
        JOptionPane.showMessageDialog(null, list);
    }
    
    public void deletarUsuario(){
        data_usuario = new UsuarioController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do usuario *****");
        int id = Integer.parseInt(dados); 
                    
        data_usuario.deletar(id);          
        
    }
}
