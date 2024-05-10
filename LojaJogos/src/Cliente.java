import java.io.Serializable;
import java.util.HashSet;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String nome;
	private String morada;
	private HashSet<Jogo> jogos;
	
	//----CONSTRUTOR
	public Cliente(String Nome, String Morada) {
		
		this.nome = Nome;
		this.morada = Morada;
		this.jogos = new HashSet<>();
		
	}
	
	//----GETTERS
	public String getNome() {
        return nome;
    }
	
	public String getMorada() {
        return morada;
    }
	
	public HashSet<Jogo> getJogos() {
        return jogos;
    }
	
	
	//----SETTERS
	public void setNome(String Nome) {
        this.nome = Nome;
    }
	
	public void setMorada(String Morada) {
        this.morada = Morada;
    }
	
	public void setJogos(HashSet<Jogo> Jogos) {
        this.jogos = Jogos;
    }
	
	
	//----MÉTODOS
    
    //---Adicionar Jogo
  	public void addJogo(Jogo j) {
  		jogos.add(j);
  	}
	
	
	
	
	
}
