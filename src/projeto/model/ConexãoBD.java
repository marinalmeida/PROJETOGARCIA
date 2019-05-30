/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author suporte
 */
public class ConexãoBD {
    
    public static Connection getConnection() {
        try
        {
            Connection con = null;
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/escola", "postgres", "admin");
            //System.out.println("Conexão realizada com sucesso.");
            
            return con;
        }
        catch (SQLException e) {
			throw new RuntimeException(e);
		}
        
       
    }
}
