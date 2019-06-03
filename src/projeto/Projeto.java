/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import javax.swing.JOptionPane;
import projeto.view.TipoUsuarioView;
import projeto.view.CargoView;
import projeto.view.UsuarioView;
/**
 *
 * @author suporte
 */
public class Projeto {
    private static TipoUsuarioView view_tipo_usuario;
    private static CargoView view_cargo;
    private static UsuarioView view_usuario;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Digitar();
        
    }
    
    /* MENU COMPLETO COM TODAS AS AÇÕES */
    public static String Menu(){
        return
            "\n***** BEM VINDO! *****\n" +
            "(0) Sair \n" +
            "(1) Adicionar Tipo Usuário \n"+
            "(2) Atualizar Tipo Usuário \n"+
            "(3) Selecionar Tipo Usuário\n"+
            "(4) Listar Tipo Usuário\n"+
            "(5) Deletar Tipo Usuário\n"+
            "***************************\n"+
            "(6) Adicionar Cargo \n"+
            "(7) Atualizar Cargo \n"+    
            "(8) Selecionar Cargo \n"+
            "(9) Listar Cargo \n"+
            "(10) Deletar Cargo \n"+
            "***************************\n"+
            "(11) Adicionar Usuario \n"+
            "(12) Atualizar Usuario \n"+
            "(13) Selecionar Usuario \n"+
            "(14) Listar Usuario \n"+
            "(15) Deletar Usuario \n"
        ;
    }
    
    /* INTERFACE COM REGRA DE NEGOCIO DO ITEM SELECIONADO NO MENU */
    public static Projeto Digitar(){        
        String entrada = JOptionPane.showInputDialog(Menu());
	int opcao = 0;
        
        
	opcao = Integer.parseInt(entrada); 
	
        
        switch (opcao) {
            case 0:
                return null;
            case 1:
                view_tipo_usuario = new TipoUsuarioView();
                view_tipo_usuario.adicionarTipoUsuario();
                break;
            case 2:
                view_tipo_usuario = new TipoUsuarioView();
                view_tipo_usuario.atualizarTipoUsuario();
                break;
            case 3:
                view_tipo_usuario = new TipoUsuarioView();
                view_tipo_usuario.selecionarTipoUsuario();
                break;
            case 4:
                view_tipo_usuario = new TipoUsuarioView();
                view_tipo_usuario.listarTipoUsuario();
                break;
            case 5:
                view_tipo_usuario = new TipoUsuarioView();
                view_tipo_usuario.deletarTipoUsuario();
                break;
            case 6:
                view_cargo = new CargoView();
                view_cargo.adicionarCargo();
                break;
            case 7:
                view_cargo = new CargoView();
                view_cargo.atualizarCargo();
                break;   
            case 8:
                view_cargo = new CargoView();
                view_cargo.selecionarCargo();
                break;
            case 9:
                view_cargo = new CargoView();
                view_cargo.listarCargo();
                break;
            case 10:
                view_cargo = new CargoView();
                view_cargo.deletarCargo();
                break;
            case 11:
                view_usuario = new UsuarioView();
                view_usuario.adicionarUsuario();
                break;    
            case 12:
                view_usuario = new UsuarioView();
                view_usuario.atualizarUsuario();
                break; 
            case 13:
                view_usuario = new UsuarioView();
                view_usuario.selecionarUsuario();
                break; 
            case 14:
                view_usuario = new UsuarioView();
                view_usuario.listarUsuario();
                break; 
            case 15:
                view_usuario = new UsuarioView();
                view_usuario.deletarUsuario();
                break; 
            default:
                return Projeto.Digitar();
         }  
        
        
        return Projeto.Digitar();
    }
    
}
