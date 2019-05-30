/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.Projeto;
import projeto.controller.TipoUsuarioController;
import projeto.dao.TipoUsuarioDao;
/**
 *
 * @author suporte
 */
public class TipoUsuarioView {
    
    private static TipoUsuarioController data_tipo_usuario;
    private static Scanner dados;
    
    public void adicionarTipoUsuario(){
        
        data_tipo_usuario = new TipoUsuarioController();
        
        dados = new Scanner(System.in);
        System.out.println("\n***** Digite o tipo de usuário *****");
        String nome = dados.nextLine().toUpperCase();
        
        TipoUsuarioDao tipo_usuario = new TipoUsuarioDao(nome);
        
        data_tipo_usuario.registrar(tipo_usuario);
    }
    
    public void atualizarTipoUsuario(){
        data_tipo_usuario = new TipoUsuarioController();
        
        dados = new Scanner(System.in);
        System.out.println("\n***** Digite a ID do tipo de usuário *****");
        int id = dados.nextInt();
        
        System.out.println("\n***** Digite o nome do tipo de usuário *****");
        String nome = dados.next().toUpperCase();
        
        TipoUsuarioDao tipo_usuario = new TipoUsuarioDao(id, nome);
        
        data_tipo_usuario.atualizar(tipo_usuario);          
        
    }
    
    public void selecionarTipoUsuario(){
        TipoUsuarioDao data = null;
        data_tipo_usuario = new TipoUsuarioController();
        dados = new Scanner(System.in);
        
        System.out.println("\n***** Digite a ID do tipo de usuário *****");
        int id = dados.nextInt();
            
        data_tipo_usuario.selecionar(id);
        
    }
    
    public void listarTipoUsuario(){
        ArrayList<TipoUsuarioDao> data = null;
        data_tipo_usuario = new TipoUsuarioController();
        dados = new Scanner(System.in);
        
        System.out.println("\n***** Digite o nome do tipo de usuário *****");
        String nome = dados.nextLine().toUpperCase();          
           
        data_tipo_usuario.listar(nome); 
    }   
    
    public void deletarTipoUsuario(){
        ArrayList<TipoUsuarioDao> data = null;
        data_tipo_usuario = new TipoUsuarioController();
        dados = new Scanner(System.in);
        
        System.out.println("\n***** Digite a ID do tipo de usuário *****");
        int id = dados.nextInt();
                    
        data_tipo_usuario.deletar(id);          
        
    }
}
