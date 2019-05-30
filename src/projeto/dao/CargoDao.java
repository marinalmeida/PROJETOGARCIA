
package projeto.dao;

import java.util.ArrayList;

public class CargoDao {
 
	private int id;
	private String nome;
	
	public CargoDao(int id, String nome) {
            this.id = id;
            this.nome = nome;
	}
       
        public CargoDao(String nome) {
            this.nome = nome;
                
	}
	public int getId() {
            return id;
	}
	
	public String getNome() {
            return nome;
	}
	
}