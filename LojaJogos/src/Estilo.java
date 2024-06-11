import java.io.Serializable;
import java.util.HashSet;

public class Estilo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int pesquisas;
	private HashSet<Jogo> jogos;
	
	//----CONSTRUTORES
		public Estilo(String Nome) {
			this.nome = Nome;
			this.pesquisas = 0;
			this.jogos = new HashSet<>();
		}
		
		
		//----GETTERS
		public String getNome() {
			return nome;
		}
		
		public int getPesquisas() {
			return pesquisas;
		}
		
		public HashSet<Jogo> getJogos() {
			return jogos;
		}
		
		
		//----SETTERS
		public void setNome(String Nome) {
	        this.nome = Nome;
	    }
		
		public void setPesquisas(int p) {
	        this.pesquisas = p;
	    }
		
		public void setJogos(HashSet<Jogo> J) {
			this.jogos = J;
		}

		//---Adicionar Jogo
	  	public void addJogo(Jogo j) {
	  		jogos.add(j);
	  	}
	  	
	  	//---Remover Jogo
	  	public void remJogo(Jogo j) {
	  		jogos.remove(j);
	  	}
		
}
