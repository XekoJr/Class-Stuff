import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String nome;
	private int num;
	private String morada;
	private String password;
	private HashSet<Produto> produtos;
	private HashSet<String> pesquisas;
	
	//----CONSTRUTOR
	public Cliente(String Nome, int Num, String Morada, String Pass) {
		
		this.nome = Nome;
		this.num = Num;
		this.morada = Morada;
		this.password = Pass;
		this.produtos = new HashSet<>();
		this.pesquisas = new HashSet<>();
		
	}
	
	//----MOSTRA EMPREGADO
	public void mostraCliente() {
		System.out.println("Detalhes de Cliente: ");
		System.out.println("Nome: " + this.nome);
		System.out.println("Numero: " + this.num);
		System.out.println("Morada: " + this.morada);
		System.out.println("Produtos Comprados:");
		for (Produto j : produtos) {
        	
        	System.out.println("Produto: " + j.getNome());
            
        }
		System.out.println();
	}
	
	//----GETTERS
	public String getNome() {
        return nome;
    }
	
	public String getMorada() {
        return morada;
    }
	
	public HashSet<Produto> getProdutos() {
        return produtos;
    }
	
	public int getNum() {
		return num;
	}
	
	public String getPassword() {
		return password;
	}
	
	public HashSet<String> getPesquisas() {
        return pesquisas;
    }
	
	
	//----SETTERS
	public void setNome(String Nome) {
        this.nome = Nome;
    }
	
	public void setMorada(String Morada) {
        this.morada = Morada;
    }
	
	public void setProdutos(HashSet<Produto> Produtos) {
        this.produtos = Produtos;
    }
	
	public void setNum(int Num) {
		this.num = Num;
	}
	
	public void setPassword(String Pass) {
		this.password = Pass;
	}
	
	public void setPesquisas(HashSet<String> Pesquisas) {
        this.pesquisas = Pesquisas;
    }
	
	
	//----MÉTODOS
    
    //---Adicionar Jogo
  	public void addProduto(Produto j) {
  		produtos.add(j);
  	}
	
  	//---Adicionar Jogo
  	public void addPesquisa(String j) {
  		pesquisas.add(j);
  	}
	
  	//---Escrever pesquisas dos clientes no txt
  	public void savePesquisas() 
  	  throws IOException {
  		
        File f = new File(this.nome + ".txt");
        if (!f.exists()) {
            f.createNewFile();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
        	
        	bw.write("Pesquisas do Cliente: " + this.nome);
        	bw.newLine();
        	bw.newLine();
        	
            for (String pesquisa : pesquisas) {
                bw.write(pesquisa);
                bw.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao guardar pesquisas no ficheiro.");
        }
        
    }
	
}
