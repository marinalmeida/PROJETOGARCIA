/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import projeto.dao.UsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suporte
 */
public class Usuario {
    private Connection connection;
	
        /* CONSTRUTOR OK */
	public Usuario(){
		connection = ConexãoBD.getConnection();
	}
        
        /* METODO OK */
	public boolean registrar(UsuarioDao usuario)  {
            String sql = "INSERT INTO tb_usuario("
                    + "nm_usuario, "
                    + "qt_idade, "
                    + "cd_tipo_usuario, "
                    + "ds_email_usuario) "
                    + "VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setInt(2, usuario.getIdade());
                        ps.setInt(3, usuario.getTipoUsuario());
                        ps.setString(4, usuario.getEmail());                        
			ps.execute();
                        
                        return true;
		} catch (SQLException e) {
			System.out.println("Error in insertion");
			e.printStackTrace();
                        
                        return false;
		}		
	}
        
}