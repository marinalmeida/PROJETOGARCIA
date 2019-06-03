
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import projeto.dao.CargoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projeto.dao.TipoUsuarioDao;

/**
 *
 * @author team
 */
public class Cargo {
    private Connection connection;
        
    private String tabela = "tb_cargo";
    private String id = "id_cargo";
    private String nome = "nm_cargo";
	
    /* CONSTRUTOR */
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
            
            connection.close(); //FECHAR CONEXÃO
            
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();                        
            return false;
        }		
    }
    
    /* METODO OK */
    public boolean atualizar(CargoDao cargo) {
        String sql = "UPDATE "+this.tabela+" SET "+this.nome+"=? WHERE "+this.id+"=?";
                
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
            ps.setInt(2, cargo.getId());
            ps.execute();
            
            connection.close(); //FECHAR CONEXÃO
            
            return true;
	} catch (SQLException e) {
          //e.printStackTrace();
	}              
                      
         return false;
    }
    
    /* METODO OK */
    public CargoDao selecionar(int id){
        String sql = "SELECT * FROM "+this.tabela+" WHERE "+this.id+"=?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            connection.close(); //FECHAR CONEXÃO
            
            if(rs.next())
		return new CargoDao(
                    rs.getInt(this.id),
                    rs.getString(this.nome)
                );
            else
                return null;
            } catch (SQLException e) {
                //e.printStackTrace();
            }
            
            return null;    
    }
    
    /* METODO OK */
    public ArrayList<CargoDao> listar(String nome){
        String sql = "SELECT * FROM "+this.tabela+" WHERE "+this.nome+" LIKE ?";
                
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            ResultSet rs = ps.executeQuery();
            
            connection.close(); //FECHAR CONEXÃO
            
            ArrayList<CargoDao> listar = new ArrayList<CargoDao>();
                
            int id = 0;
                
            while(rs.next()) {
		id = rs.getInt(this.id);
		nome = rs.getString(this.nome);
		listar.add(new CargoDao(id, nome));
            }
                
            return listar;
            } catch (SQLException e) {
                //e.printStackTrace();
            }
            
            return null;
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