import java.io.Serializable;

public class Empregado implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String nome;
	private int num;
	private String morada;
	
	//----CONSTRUTOR
	public Empregado(String Nome, int Num, String Morada) {
		
		this.nome = Nome;
		this.num = Num;
		this.morada = Morada;
		
	}
	
	//----MOSTRA EMPREGADO
	public void mostraEmpregado() {
		System.out.println("Detalhes de Empregado: ");
		System.out.println("Nome: " + this.nome);
		System.out.println("Numero: " + this.num);
		System.out.println("Morada: " + this.morada);
		System.out.println();
	}
	
	
	//----GETTERS
    public String getNome() {
        return nome;
    }
    
    public int getNum() {
		return num;
	}
    
    public String getMorada() {
        return morada;
    }
    
    
    //----SETTERS
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public void setMorada(String Morada) {
        this.morada = Morada;
    }
    
    public void setNum(int Num) {
		this.num = Num;
	}
    
    

}
