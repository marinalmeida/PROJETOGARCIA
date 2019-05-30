/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.view.TipoUsuarioView;
import projeto.view.CargoView;
/**
 *
 * @author suporte
 */
public class Projeto {
    private static TipoUsuarioView view_tipo_usuario;
    private static CargoView view_cargo;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Digitar();
        
    }
    
    public static void Menu(){
        System.out.println("\n***** BEM VINDO! *****\n");
	System.out.println(
            "(0) Sair \n" +
            "(1) Adicionar Tipo Usuário \n"+
            "(2) Atualizar Tipo Usuário \n"+
            "(3) Selecionar Tipo Usuário\n"+
            "(4) Listar Tipo Usuário\n"+
            "(5) Deletar Tipo Usuárion\n"+
            "***************************\n"+
            "(6) Adicionar Cargo \n"+
            "(7) Atualizar Cargo \n"+    
            " "
	);    
    }
    
    public static Projeto Digitar(){        
        Menu();
        
        Scanner digitar = new Scanner(System.in);
	int opcao = 0;

	opcao = digitar.nextInt();
        
	
        
        switch (opcao) {
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
            default:
                System.out.println(opcao);
         }  
        
        
        return Digitar();
    }
    
}
