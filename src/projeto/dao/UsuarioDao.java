
package projeto.dao;

public class UsuarioDao {
    
    private int id;
    private String nome;
    private int idade;
    private String email;
    private int tipo_usuario;
    
    public UsuarioDao(int id, String nome, int idade, String email, int tipo_usuario){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.tipo_usuario = tipo_usuario;
    }
    
    public UsuarioDao(String nome, int idade, String email, int tipo_usuario){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.tipo_usuario = tipo_usuario;
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
        return this.email;
    }
    
    public int getTipoUsuario() {
        return this.tipo_usuario;
    }
    
    
}
