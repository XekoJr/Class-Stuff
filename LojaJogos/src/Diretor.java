import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public class Diretor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String email;
    private LocalDate nascimento; //(ano, mês, dia)
    private String paginaWeb;
    private String morada;
    private String moradaFas;
    private Produtora produtora;
    private String extra;
    private HashSet<Jogo> jogos;
    
	//----CONSTRUTORES
    public Diretor(String Nome, String Email, LocalDate DN, String pagina, String Morada, String MoradaFas, Produtora Pr) {
    	
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
    
    
    //----GETTERS
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public LocalDate getNascimento() {
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
    
    public void setNascimento(LocalDate Nascimento) {
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
    
    
    
    
    
    
}
