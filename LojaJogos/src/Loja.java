import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Loja implements Serializable {
    private static final long serialVersionUID = 1L;
	private HashSet<Produto> produtos;
	private HashSet<Jogo> jogos;
	private HashMap<Jogo, Integer> pesquisadoRegistado;
	private HashMap<Jogo, Integer> jogoPromo;
	private HashSet<Diretor> diretores;
	private HashSet<Produtora> produtoras;
	private HashSet<Empregado> empregados;
	private HashSet<Cliente> clientes;
	private HashSet<Fornecedor> fornecedores ;
	private HashSet<Venda> vendas;
	private HashSet<Estilo> estilos;
	private String fileJogos = "jogos.obj";
	private String fileJogosPR = "jogosPR.obj";
	private String fileJogosP = "jogosR.obj";
	private String fileProdutos = "produtos.obj";
	private String fileDiretores = "diretores.obj";
	private String fileProdutoras = "produtoras.obj";
	private String fileEmpregados = "empregados.obj";
	private String fileClientes = "clientes.obj";
	private String fileFornecedores = "fornecedores.obj";
	private String fileEstilos = "estilos.obj";
	
	public Loja() {
        this.produtos = new HashSet<Produto>();
        this.jogos = new HashSet<Jogo>();
        this.diretores = new HashSet<Diretor>();
        this.produtoras = new HashSet<Produtora>();
        this.empregados = new HashSet<Empregado>();
        this.clientes = new HashSet<Cliente>();
        this.fornecedores = new HashSet<Fornecedor>();
        this.vendas = new HashSet<Venda>();
        this.estilos = new HashSet<Estilo>();
        this.jogoPromo = new HashMap<Jogo, Integer>();
        this.pesquisadoRegistado = new HashMap<Jogo, Integer>();
	}
	
	//----MÉTODOS
	
	public void lisProd() {
		for(Produto p : produtos) {
			p.mostraProduto();
		}
	}
	
	//---Carregar todos os ficheiros
	public void loadFiles() 
	  throws java.io.IOException, ClassNotFoundException {
		
		System.out.println("A carregar dados..");
		
		try {
			
			if (this.jogos == null) {

	            this.jogos = new HashSet<Jogo>();

	        }
			
			jogos = Ficheiro.loadJogos(fileJogos);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar jogos..");
			System.out.println();
		}
		
		try {
			
			if (this.pesquisadoRegistado == null) {

	            this.pesquisadoRegistado = new HashMap<Jogo, Integer>();

	        }
			
			pesquisadoRegistado = Ficheiro.loadJogosM(fileJogosPR);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar jogos pesquisados e registados..");
			System.out.println();
		}
		
		try {
			
			if (this.jogoPromo == null) {

	            this.jogoPromo = new HashMap<Jogo, Integer>();

	        }
			
			jogoPromo = Ficheiro.loadJogosM(fileJogosP);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar jogos comprados em promoção..");
			System.out.println();
		}
		
		try {
			produtos = Ficheiro.loadProdutos(fileProdutos);
		
		} catch(Exception e) {
			System.out.println("Falha a carregar produtos..");
			System.out.println();
		}

		try {
			diretores = Ficheiro.loadDiretores(fileDiretores);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar diretores..");
			System.out.println();
		}
		
		try {
			produtoras = Ficheiro.loadProdutoras(fileProdutoras);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar produtoras..");
			System.out.println();
		}
		
		try {
			empregados = Ficheiro.loadEmpregados(fileEmpregados);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar produtoras..");
			System.out.println();
		}
		
		try {
			clientes = Ficheiro.loadClientes(fileClientes);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar clientes..");
			System.out.println();
		}
		
		try {
			fornecedores = Ficheiro.loadFornecedores(fileFornecedores);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar fornecedores..");
			System.out.println();
		}

		try {
			estilos = Ficheiro.loadEstilos(fileEstilos);
		
		} catch(IOException e) {
			System.out.println("Falha a carregar estilos de jogos..");
			System.out.println();
		}
	
	}
	
	//---Guardar todos os ficheiros
	public void saveFiles() 
	  throws java.io.IOException, ClassNotFoundException {
			
		try {
			Ficheiro.saveJogos(fileJogos, jogos);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar jogos..");
			System.out.println();
		}
		
		try {
			Ficheiro.saveJogosM(fileJogosPR, pesquisadoRegistado);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar jogos pesquisados e registados..");
			System.out.println();
		}
		
		try {
			Ficheiro.saveJogosM(fileJogosP, jogoPromo);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar jogos comprados em promoção..");
			System.out.println();
		}
			
		try {
			Ficheiro.saveProdutos(fileProdutos, produtos);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar produtos..");
			System.out.println();
		}
			
		try {
			Ficheiro.saveDiretores(fileDiretores, diretores);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar diretores..");
			System.out.println();
		}

		try {
			Ficheiro.saveProdutoras(fileProdutoras, produtoras);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar produtoras..");
			System.out.println();
		}

		try {
			Ficheiro.saveEmpregados(fileEmpregados, empregados);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar empregados..");
			System.out.println();
		}

		try {
			Ficheiro.saveClientes(fileClientes, clientes);
		
		} catch(IOException e) {
			System.out.println("Falha a guardar clientes..");
			System.out.println();
		}

		try {
			Ficheiro.saveClientes(fileClientes, clientes);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar clientes..");
			System.out.println();
		}

		try {
			Ficheiro.saveFornecedores(fileFornecedores, fornecedores);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar clientes..");
			System.out.println();
		}

		try {
			Ficheiro.saveEstilos(fileEstilos, estilos);
			
		} catch(IOException e) {
			System.out.println("Falha a guardar clientes..");
			System.out.println();
		}
	
		System.out.println("A sair e guardar os dados..");
		
	}
	
	
	//----JOGOS-------------------------------------------------
	
	//---ADICIONAR Jogo
	public void addJogo(Jogo j) {
		
		if (this.jogos == null) {

            this.jogos = new HashSet<Jogo>();

        }
		
		jogos.add(j);
	}
	
	public void lisJogo() {
		
		if (this.jogos == null) {

            this.jogos = new HashSet<Jogo>();

        }
		
		for(Jogo a : jogos) {
			a.mostraJogo();
		}
	}
	
	//---REMOVER Jogo por nome, saga e plataforma
	public boolean remJogo(String nome, String saga, String plataforma) {
		
		if (this.jogos == null) {

            this.jogos = new HashSet<Jogo>();

        }
		
		for(Jogo j : jogos) {
			
			if((j.getNome().equals(nome)) && (j.getSaga().equals(saga)) && (j.getPlataforma().equals(plataforma))) {
				jogos.remove(j);
				
				return true;
			}
			
		}
		
		return false;
		
	}
	
	//---PROCURAR Jogo por nome, saga e plataforma
	public Jogo srcJogoN(String nome, String saga, String plataforma) {
		
		if (this.jogos == null) {

            this.jogos = new HashSet<Jogo>();

        }
			
		for(Jogo j : jogos) {
				
			if((j.getNome().equals(nome)) && (j.getSaga().equals(saga)) && (j.getPlataforma().equals(plataforma))) {

					return j;
					
			}
		}
			
		System.out.println("O jogo \"" + nome + "\" não foi encontrado.");
		return null;
			
	}
	
	//---DEFINAR JOGOS COMO NÃO PESQUISADOS
	public void allJogoPesquisadoF() {
		
		if (this.jogos == null) {

            this.jogos = new HashSet<Jogo>();

        }
				
		for(Jogo j : jogos) {
					
			j.setPesquisado(false);
						
		}
						
	}
	
	//---VERIFICAR SE ALGUM JOGO NO PRODUTO FOI PESQUISADO e adicionar ao contador +1 de unidades compradas depois de pesquisadas
	public boolean jogoSrc(Produto p) {
		
		for(Jogo j : p.getJogos()) {
		
			if(j.getPesquisado() == true) {
				j.setPesquisadoC(j.getPesquisadoC() + 1);
				return true;
			} 
		
		}

		return false;
		
	}
	
	//---PROCURAR OS 5 JOGOS MAIS VENDIDOS
	public Jogo[] top5() {
		
		int c = 0;
		
		for(Jogo j : jogos) {
			
			c += 1;
			
		}
		
		Jogo[] all = new Jogo[c];
		
		int i = 0;
		for(Jogo j : jogos) {
			
			all[i] = j;
			i++;
			
		}
		
		Arrays.sort(all, Comparator.comparingInt(j -> ((Jogo) j).getStock().getVendas()).reversed());
        
        Jogo[] top5 = new Jogo[5];
        for (int j = 0; j < 5; j++) {
            top5[j] = all[j];
        }
        
        return top5;
		
	}
	
	//---HashMaps
	
	public void addJogoMP(Jogo j, int k) {
		
		if(jogoPromo.containsKey(j)) {
			
			int i = jogoPromo.get(j);
			jogoPromo.put(j, i + k);
			
		} else {
			
			jogoPromo.put(j, k);
			
		}
		
	}
	
	public void addJogoMPR(Jogo j, int k) {
		
		if(pesquisadoRegistado.containsKey(j)) {
			
			int i = pesquisadoRegistado.get(j);
			pesquisadoRegistado.put(j, i + k);
			
		} else {
			
			pesquisadoRegistado.put(j, k);
			
		}
		
	}
	
	public void mostraJogoMPR() {
		
		for (Entry<Jogo, Integer> entry : pesquisadoRegistado.entrySet()) {
			
            System.out.println("Jogo: " + entry.getKey().getNome() + ", saga: " + entry.getKey().getSaga() + ", plataforma: " + entry.getKey().getPlataforma() + " x" + entry.getValue());
            
        }
		
	}
	
	public void mostraJogoMP() {
		
		for (Entry<Jogo, Integer> entry : jogoPromo.entrySet()) {
			
			System.out.println("Jogo: " + entry.getKey().getNome() + ", saga: " + entry.getKey().getSaga() + ", plataforma: " + entry.getKey().getPlataforma() + " x" + entry.getValue());
            
        }
		
	}
	
		
	//----PRODUTOS-------------------------------------------------
	
	//---ADICIONAR Produto
	public void addProduto(Produto p) {
		
		if (this.produtos == null) {

            this.produtos = new HashSet<Produto>();

        }
		
		produtos.add(p);
	}
	
	//---REMOVER Produto por nome
	public boolean remProduto(String nome) {
		
		if (this.produtos == null) {

            this.produtos = new HashSet<Produto>();

        }
			
		for(Produto p : produtos) {
				
			if(p.getNome().equals(nome)) {
				produtos.remove(p);
				return true;
			}
				
		}
		
		return false;
			
	}
	
	//---CONTAR NUMERO DE PRODUTOS DENTRO DO HASHSET
	public int cProduto(HashSet<Produto> P) {
		
		return P.size();
		
	}
	
	//---CONTAR NUMERO DE jogos dentro de hashset
	public int cJogo(HashSet<Jogo> P) {
			
		int c = 0;
			
		for (Jogo p : P) {
				
			c += 1;
				
		}
			
		return c;
			
	}
	
	//---PROCURAR PRODUTO POR NOME
	public Produto srcProduto(String nome) {
		
		if (this.produtos == null) {

            this.produtos = new HashSet<Produto>();

        }
		
		for(Produto p : produtos) {
			
			if(p.getNome().equals(nome)) {
				return p;
			}
				
		}
		
		System.out.println("O produto \"" + nome + "\" não foi encontrado.");
		return null;
		
	}
	
	//---PROCURAR TOOOODOS OS PRODUTOS POR NOME
	public HashSet<Produto> srcJogoNome(String nome) {
		
		HashSet<Produto> P = new HashSet<>();
		
		for(Produto pr : produtos) {
					
			if(pr.getNome().equals(nome)) {
				
				P.add(pr);
				
			}
			
		}		
						
		return P;
				
	}
	
	//---PROCURAR TOOOODOS OS PRODUTOS POR ESTILO
	public HashSet<Jogo> srcJogoEstilo(String nome) {
			
		for(Estilo e : estilos) {
			
			if(e.getNome().equals(nome)) {
				
				return e.getJogos();
				
			}
			
		}
		
		return null;
					
	}
	
	//---PROCURAR TOOOODOS OS PRODUTOS POR Formato
	public HashSet<Jogo> srcJogoFormato(String nome) {
		
		HashSet<Jogo> P = new HashSet<>();
							
		for(Jogo j : jogos) {
					
			if(j.getPlataforma().equals(nome)) {
						
				P.add(j);
						
			}
					
		}		
								
		return P;
						
	}
	
	//---PROCURAR TOOOODOS OS JOGOS POR DIRETOR
	public HashSet<Jogo> srcJogoDiretor(String nome) {
			
		for(Diretor d : diretores) {
						
			if(d.getNome().equals(nome)) {
					
				return d.getJogos();
					
			}
				
		}		
							
		return null;
					
	}
	
	//---PROCURAR TOOOODOS OS JOGOS POR Produtora
	public HashSet<Jogo> srcJogoProdutora(String nome) {
				
		for(Produtora p : produtoras) {
							
			if(p.getNome().equals(nome)) {
						
				return p.getJogos();
						
			}
					
		}		
								
		return null;
						
	}
	
	//---LISTAR TODOS OS JOGOS
	public HashSet<Produto> allProduto() {
		
		if (this.produtos == null) {

            this.produtos = new HashSet<Produto>();

        }
		
		return produtos;
	}
	
	
	
	
	//----DIRETORES-------------------------------------------------
	
	//---ADICIONAR Diretor
	public void addDiretor(Diretor d) {
		
		if (this.diretores == null) {

            this.diretores = new HashSet<Diretor>();

        }
		
		diretores.add(d);
	}
	
	//---REMOVER Diretor por nome
	public boolean remDiretor(String nome) {
		
		if (this.diretores == null) {

            this.diretores = new HashSet<Diretor>();

        }
				
		for(Diretor d : diretores) {
					
			if(d.getNome().equals(nome)) {
				diretores.remove(d);
				return true;
			}
					
		}
		
		return false;
				
	}
	
	//---REMOVER DO DIRETOR UM JOGO
	public void remJogoDiretor(Diretor diretor, Jogo jogo) {
		
		for(Diretor d : diretores) {
			
			if(diretor == d) {
				
				for(Jogo j : d.getJogos()) {
					
					if((j.getNome().equals(jogo.getNome())) && (j.getSaga().equals(jogo.getSaga())) && (j.getPlataforma().equals(jogo.getPlataforma()))) {
						d.getJogos().remove(jogo);
					}
					
				}
				
			}
			
		}
		
	}
	
	//---PROCURAR Diretor por nome
	public Diretor srcDiretor(String nome) {
		
		if (this.diretores == null) {

            this.diretores = new HashSet<Diretor>();

        }
			
		for(Diretor d : diretores) {
				
			if(d.getNome().equals(nome)) {
				return d;
			}
					
		}
			
		System.out.println("O diretor \"" + nome + "\" não foi encontrado.");
		return null;
			
	}
	
	//---PROCURAR O diretor com jogos MAIS VENDIDOS
	public Diretor topDiretor() {
		
		int mVendas = 0;
		for(Diretor d : diretores) {
					
			int totalVendasDiretor = d.getTotalVendas();
					
			if(totalVendasDiretor > mVendas) {
				mVendas = totalVendasDiretor;
			}
					
			        
		}
				
		for(Diretor d : diretores) {
					
			if (d.getTotalVendas() == mVendas) {
				return d;
			}
				
		}
				
		return null;
				
	}
	
	
	//----PRODUTORAS-------------------------------------------------
	
	//---ADICIONAR Produtora
	public void addProdutora(Produtora p) {
		
		if (this.produtoras == null) {

            this.produtoras = new HashSet<Produtora>();

        }
		
		produtoras.add(p);
	}
	
	//---REMOVER Produtora por nome
	public boolean remProdutora(String nome) {
		
		if (this.produtoras == null) {

            this.produtoras = new HashSet<Produtora>();

        }
					
		for(Produtora p : produtoras) {
						
			if(p.getNome().equals(nome)) {
				produtoras.remove(p);
				return true;
			}
						
		}
		
		return false;
					
	}
	
	//---REMOVER DO Produtora UM JOGO
	public void remJogoProdutora(Produtora produtora, Jogo jogo) {
			
		for(Produtora p : produtoras) {
				
			if(produtora == p) {
					
				for(Jogo j : p.getJogos()) {
						
					if((j.getNome().equals(jogo.getNome())) && (j.getSaga().equals(jogo.getSaga())) && (j.getPlataforma().equals(jogo.getPlataforma()))) {
						p.getJogos().remove(jogo);
					}
						
				}
					
			}
				
		}
			
	}
	
	//---PROCURAR Produtora por nome
	public Produtora srcProdutora(String nome) {
		
		if (this.produtoras == null) {

            this.produtoras = new HashSet<Produtora>();

        }
				
		for(Produtora p : produtoras) {
					
			if(p.getNome().equals(nome)) {
				return p;
			}
						
		}
				
		System.out.println("A produtora \"" + nome + "\" não foi encontrada.");
		return null;
				
	}
	
	//---PROCURAR a produtora com jogos MAIS VENDIDOS
	public Produtora topProdutora() {	
					
		int mVendas = 0;
		for(Produtora p : produtoras) {
						
			int totalVendasProdutora = p.getTotalVendas();
						
			if(totalVendasProdutora > mVendas) {
				mVendas = totalVendasProdutora;
			}
										        
		}
					
		for(Produtora p : produtoras) {
						
			if (p.getTotalVendas() == mVendas) {
				return p;
			}
					
		}
					
		return null;
					
	}
	
	//----EMPREGADOS-------------------------------------------------
	
	//---ADICIONAR Empregado
	public void addEmpregado(Empregado e) {
		
		if (this.empregados == null) {

            this.empregados = new HashSet<Empregado>();

        }
		
		empregados.add(e);
	}
		
	//---REMOVER empregado por nome
	public boolean remEmpregado(String nome) {
		
		if (this.empregados == null) {

            this.empregados = new HashSet<Empregado>();

        }
						
		for(Empregado e : empregados) {
							
			if(e.getNome().equals(nome)) {
				empregados.remove(e);
				return true;
			}
							
		}
		
		return false;
						
	}
		
	//---PROCURAR empregado por nome
	public Empregado srcEmpregado(String nome) {
		
		if (this.empregados == null) {

            this.empregados = new HashSet<Empregado>();

        }
					
		for(Empregado e : empregados) {
						
			if(e.getNome().equals(nome)) {
				return e;
			}
							
		}
					
		System.out.println("O Empregado \"" + nome + "\" não foi encontrado.");
		return null;
					
	}

	
	
	//----CLIENTES-------------------------------------------------
		
	//---ADICIONAR Cliente
	public void addCliente(Cliente c) {
		
		if (this.clientes == null) {

            this.clientes = new HashSet<Cliente>();

        }
		
		clientes.add(c);
	}
			
	//---REMOVER cliente por nome
	public boolean remCliente(String n) {
		
		if (this.clientes == null) {

            this.clientes = new HashSet<Cliente>();

        }
							
		for(Cliente c : clientes) {
								
			if(c.getNome().equals(n)) {
				clientes.remove(c);
				return true;
			}
								
		}
		
		return false;
							
	}
	
	//---REMOVER cliente por numero
	public Cliente srcClienteN(int n) {
		
		if (this.clientes == null) {

            this.clientes = new HashSet<Cliente>();

        }
							
		for(Cliente c : clientes) {
								
			if(c.getNum() == n) {
				return c;
			}
								
		}
		
		return null;
							
	}
			
	//---PROCURAR cliente por numero
	public Cliente srcCliente(String n) {
		
		if (this.clientes == null) {

            this.clientes = new HashSet<Cliente>();

        }
						
		for(Cliente c : clientes) {
							
			if(c.getNome().equals(n)) {
				return c;
			}
								
		}
						
		System.out.println("O Cliente \"" + n + "\" não foi encontrado.");
		return null;
						
	}
		
	//---GUARDAR pesquisas dos clientes em txt
	public void saveClientePes() 
	  throws IOException{
		
		if (this.clientes == null) {

            this.clientes = new HashSet<Cliente>();

        }
		
		for(Cliente c : clientes) {
			
			c.savePesquisas();
								
		}
		
	}
		
	//----FORNECEDORES-------------------------------------------------
	
	//---ADICIONAR Fornecedor
	public void addFornecedor(Fornecedor f) {
		
		if (this.fornecedores == null) {

            this.fornecedores = new HashSet<Fornecedor>();

        }
		
		fornecedores.add(f);
	
	}
			
	//---REMOVER Fornecedor por nome
	public boolean remFornecedor(String nome) {
		
		if (this.fornecedores == null) {

            this.fornecedores = new HashSet<Fornecedor>();

        }
							
		for(Fornecedor f : fornecedores) {
								
			if(f.getNome().equals(nome)) {
				fornecedores.remove(f);
				return true;
			}
								
		}
			
		return false;
							
	}
	
	//---REMOVER Da Fornecedora UM JOGO
	public void remJogoFornecedora(Fornecedor fornecedor, Jogo jogo) {
				
		for(Fornecedor f : fornecedores) {
					
			if(fornecedor == f) {
						
				for(Jogo j : f.getJogos()) {
							
					if((j.getNome().equals(jogo.getNome())) && (j.getSaga().equals(jogo.getSaga())) && (j.getPlataforma().equals(jogo.getPlataforma()))) {
						f.getJogos().remove(jogo);
					}
							
				}
						
			}
					
		}
				
	}
			
	//---PROCURAR Fornecedor por nome
	public Fornecedor srcFornecedor(String nome) {
		
		if (this.fornecedores == null) {

            this.fornecedores = new HashSet<Fornecedor>();

        }
		
		if(fornecedores == null) {
			return null;
		}
		
		for(Fornecedor f : fornecedores) {
							
			if(f.getNome().equals(nome)) {
				return f;
			}
								
		}
						
		System.out.println("O Fornecedor \"" + nome + "\" não foi encontrado.");
		return null;
						
	}
	
	//----VENDAS-------------------------------------------------------
		
	//---ADICIONAR Venda
	public void addVenda(Venda v) {
		
		if (this.vendas == null) {

            this.vendas = new HashSet<Venda>();

        }
		
		vendas.add(v);
	}
				
	//---REMOVER Venda por cliente e produtos
	public boolean remVenda(String cliente, HashSet<Produto> produtos) {
		
		if (this.vendas == null) {

            this.vendas = new HashSet<Venda>();

        }
								
		for(Venda v : vendas) {
									
			if((v.getCliente().equals(cliente)) || (v.getProdutos()).equals(produtos)) {
				vendas.remove(v);
				return true;
			}
									
		}
				
		return false;
								
	}
				
	//---PROCURAR Venda por cliente e produtos
	public Venda srcVenda(String cliente, HashSet<Produto> produtos) {
		
		if (this.vendas == null) {

            this.vendas = new HashSet<Venda>();

        }
							
		for(Venda v : vendas) {
								
			if((v.getCliente().equals(cliente)) || (v.getProdutos()).equals(produtos)) {
				return v;
			}
									
		}
							
		System.out.println("A Venda não foi encontrada.");
		return null;
							
	}
	
	//---LISTAR Vendas
	public void lisVenda() {
		
		if (this.vendas == null) {

            this.vendas = new HashSet<Venda>();

        }
		
		for (Venda v : vendas) {
			
			v.mostraVenda();
			
		}
		
	}
	
	
	
	//---Carrega as vendas do ficheiro para o hashset
	public void loadVendas() throws java.io.IOException {
		
	    File f = new File("vendas.txt");
	    
	    if (!f.exists()) {
	        f.createNewFile();
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	    	
	        String linha;
	        Empregado emp = null;
	        String horas = "";
	        String nomeCliente = "";
	        float custo = 0;
	        HashSet<Produto> produtos = new HashSet<>();

	        while ((linha = br.readLine()) != null) {
	        	
	            if (linha.trim().isEmpty()) {
	            	
	                if (emp != null && !produtos.isEmpty()) {
	                	
	                    Venda v = new Venda(nomeCliente, emp, horas, produtos);
	                    v.setCusto(custo);
	                    vendas.add(v);
	                    produtos = new HashSet<>();
	                    
	                }
	                
	            } else if (linha.startsWith("Produto: ")) {
	            	
	                String nomeProduto = linha.substring(9);
	                produtos.add(new Produto(nomeProduto));
	                
	            } else {
	            	
	                String[] partes = linha.split(" - ");
	                String nomeE = partes[0];
	                emp = new Empregado(nomeE, 0, "x");
	                horas = partes[1];
	                nomeCliente = partes[2];
	                custo = Float.parseFloat(partes[3]);
	                
	            }
	            
	        }

	        if (emp != null && !produtos.isEmpty()) {
	        	
	            Venda v = new Venda(nomeCliente, emp, horas, produtos);
	            v.setCusto(custo);
	            vendas.add(v);
	            
	        }
	        
	    } catch (IOException e) {
	        System.out.println("Erro ao carregar vendas do ficheiro.");
	    }
	}


		

    //---Guarda as vendas no ficheiro
	public void saveVendas() throws java.io.IOException {
	    File f = new File("vendas.txt");

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
	    	
	        if (vendas != null) {
	        	
	            for (Venda v : vendas) {
	            	
	                if (v.getEmpregado().getNome() != null) {
	                	
	                    float total = v.getCusto();

	                    String cNome = (v.getCliente() == null) ? "N/A" : v.getCliente();
	                    bw.write(v.getEmpregado().getNome() + " - " + v.getHoras() + " - " + cNome + " - " + total);
	                    bw.newLine();

	                    for (Produto p : v.getProdutos()) {
	                    	
	                        bw.write("Produto: " + p.getNome());
	                        bw.newLine();
	                        
	                    }

	                    bw.newLine();
	                }
	            }
	        }
	        
	    } catch (IOException e) {
	        System.out.println("Erro ao guardar vendas no ficheiro.");
	    }
	    
	}

	
	//----ESTILO.-----------------------------------------------------------
    
    //---ADICIONAR ESTILO
    public void addEstilo(Estilo e) {
    	estilos.add(e);
    }
    
    //---PROCURAR estilo
  	public Estilo srcEstilo(String nome) {
  		
  		if(estilos == null) {
  			return null;
  		}
  		
  		for(Estilo e : estilos) {
  				
  			if(e.getNome().equals(nome)) {
  				return e;
  			}
  					
  		}
  			
  		System.out.println("O estilo \"" + nome + "\" não foi encontrado.");
  		return null;
  			
  	}
	
  	//---PROCURAR a produtora com jogos MAIS VENDIDOS
  	public Estilo topEstilo() {	
  					
  		int pesquisas = 0;
  		for(Estilo e : estilos) {
  						
  			int p = e.getPesquisas();
  						
  			if(p > pesquisas) {
  				pesquisas = p;
  			}
  										        
  		}
  					
  		for(Estilo e : estilos) {
  						
  			if (e.getPesquisas() == pesquisas) {
  				return e;
  			}
  					
  		}
  					
  		return null;
  					
  	}
  	
  	//---REMOVER Do estilo UM JOGO
  	public void remJogoEstilo(Estilo estilo, Jogo jogo) {
  				
  		for(Estilo e : estilos) {
  					
  			if(estilo == e) {
  						
  				for(Jogo j : e.getJogos()) {
  							
  					if((j.getNome().equals(jogo.getNome())) && (j.getSaga().equals(jogo.getSaga())) && (j.getPlataforma().equals(jogo.getPlataforma()))) {
  						e.getJogos().remove(jogo);
  					}
  							
  				}
  						
  			}
  					
  		}
  				
  	}
  	
  	
  	
  	
  	//----CARREGA DO FICHEIRO PASS A PASS
  	
  	//---Carrega a pass de admin
    public String loadPass() 
      throws java.io.IOException {
    	
    	File f = new File("src/pass.txt");
		BufferedReader fr = new BufferedReader(new FileReader(f));
		BufferedReader br = new BufferedReader(fr);
		
		try (br) {
			
			String pass = br.readLine();
						
			return pass;
			
		} catch (IOException e) {
			
			
			
		} finally {
	    	
	        if (fr != null) {
	            fr.close();
	        }
	        if (br != null) {
	            br.close();
	        }
	        
	    }
		return null;
    	
    }
	
	
}
