
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import projeto.dao.CargoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projeto.dao.TipoUsuarioDao;

/**
 *
 * @author suporte
 */
public class Cargo {
    private Connection connection;
        
    private String tabela = "tb_cargo";
    private String id = "id_cargo";
    private String nome = "nm_cargo";
	
        /* CONSTRUTOR OK */
	public Cargo(){
		connection = ConexãoBD.getConnection();
	}
        
        /* METODO OK */
        public boolean registrar(CargoDao cargo){
            String sql = 
                    "INSERT INTO "+this.tabela
                    +"("+this.nome+") "
                    + "VALUES(?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cargo.getNome());                      
			ps.execute();
                        
                        return true;
		} catch (SQLException e) {
                    //e.printStackTrace();
                        
                    return false;
		}		
	}
        
        public boolean atualizar(CargoDao cargo) {
            String sql = "UPDATE "+this.tabela+" SET "+this.nome+"=? WHERE "+this.id+"=?";
                
		try {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, cargo.getNome());
                    ps.setInt(2, cargo.getId());
                    ps.execute();
                    
                    return true;
		} catch (SQLException e) {
                    //e.printStackTrace();
		}              
               
                    
             return false;
	}

}