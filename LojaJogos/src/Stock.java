import java.io.Serializable;

public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private int quantidade;
	private int vendas;
	private Boolean disponibilidade;
	
	//----CONSTRUTORES
	public Stock(int Quantidade) {
		this.quantidade = Quantidade;
		this.vendas = 0;
		if(Quantidade > 0) {
			this.disponibilidade = true;
		} else {
			this.disponibilidade = false;
		}
	}
	
	
	//----GETTERS
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getVendas() {
		return vendas;
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
	
	public void setVendas(int Vendas) {
        this.vendas = Vendas;
    }
	
	
	
	

}
