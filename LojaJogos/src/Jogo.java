import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String saga;
    private String estilo;
    private String plataforma;
    private float duracao; //em Horas
    private String produtora;
    private String diretor;
    private Stock stock;
    private String localizacao;
    private Boolean pesquisado;
    private int pesquisadoC;
    private Boolean promocao;
    private String extra;
    private float custoCompra;
    private float custoVenda;
    private String fornecedor;
    
    
    //----CONSTRUTOR
    public Jogo(String Nome, String Saga, String Estilo, String Plataforma, float Duracao, String Pr, String Dr, Stock St, String Lc, float cCompra, String f) {
    	
    	this.nome = Nome;
    	this.saga = Saga;
    	this.estilo = Estilo;
    	this.plataforma = Plataforma;
    	this.duracao = Duracao;
    	this.produtora = Pr;
    	this.diretor = Dr;
    	this.stock = St;
    	this.localizacao = Lc;
    	this.pesquisado = false;
    	this.pesquisadoC = 0;
    	this.promocao = false;
    	this.extra = "";
    	this.custoCompra = cCompra;
    	this.custoVenda  = (float) (custoCompra * 2);
    	this.fornecedor = f;
    	
    }
    
    //----MOSTRA JOGO
    public void mostraJogo() {
        System.out.println("Detalhes do Jogo:");
        if(promocao == true) {
        	System.out.println("******PROMOÇÃO******");
        	
        }
        System.out.println("Nome: " + this.nome);
        System.out.println("Saga: " + this.saga);
        System.out.println("Estilo: " + this.estilo);
        System.out.println("Plataforma: " + this.plataforma);
        System.out.println("Duração: " + this.duracao + " horas");
        System.out.println("Produtora: " + this.produtora);
        System.out.println("Diretor: " + this.diretor);
        System.out.println("Quantidade em stock: " + this.stock.getQuantidade());
        System.out.println("Localização: " + this.localizacao);
        System.out.println("Custo de venda: " + this.custoVenda);
        if(stock.getDisponibilidade() == false) {
        	System.out.println("***Sem Stock***");
        }
        System.out.println();
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
    
    public String getPlataforma() {
        return plataforma;
    }
    
    public Float getDuracao() {
        return duracao;
    }
    
    public String getProdutora() {
        return produtora;
    }
    
    public String getDiretor() {
        return diretor;
    }
    
    public Stock getStock() {
        return stock;
    }
    
    public String getLocalizacao() {
        return localizacao;
    }
    
    public Boolean getPesquisado() {
        return pesquisado;
    }
    
    public int getPesquisadoC() {
    	return pesquisadoC;
    }
    
    public Boolean getPromocao() {
        return promocao;
    }
    
    public String getExtra() {
        return extra;
    }
    
    public Float getCustoCompra() {
        return custoCompra;
    }
    
    public Float getCustoVenda() {
        return custoVenda;
    }
    
    public String getFornecedor() {
        return fornecedor;
    }
    
    
    //----SETTERS
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public void setSaga(String Saga) {
        this.saga = Saga;
    }
    
    public void setEstilo(String Estilo) {
        this.estilo = Estilo;
    }
    
    public void setPlataforma(String Plataforma) {
        this.plataforma = Plataforma;
    }
    
    public void setDuracao(Float Duracao) {
    	this.duracao = Duracao;
    }
    
    public void setProdutora(String Pr) {
        this.produtora = Pr;
    }
    
    public void setDiretor(String Dr) {
        this.diretor = Dr;
    }
    
    public void setStock(Stock St) {
        this.stock = St;
    }
    
    public void setPesquisado(Boolean p) {
    	this.pesquisado = p;
    }
    
    public void setPesquisadoC(int i) {
    	this.pesquisadoC = i;
    }
    
    public void setPromocao(Boolean p) {
    	this.promocao = p;
    }
    
    public void setLocalizacao(String Lc) {
        this.localizacao = Lc;
    }
    
    public void setExtra(String Extra) {
        this.extra = Extra;
    }
    
    public void setCustoCompra(Float cCompra) {
    	this.custoCompra = cCompra;
    }
    
    public void setCustoVenda(Float cVenda) {
    	this.custoVenda = cVenda;
    }
    
    public void setFornecedor(String f) {
    	this.fornecedor = f;
    }
    
    //----MÉTODOS
    
    
	
}
