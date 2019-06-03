
package projeto.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projeto.Projeto;
import projeto.controller.TipoUsuarioController;
import projeto.dao.TipoUsuarioDao;

public class TipoUsuarioView {
    
    private static TipoUsuarioController data_tipo_usuario;
    private static String dados;
    
    public void adicionarTipoUsuario(){
        
        data_tipo_usuario = new TipoUsuarioController();
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o tipo de usuario: *****").toUpperCase();
        
        TipoUsuarioDao tipo_usuario = new TipoUsuarioDao(nome);
        
        data_tipo_usuario.registrar(tipo_usuario);
    }
    
    public void atualizarTipoUsuario(){
        data_tipo_usuario = new TipoUsuarioController();
       
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do tipo de usuário *****");
        int id = Integer.parseInt(dados); 
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o nome do tipo de usuário *****").toUpperCase();
        
        TipoUsuarioDao tipo_usuario = new TipoUsuarioDao(id, nome);
        
        data_tipo_usuario.atualizar(tipo_usuario);          
        
    }
    
    public void selecionarTipoUsuario(){
        TipoUsuarioDao data = null;
        data_tipo_usuario = new TipoUsuarioController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do tipo de usuário *****");
        int id = Integer.parseInt(dados); 
        
        data_tipo_usuario.selecionar(id);        
    }
    
    public void listarTipoUsuario(){
        data_tipo_usuario = new TipoUsuarioController();
        
        String nome = JOptionPane.showInputDialog("\n***** Digite o nome do tipo de usuário *****").toUpperCase();    
           
        String list = data_tipo_usuario.listar(nome); 
        
        JOptionPane.showMessageDialog(null, list);
    }   
    
    public void deletarTipoUsuario(){
        ArrayList<TipoUsuarioDao> data = null;
        data_tipo_usuario = new TipoUsuarioController();
        
        dados = JOptionPane.showInputDialog("\n***** Digite a ID do tipo de usuário *****");
        int id = Integer.parseInt(dados); 
                    
        data_tipo_usuario.deletar(id);                  
    }
}
