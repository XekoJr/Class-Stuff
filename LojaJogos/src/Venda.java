import java.time.LocalDate;
import java.util.HashSet;

public class Venda {
	private Empregado empregado;
	private LocalDate horas;
	private HashSet<Jogo> jogos;
	
	//----CONSTRUTORES
	public Venda(Empregado Empregado, LocalDate Horas) {
		this.empregado = Empregado;
		this.horas = Horas;
		this.jogos = new HashSet<>();
	}
	
	
	//----GETTERS
	public Empregado getEmpregado() {
		return empregado;
	}
	
	public LocalDate getHoras() {
		return horas;
	}
	
	public HashSet<Jogo> getJogos() {
		return jogos;
	}
	
	
	//----SETTERS
	public void setEmpregado(Empregado Empregado) {
		this.empregado = Empregado;
	}
	
	public void setHoars(LocalDate Horas) {
		this.horas = Horas;
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
