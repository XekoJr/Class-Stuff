import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public class Produtora implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String nome;
    private String email;
    private String paginaWeb;
    private String morada;
    private String moradaFas;
    private Diretor diretor;
    private String extra;
    private HashSet<Jogo> jogos;
    
 	//----CONSTRUTORES
    public Produtora(String Nome, String Email, LocalDate DN, String pagina, String Morada, String MoradaFas, Diretor Dr) {
    	
    	this.nome = Nome;
        this.email = Email;
        this.paginaWeb = pagina;
        this.morada = Morada;
        this.moradaFas = MoradaFas;
        this.diretor = Dr;
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
    
    public String getPaginaWeb() {
        return paginaWeb;
    }
    
    public String getMorada() {
        return morada;
    }
    
    public String getMoradaFas() {
        return moradaFas;
    }
    
    public Diretor getDiretor() {
        return diretor;
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
    
    public void setPaginaWeb(String PaginaWeb) {
        this.paginaWeb = PaginaWeb;
    }
    
    public void setMorada(String Morada) {
        this.morada = Morada;
    }
    
    public void setMoradaFas(String MoradaFas) {
        this.moradaFas = MoradaFas;
    }
    
    public void setDiretor(Diretor Diretor) {
        this.diretor = Diretor;
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
