import java.io.Serializable;
import java.util.HashSet;

public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private int vendas;
    private HashSet<Jogo> jogos;
    
    //----CONSTRUTOR
  	public Fornecedor(String Nome) {
  		
  		this.nome = Nome;
  		this.vendas = 0;
  		this.jogos = new HashSet<>();
  		
  	}
  	
  	//----MOSTRA Fornecedor
  	public void mostraFornecedor() {
  		System.out.println("Detalhes de Fornecedor: ");
  		System.out.println("Nome: " + this.nome);
  		System.out.println("Vendas: " + this.vendas);
  		System.out.println("Jogos:");
  		for (Jogo j : this.jogos) {
          	
          	System.out.println("Jogo: " + j.getNome() + ", " + j.getSaga() + ", " + j.getPlataforma());
              
          }
  		System.out.println();
  	}
  	
  	//----GETTERS
    public String getNome() {
        return nome;
    }
    
    public int getVendas() {
        return vendas;
    }
  	
  	public HashSet<Jogo> getJogos() {
        return jogos;
    }
  	
  	//----SETTERS
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public void setJogos(HashSet<Jogo> Jogos) {
        this.jogos = Jogos;
    }
  	
    public void setVendas(int Vendas) {
        this.vendas = Vendas;
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
