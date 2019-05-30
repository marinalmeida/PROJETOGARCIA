
package projeto.dao;

public class TipoUsuarioDao {
    private int id;
    private String nome;
    
  
    public TipoUsuarioDao(int id, String nome) {
	this.id = id;
	this.nome = nome;
	}
    public TipoUsuarioDao(String nome) {
	this.nome = nome;
	}
       
    public int getId() {
	return id;
	}
	
    public String getNome() {
	return nome;
	}
    
    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome;
    }
}