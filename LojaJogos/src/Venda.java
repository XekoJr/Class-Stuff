import java.time.LocalDate;
import java.util.HashSet;

public class Venda {
	private Empregado empregado;
	private String horas;
	private String cliente;
	private HashSet<Produto> produtos;
	private float custo;
	
	//----CONSTRUTORES
	public Venda(String Cliente, Empregado Empregado, String Horas, HashSet<Produto> Produtos) {
		this.empregado = Empregado;
		this.horas = Horas;
		this.produtos = Produtos;
		this.cliente = Cliente;
		this.custo = 0;
	}
	
	//----MOSTRA VENDA
	public void mostraVenda() {
		System.out.println("Detalhes de Venda:");
		System.out.println("Cliente: " + this.cliente);
		System.out.println("Empregado: " + this.empregado.getNome() + "  Data: " + this.horas + "  Custo Total: " + this.getCusto());
		for (Produto p : this.produtos) {
			
			System.out.print("Produto: " + p.getNome());
			System.out.println();
						
		}
		System.out.println();
	}
	
	
	//----GETTERS
	public Empregado getEmpregado() {
		return empregado;
	}
	
	public String getHoras() {
		return horas;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public HashSet<Produto> getProdutos() {
		return produtos;
	}
	
	public float getCusto() {
		return custo;
	}
	
	
	//----SETTERS
	public void setEmpregado(Empregado Empregado) {
		this.empregado = Empregado;
	}
	
	public void setHoars(String Horas) {
		this.horas = Horas;
	}
	
	public void setCliente(String c) {
		this.cliente = c;
	}
	
	public void setProduto(HashSet<Produto> Produtos) {
        this.produtos = Produtos;
    }
	
	public void setCusto(float f) {
		this.custo = f;
	}

}
