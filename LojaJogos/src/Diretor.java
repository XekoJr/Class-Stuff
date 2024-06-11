import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public class Diretor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String email;
    private String nascimento; //(ano, mês, dia)
    private String paginaWeb;
    private String morada;
    private String moradaFas;
    private Produtora produtora;
    private String extra;
    private HashSet<Jogo> jogos;
    
	//----CONSTRUTORES
    public Diretor(String Nome) {
    	this.nome = Nome;
    }
    
    public Diretor(String Nome, String Email, String DN, String pagina, String Morada, String MoradaFas, Produtora Pr) {
    	
    	this.nome = Nome;
        this.email = Email;
        this.nascimento = DN;
        this.paginaWeb = pagina;
        this.morada = Morada;
        this.moradaFas = MoradaFas;
        this.produtora = Pr;
        this.extra = "";
        this.jogos = new HashSet<>();
    	
    }
    
    public Diretor(String Nome, String Email, String DN, String pagina, String Morada, String MoradaFas) {
    	
    	this.nome = Nome;
        this.email = Email;
        this.nascimento = DN;
        this.paginaWeb = pagina;
        this.morada = Morada;
        this.moradaFas = MoradaFas;
        this.extra = "";
        this.jogos = new HashSet<>();
    	
    }
    
    //----MOSTRA DIRETOR
    public void mostraDiretor() {
    	
    	System.out.println("Detalhes do Diretor:");
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Data de Nascimento: " + this.nascimento);
        System.out.println("Página Web: " + this.paginaWeb);
        System.out.println("Morada: " + this.morada);
        System.out.println("Morada dos Fãs: " + this.moradaFas);
        if(produtora != null) {
        System.out.println("Produtora: " + this.produtora.getNome());
        }
        for (Jogo j : jogos) {
        	
        	System.out.println("Jogo: " + j.getNome() + ", " + j.getSaga() + ", " + j.getPlataforma());
            
        }
        System.out.println();
    
    }
    
    //----GETTERS
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getNascimento() {
        return nascimento;
    }
    
    public String getPaginaWeb() {
        return paginaWeb;
    }
    
    public String getMorada() {
        return morada;
    }
    
    public String getMoradaFas() {
        return moradaFas;
    }
    
    public Produtora getProdutora() {
        return produtora;
    }
    
    public String getExtra() {
        return extra;
    }
    
    public HashSet<Jogo> getJogos() {
        return jogos;
    }
    
    
    //----SETTERS
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public void setEmail(String Email) {
        this.email = Email;
    }
    
    public void setNascimento(String Nascimento) {
        this.nascimento = Nascimento;
    }
    
    public void setPaginaWeb(String PaginaWeb) {
        this.paginaWeb = PaginaWeb;
    }
    
    public void setMorada(String Morada) {
        this.morada = Morada;
    }
    
    public void setMoradaFas(String MoradaFas) {
        this.moradaFas = MoradaFas;
    }
    
    public void setProdutora(Produtora Produtora) {
        this.produtora = Produtora;
    }
    
    public void setExtra(String Extra) {
        this.extra = Extra;
    }
    
    public void setJogos(HashSet<Jogo> Jogos) {
        this.jogos = Jogos;
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
    
  	public int getTotalVendas() {
  		
        int total = 0;
        for (Jogo jogo : jogos) {
        	
            total += jogo.getStock().getVendas();
            
        }
        
        return total;
        
    }
    
    
    
    
}
