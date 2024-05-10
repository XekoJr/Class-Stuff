import java.io.Serializable;
import java.util.ArrayList;

public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String saga;
    private String estilo;
    private float duracao; //em Horas
    private Produtora produtora;
    private Diretor diretor;
    private Stock stock;
    private String extra;
    
    
    //----CONSTRUTOR
    public Jogo(String Nome, String Saga, String Estilo, float Duracao, Produtora Pr, Diretor Dr, Stock St) {
    	
    	this.nome = Nome;
    	this.saga = Saga;
    	this.estilo = Estilo;
    	this.duracao = Duracao;
    	this.produtora = Pr;
    	this.diretor = Dr;
    	this.stock = St;
    	this.extra  = "";
    	
    }
    
    
    //----GETTERS
    public String getNome() {
        return nome;
    }
    
    public String getSaga() {
        return saga;
    }
    
    public String getEstilo() {
        return estilo;
    }
    
    public Float getDuracao() {
        return duracao;
    }
    
    public Produtora getProdutora() {
        return produtora;
    }
    
    public Diretor getDiretor() {
        return diretor;
    }
    
    public Stock getStock() {
        return stock;
    }
    
    public String getExtra() {
        return extra;
    }
    
    
    //----SETTERS
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public void setSaga(String Saga) {
        this.nome = Saga;
    }
    
    public void setEstilo(String Estilo) {
        this.nome = Estilo;
    }
    
    public void setDuracao(float Duracao) {
    	this.duracao = Duracao;
    }
    
    public void setProdutora(Produtora Pr) {
        this.produtora = Pr;
    }
    
    public void setDiretor(Diretor Dr) {
        this.diretor = Dr;
    }
    
    public void setStock(Stock St) {
        this.stock = St;
    }
    
    public void setExtra(String Extra) {
        this.extra = Extra;
    }
    
    
    //----MÉTODOS
    
    
    
	
}
