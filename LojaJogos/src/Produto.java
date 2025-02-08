import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private HashSet<Jogo> jogos;
	private String nome;
	private float custoVendaTotal;
	
	//----CONSTRUTORES
	public Produto(String Nome) {
		this.nome = Nome;
	    this.jogos = new HashSet<>();
		this.custoVendaTotal = 0;
	}
	
	//----MOSTRA PRODUTO
	public void mostraProduto() {
		
        System.out.println("Detalhes do Produto:");
        System.out.println("Nome: " + this.nome);
        System.out.println("Custo Total Venda: " + this.custoVendaTotal);
        System.out.println("Jogos:");
        
        for (Jogo j : jogos) {
        	
        	System.out.println("Jogo: " + j.getNome() + ", " + j.getSaga() + ", " + j.getPlataforma());
            
        }
        System.out.println();
        
    }
	
	//----GETTERS
    public String getNome() {
        return nome;
    }
    
    public HashSet<Jogo> getJogos() {
        return jogos;
    }
    
    public float getCVenda() {
        return custoVendaTotal;
    }
    
    //----SETTERS
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public void setJogos(HashSet<Jogo> Jogos) {
        this.jogos = Jogos;
    }
    
    public void setCVenda(float f) {
        this.custoVendaTotal = f;
    }
	

	//----MÉTODOS
    //---Adicionar Jogo
  	public void addJogo(Jogo j) {
  		jogos.add(j);
  	}
  	
  	//---Remover Jogo
  	public void remJogo(Jogo j) {
  		jogos.remove(j);
  	}
	
	//Custo total de venda do produto
	public float custoVendaProduto(HashSet<Jogo> Jogos) {
		
		if (jogos == null) {

            jogos = new HashSet<Jogo>();

        }
		
		float t = 0;
		
		for (Jogo a : jogos) {
        	
            t += a.getCustoVenda();
            
        }
		
		return t;
		
	}
	
	
	
	
}
