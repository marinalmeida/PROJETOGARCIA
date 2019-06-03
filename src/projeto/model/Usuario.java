/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import projeto.dao.UsuarioTipoUsuarioCargoDao;
import projeto.dao.UsuarioDao;
import projeto.dao.TipoUsuarioDao;
import projeto.dao.CargoDao;
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
    private final Connection connection;
    
    private final String tabela = "tb_usuario";
    private final String id = "id_usuario";
    private final String nome = "nm_usuario";
    private final String idade = "qt_idade_usuario";
    private final String tipo = "id_tipo_usuario";
    private final String email = "ds_email_usuario";
    private final String cargo = "id_cargo";
    
    /* CONSTRUTOR OK */
    public Usuario(){
        connection = ConexãoBD.getConnection();
    }
        
    /* METODO OK */
    public boolean registrar(UsuarioDao usuario, TipoUsuarioDao tipo_usuario, CargoDao cargo)  {
        String sql = "INSERT INTO " + this.tabela + "("
                     + this.nome + ", "
                     + this.idade + ", "
                     + this.tipo + ", "
                     + this.email + ", "
                     + this.cargo
                     + ") "
                     + "VALUES(?,?,?,?,?)";
	try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setInt(3, tipo_usuario.getId());
            ps.setString(4, usuario.getEmail());      
            ps.setInt(5, cargo.getId() == 0 ? null : cargo.getId());
            ps.execute();
                        
            connection.close(); //FECHAR CONEXÃO
            
            return true;
	} catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }	
    }
    
    /* METODO OK */
    public boolean atualizar(UsuarioDao usuario, TipoUsuarioDao tipo_usuario, CargoDao cargo) {
        String sql = "UPDATE "+this.tabela
                     +" SET "+this.nome+"=?, "
                     +this.idade+"=?, "
                     +this.email+"=?, "
                     +this.tipo+"=?, "
                     +this.cargo+"=? "
                     + " WHERE "+this.id+"=?";
                
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, tipo_usuario.getId());
            ps.setInt(5, cargo.getId());
            ps.setInt(6, usuario.getId());
            ps.execute();
            
            connection.close(); //FECHAR CONEXÃO
            
            return true;
	} catch (SQLException e) {
          //e.printStackTrace();
	}              
                      
         return false;
    }
    
    /* METODO OK */
    public UsuarioTipoUsuarioCargoDao selecionar(int id){
        String sql = "SELECT * FROM "+this.tabela+" as usuario"
                     +" INNER JOIN tb_tipo_usuario as tipo_usuario ON usuario.id_tipo_usuario = tipo_usuario.id_tipo_usuario"
                     +" INNER JOIN tb_cargo as cargo ON usuario.id_cargo = cargo.id_cargo"
                     +" WHERE usuario.id_usuario=?";
        
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            connection.close(); //FECHAR CONEXÃO
            
            if(rs.next()){
                
                CargoDao cargo_dao = new CargoDao(
                    rs.getInt("id_cargo"), 
                    rs.getString("nm_cargo")
                );
            
                TipoUsuarioDao tipo_usuario_dao = new TipoUsuarioDao(
                    rs.getInt("id_tipo_usuario"), 
                    rs.getString("nm_tipo_usuario")
                );
                
                UsuarioDao usuario_dao = new UsuarioDao(
                    rs.getInt("id_usuario"), 
                    rs.getString("nm_usuario"),
                    rs.getInt("qt_idade_usuario"),
                    rs.getString("ds_email_usuario")
                );
                
		return new UsuarioTipoUsuarioCargoDao(
                    cargo_dao,
                    tipo_usuario_dao,
                    usuario_dao  
                );
            }else{
                return null;
            } 
        }catch (SQLException e) {
            e.printStackTrace();
        }
            
        return null;    
    }
    
    /* METODO OK */
    public ArrayList<UsuarioTipoUsuarioCargoDao> listar(String nome){
        String sql = "SELECT * FROM "+this.tabela+" as usuario"
                     +" INNER JOIN tb_tipo_usuario as tipo_usuario ON usuario.id_tipo_usuario = tipo_usuario.id_tipo_usuario"
                     +" INNER JOIN tb_cargo as cargo ON usuario.id_cargo = cargo.id_cargo"
                     +" WHERE usuario.nm_usuario LIKE ?";
                
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            ResultSet rs = ps.executeQuery();
            
            connection.close(); //FECHAR CONEXÃO
            
            ArrayList<UsuarioTipoUsuarioCargoDao> listar = new ArrayList<>();
                
            CargoDao cargo_dao;
            TipoUsuarioDao tipo_usuario_dao;
            UsuarioDao usuario_dao;
            
            while(rs.next()) {
		cargo_dao = new CargoDao(
                    rs.getInt("id_cargo"), 
                    rs.getString("nm_cargo")
                );
            
                tipo_usuario_dao = new TipoUsuarioDao(
                    rs.getInt("id_tipo_usuario"), 
                    rs.getString("nm_tipo_usuario")
                );
                
                usuario_dao = new UsuarioDao(
                    rs.getInt("id_usuario"), 
                    rs.getString("nm_usuario"),
                    rs.getInt("qt_idade_usuario"),
                    rs.getString("ds_email_usuario")
                );
                
		listar.add(new UsuarioTipoUsuarioCargoDao(cargo_dao, tipo_usuario_dao, usuario_dao));
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