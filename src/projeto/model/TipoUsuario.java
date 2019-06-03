
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import projeto.dao.TipoUsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author team
 */
public class TipoUsuario {
    private final Connection connection;
	
    private final String tabela = "tb_tipo_usuario";
    private final String id = "id_tipo_usuario";
    private final String nome = "nm_tipo_usuario";
        
    /* CONSTRUTOR */
    public TipoUsuario(){
	connection = ConexãoBD.getConnection();
    }
        
    /* METODO OK */
    public boolean registrar(TipoUsuarioDao tipo_usuario){
        String sql = 
            "INSERT INTO "+this.tabela
            +"("+this.nome+") "
            + "VALUES(?)";
	
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
	    ps.setString(1, tipo_usuario.getNome());                      
            ps.execute();
            
            connection.close(); //FECHAR CONEXÃO
            
            return true;
	} catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }		
    }
        
    /* METODO OK */
    public TipoUsuarioDao selecionar(int id){
        String sql = "SELECT * FROM "+this.tabela+" WHERE "+this.id+"=?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            connection.close(); //FECHAR CONEXÃO
            
            if(rs.next()){
		return new TipoUsuarioDao(
                            rs.getInt(this.id),
                            rs.getString(this.nome)
			);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
        }
            
        return null;    
    }
        
    /* METODO OK */
    public ArrayList<TipoUsuarioDao> listar(String nome){
        String sql = "SELECT * FROM "+this.tabela+" WHERE "+this.nome+" LIKE ?";
                
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            ResultSet rs = ps.executeQuery();
            
            connection.close(); //FECHAR CONEXÃO
            
            ArrayList<TipoUsuarioDao> listar = new ArrayList<TipoUsuarioDao>();
                
            int id = 0;
                
            while(rs.next()) {
            	id = rs.getInt(this.id);
		nome = rs.getString(this.nome);
		listar.add(new TipoUsuarioDao(id, nome));
            }
                
            return listar;
        } catch (SQLException e) {
            //e.printStackTrace();
        }
            
        return null;
    }
        
    /* METODO OK */
    public boolean atualizar(TipoUsuarioDao tipo_usuario) {
        String sql = "UPDATE "+this.tabela+" SET "+this.nome+"=? WHERE "+this.id+"=?";
                
	try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tipo_usuario.getNome());
            ps.setInt(2, tipo_usuario.getId());
            ps.execute();
            
            connection.close(); //FECHAR CONEXÃO
            
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
        }              
               
                    
        return false;
    }
        
    /* METODO OK */
    public boolean deletar(int id){
        String sql = "DELETE FROM "+this.tabela+" WHERE "+this.id+"=?";
            
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
                
            connection.close(); //FECHAR CONEXÃO
            
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
        }
            
        return false;
    }
        
}