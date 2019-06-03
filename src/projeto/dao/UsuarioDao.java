
package projeto.dao;

public class UsuarioDao {
    
    private int id;
    private String nome;
    private int idade;
    private String email;
    
    public UsuarioDao(int id, String nome, int idade, String email){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public UsuarioDao(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
	
    public String getNome() {
        return nome;
    }
	
    public int getIdade() {
        return idade;
    }
    
    public String getEmail() {
        
        if("".equals(this.email)){
            return null;
        }
        
        return this.email;
    }
    
    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome + " Idade: " + idade + " Email: " + email;
    }
}
