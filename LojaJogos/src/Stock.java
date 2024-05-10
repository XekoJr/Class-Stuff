
public class Stock {
	private int quantidade;
	private Boolean disponibilidade;
	
	//----CONSTRUTORES
	public Stock(int Quantidade, Boolean Disponibilidade) {
		this.quantidade = Quantidade;
		this.disponibilidade = Disponibilidade;
	}
	
	
	//----GETTERS
	public int getQuantidade() {
		return quantidade;
	}
	
	public Boolean getDisponibilidade() {
		return disponibilidade;
	}
	
	
	//----SETTERS
	public void setQuantidade(int Quantidade) {
        this.quantidade = Quantidade;
    }
	
	public void setDisponibilidade(Boolean Disponibilidade) {
        this.disponibilidade = Disponibilidade;
    }
	
	
	
	
	
	

}
