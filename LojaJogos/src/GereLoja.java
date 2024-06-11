import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class GereLoja {
	private Loja l;
	
	public GereLoja() {
        this.l = new Loja();
    }	
	
	
	//---Menu
	public void menu() 
	  throws java.io.IOException, ClassNotFoundException {
		
		l.loadFiles();
		l.loadVendas();
		String password = l.loadPass();
		
		int op, op1, op2, op21, op211, op212, op22, op23, op24, op241, op242, op243, op244, op245, op246, op247;
		
		do {
			
    		System.out.println("--------------Bem vindo à Loja de Jogos---------------");
			System.out.println();
			System.out.println("#1 -> Cliente");
			System.out.println("#2 -> Administrador");
			System.out.println("#3 -> Sair");
			System.out.println();
    		System.out.println("------------------------------------------------------");
    		System.out.println();
    		
			System.out.print("Escolha uma Opção - ");
			op = LeDados.leInt();
			System.out.println();
			
			switch (op) {
			
			case 1:
				
				System.out.print("Pretende fazer log in na sua conta de Clinte? (s/n)");
				char rLogIn = LeDados.leChar();
				boolean acessoC = false;
				Cliente c = null;
				System.out.println();
				 
				if ((rLogIn == 's') || (rLogIn == 'S')) {
					System.out.println("Insira o seu numero de Cliente - ");
					int numCliente = LeDados.leInt();
					c = l.srcClienteN(numCliente);
					
					int countC = 2;
					System.out.print("Para continuar deve inserir a password"); 
					String passC = LeDados.leString();	
					
					do {
						
						if(passC.equals(c.getPassword())) {
							
							System.out.println("Password Correta!");
							System.out.println();
							acessoC = true; 
							break;
						
						} else {
							
							System.out.print("Password errada, tente novamente, " + countC + " tentativas restantes");
							countC -= 1;
							passC = LeDados.leString();
							System.out.println();
							
						}
						
					} while(countC >0);
					
				} else {
					acessoC = true;
				}
								
				if (acessoC == true) {
					
					do {
				    	
						System.out.println("----------------------Cliente-------------------------");
						System.out.println();
						
						System.out.println("         ****** Jogos em destaque ******");
						try {
							
							Jogo[] destaque = l.top5();
							for(Jogo j : destaque) {
								
								System.out.println("                 #" + j.getNome());
								if(j.getStock().getDisponibilidade() == false) {
									System.out.println("                  Sem stock");
								}
								
							}
							
						} catch(Exception erro) {}
							
						System.out.println("         **********************************");
						
						System.out.println();
						System.out.println("Procurar por:");
						System.out.println("#1 -> Nome de Produto");
						System.out.println("#2 -> Estilo");
						System.out.println("#3 -> Diretor");
						System.out.println("#4 -> Produtora");
						System.out.println("#5 -> Formato");
						System.out.println("#6 -> Sair");
						System.out.println();
						System.out.println("------------------------------------------------------");
						System.out.println();
						
						System.out.print("Escolha uma Opção - ");
						op1 = LeDados.leInt();
						System.out.println();
						
						switch (op1) {
						
						case 1:
							
							System.out.println("---------------Procurar Jogo por Nome-----------------");
							System.out.println();
							
							System.out.print("Nome do Jogo");
							String pNJogo = LeDados.leString();
							System.out.println();
							
							if(c != null) {
								String str = "Nome de Jogo: " + pNJogo;

								if (c.getPesquisas() != null) {
									
									c.getPesquisas().add(str);
									
								} else {
									HashSet<String> pes = new HashSet<>();
									pes.add(str);
									c.setPesquisas(pes);
								}
								
							}
							
							HashSet<Produto> P = l.srcJogoNome(pNJogo);
								
							if(P != null) {
							
								int cjb = l.cProduto(P);
								System.out.println("-----------------" + pNJogo + "---------------------");
								System.out.println("Numero de resultados: " + cjb);
								System.out.println();
								
								for (Produto aa : P) {
									
									aa.mostraProduto();
									System.out.println();
									
									for (Jogo j : aa.getJogos()) {
										
										j.setPesquisado(true);
										
									}
																
								}
								
								System.out.println("--------------------------------------");
							
							} else {
								System.out.println("Jogo não encontrado..");
								System.out.println();
							}
							
							break;
	
						case 2:
							
							System.out.println("--------------Procurar Jogo por Estilo----------------");
							System.out.println();
							
							System.out.print("Nome do Estilo");
							String pNEstilo = LeDados.leString();
							System.out.println();
							
							if(c != null) {
								String str = "Estilo de Jogo: " + pNEstilo;

								if (c.getPesquisas() != null) {
									
									c.getPesquisas().add(str);
									
								} else {
									HashSet<String> pes = new HashSet<>();
									pes.add(str);
									c.setPesquisas(pes);
								}
								
							}
							
							Estilo e = l.srcEstilo(pNEstilo);
							
							if(e != null) {
								
								HashSet<Jogo> PE = e.getJogos();
							
								e.setPesquisas(e.getPesquisas() + 1);
								
								
								int cE = l.cJogo(PE);
								System.out.println("------------------" + pNEstilo + "---------------------");
								System.out.println("Numero de resultados: " + cE);
								System.out.println();
								
								for (Jogo j : PE) {
									
									j.mostraJogo();
									System.out.println();
									
									j.setPesquisado(true);
										
																
								}
								
								System.out.println("--------------------------------------");
							
							} else {
								System.out.println();
							}
							
							break;
							
						case 3:
							
							System.out.println("--------------Procurar Jogo por Diretor----------------");
							System.out.println();
							
							System.out.print("Nome do Diretor");
							String pNDiretor = LeDados.leString();
							System.out.println();
							
							if(c != null) {
								String str = "Nome de Diretor: " + pNDiretor;
								
								if (c.getPesquisas() != null) {
									
									c.getPesquisas().add(str);
									
								} else {
									HashSet<String> pes = new HashSet<>();
									pes.add(str);
									c.setPesquisas(pes);
								}
								
							}
							
							Diretor d = l.srcDiretor(pNDiretor);
							
							if(d != null) {

								HashSet<Jogo> JD = d.getJogos();
							
								int cD = l.cJogo(JD);
								System.out.println("------------------" + pNDiretor + "--------------------");
								System.out.println("Numero de resultados: " + cD);
								System.out.println();
								
								for (Jogo j : JD) {
									
									j.mostraJogo();
									System.out.println();
										
									j.setPesquisado(true);
														
								}
								
								System.out.println("--------------------------------------");
							
							} else {
								System.out.println();
							}
							
							break;
		
						case 4:
		
							System.out.println("-------------Procurar Jogo por Produtora---------------");
							System.out.println();
							
							System.out.print("Nome da Produtora");
							String pNProdutora = LeDados.leString();
							System.out.println();
							
							if(c != null) {
								String str = "Nome de Produtora: " + pNProdutora;

								if (c.getPesquisas() != null) {
									
									c.getPesquisas().add(str);
									
								} else {
									HashSet<String> pes = new HashSet<>();
									pes.add(str);
									c.setPesquisas(pes);
								}
								
							}
							
							Produtora p = l.srcProdutora(pNProdutora);
							
							if(p != null) {

								HashSet<Jogo> JP = p.getJogos();
							
								int cP = l.cJogo(JP);
								System.out.println("------------------" + pNProdutora + "--------------------");
								System.out.println("Numero de resultados: " + cP);
								System.out.println();
								
								for (Jogo j : JP) {
									
									j.mostraJogo();
									System.out.println();
										
									j.setPesquisado(true);
																	
								}
								
								System.out.println("--------------------------------------");
							
							} else {
								System.out.println();
							}
							
							break;
		
						case 5:
		
							System.out.println("-------------Procurar Jogo por Formato---------------");
							System.out.println();
							
							System.out.print("Nome do Formato");
							String pNFormato = LeDados.leString();
							System.out.println();
							
							if(c != null) {
								String str = "Formato de Jogo: " + pNFormato;

								if (c.getPesquisas() != null) {
									
									c.getPesquisas().add(str);
									
								} else {
									HashSet<String> pes = new HashSet<>();
									pes.add(str);
									c.setPesquisas(pes);
								}
								
							}
							
							try {
								HashSet<Jogo> PF = l.srcJogoFormato(pNFormato);
										
								int cF = l.cJogo(PF);
								System.out.println("------------------" + pNFormato + "--------------------");
								System.out.println("Numero de resultados: " + cF);
								System.out.println();
								
								for (Jogo j : PF) {
									
									j.mostraJogo();
									System.out.println();
										
									j.setPesquisado(true);
																
								}
								
								System.out.println("--------------------------------------");
							
							}  catch (Exception erro) {
								System.out.println("Formato não encontrado..");
								System.out.println();
							}
							
							break;
						
						case 6:
							System.out.println("A voltar ao menu incial..");
							
							break;
							
						default:
			                System.out.println("Opção inválida. Tente novamente.");
			                System.out.println();  
						
						}   
						
			    	} while(op1 != 6);
					
				}
				
				break;
				
			case 2:
				int count = 3;
				boolean acesso = false;
				System.out.print("Para continuar deve inserir a password"); //1234
				String pass = LeDados.leString();			
				
				System.out.println();
								
				
				do {
					
					if(password.equals(pass)) {
						
						System.out.println("Password Correta!");
						System.out.println();
						acesso = true; 
						break;
					
					} else {
								
						count -= 1;
						System.out.print("Password errada, tente novamente, " + count + " tentativas restantes");
						pass = LeDados.leString();
						
					}
					
					
					
				} while (count > 0);
				
				if (acesso == true) {
				
					//MENU DE ADMIN
					do {
			    	
						System.out.println("--------------------Administrador---------------------");
						System.out.println();
						System.out.println("#1 -> Gerir Dados");
						System.out.println("#2 -> Registo de Vendas");
						System.out.println("#3 -> Gerir Eventos");
						System.out.println("#4 -> Analisar Estatisticas");
						System.out.println("#5 -> Sair");
						System.out.println();
						System.out.println("------------------------------------------------------");
						System.out.println();
						
						System.out.print("Escolha uma Opção - ");
						op2 = LeDados.leInt();
						System.out.println();
						
						switch (op2) {
							
						case 1:
							
							do {
							
								System.out.println("---------------------Gerir Dados----------------------");
								System.out.println();
								System.out.println("#1 -> Adicionar Dados");
								System.out.println("#2 -> ALterar Dados");
								System.out.println("#3 -> Remover Dados");
								System.out.println("#4 -> Sair");
								System.out.println();
								System.out.println("------------------------------------------------------");
								System.out.println(); 
								
								System.out.print("Escolha uma Opção - ");
								op21 = LeDados.leInt();
								System.out.println();
								
								switch (op21) {
								
								case 1:
									
									do {
									
										System.out.println("-------------------Adicionar Dados--------------------");
										System.out.println();
										System.out.println("#1 -> Jogo");
										System.out.println("#2 -> Produto");
										System.out.println("#3 -> Diretor");
										System.out.println("#4 -> Produtora");
										System.out.println("#5 -> Empregado");
										System.out.println("#6 -> Cliente");
										System.out.println("#7 -> Fornecedor");
										System.out.println("#8 -> Sair");
										System.out.println();
										System.out.println("------------------------------------------------------");
										System.out.println(); 
										
										System.out.print("Escolha uma Opção - ");
										op211 = LeDados.leInt();
										System.out.println();
										
										switch (op211) {
										
											case 1:
												
												System.out.println("--------------------Adicionar Jogo--------------------");
												System.out.println();
												
												System.out.print("Nome do Jogo");
												String nomeJogo = LeDados.leString();
												System.out.println();
												
												System.out.print("Nome da Saga");
												String saga = LeDados.leString();
												System.out.println();
												
												Estilo estilo = null;
												String estiloN = "";
												do {
													
													System.out.print("Estilo de Jogo (escreva \"cancelar\" se quiser cancelar)");
													estiloN = LeDados.leString();
													
													estilo = l.srcEstilo(estiloN);
													
													if(estiloN.equals("cancelar")) {
														break;
													}
													
													if(estilo == null) {

														estilo = new Estilo(estiloN);
														l.addEstilo(estilo);
														System.out.println("Novo estilo de jogo criado com sucesso!");
														
													}
													
												} while(estilo == null);											
												System.out.println();
												
												System.out.print("Modelo de Jogo");
												String modelo = LeDados.leString();
												System.out.println();
												
												System.out.print("Duração média do Jogo (hh.mm)");
												float duracao = LeDados.leFloat();
												System.out.println();
												
												Produtora produtoraJogo = null;
												String nomeProdutora = "";
												do {
													
													System.out.print("Nome da Produtora do Jogo (escreva \"cancelar\" se quiser cancelar)");
													nomeProdutora = LeDados.leString();
													produtoraJogo = l.srcProdutora(nomeProdutora);
													System.out.println();
													
													if(nomeProdutora.equals("cancelar")) {
														break;
													}
													
												} while (produtoraJogo == null);
												
												Diretor diretorJogo = null;
												String nomeDiretor;
												do {
													
													System.out.print("Nome do Diretor do Jogo (escreva \"cancelar\" se quiser cancelar)");
													nomeDiretor = LeDados.leString();
													diretorJogo = l.srcDiretor(nomeDiretor);
													System.out.println();
													
													if(nomeDiretor.equals("cancelar")) {
														break;
													}
													
												} while (diretorJogo == null);
												
												System.out.print("Cópias existem em stock - ");
												int stock = LeDados.leInt();
												Stock s = new Stock(stock);
												System.out.println();
												
												System.out.print("Prateleira em exposição");
												String localizacao = LeDados.leString();
												System.out.println();
												
												System.out.print("Custo de compra - ");
												float cCompra = LeDados.leFloat();
												System.out.println();
												
												Fornecedor fornecedorJogo = null;
												String nomeFornecedor = "";
												do {
													
													System.out.print("Nome do Fornecedor do Jogo (escreva \"cancelar\" se quiser cancelar)");
													nomeFornecedor = LeDados.leString();
													fornecedorJogo = l.srcFornecedor(nomeFornecedor);
													System.out.println();
													
													if(nomeFornecedor.equals("cancelar")) {
														break;
													}
													
													
													
												} while (fornecedorJogo == null);

												System.out.print("Adicionar Observações ao Jogo? (s/n)");
												char rAddEJogo = LeDados.leChar();
												String extra = "";
												if((rAddEJogo == 's') || (rAddEJogo == 'S')) {
													extra = LeDados.leString();
												} 
												
												Jogo j = new Jogo(nomeJogo, saga, estiloN, modelo, duracao, nomeProdutora, nomeDiretor, s, localizacao, cCompra, nomeFornecedor);
												j.setExtra(extra);
												j.mostraJogo();
												
												System.out.println();
												
												l.addJogo(j);
												
												estilo.addJogo(j);
												produtoraJogo.addJogo(j);
												diretorJogo.addJogo(j);
												fornecedorJogo.addJogo(j);
												
												System.out.print("Novo Jogo adicionado com Sucesso!");
												System.out.println();
												
												break;
												
											case 2:
												
												System.out.println("-------------------Adicionar Produto-------------------");
												System.out.println();
												
												System.out.print("Nome do Produto");
												String nomeProduto = LeDados.leString();
												System.out.println();
												
												HashSet<Jogo> produtoJogos = new HashSet<Jogo>();
												System.out.println("Adicione Jogo(s)");
												char rAddMJogo = 's';
												do {
													
													System.out.print("Nome do Jogo");
													String nomeProdutoJogo = LeDados.leString();
													System.out.println();
													
													System.out.print("Saga do Jogo");
													String sagaProdutoJogo = LeDados.leString();
													System.out.println();
													
													System.out.print("Plataforma do Jogo");
													String plataformaProdutoJogo = LeDados.leString();
													System.out.println();
													
													Jogo jP = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
													
													if(jP != null) {
														
														produtoJogos.add(jP);	
														
														System.out.print("Adicionar mais jogos ao produto? (s/n)");
														rAddMJogo = LeDados.leChar();	
														
													}
													
																										
												} while((rAddMJogo == 's') || (rAddMJogo == 'S'));
												
												Produto pd = new Produto(nomeProduto);
												pd.setJogos(produtoJogos);
												pd.setCVenda(pd.custoVendaProduto(produtoJogos));
												pd.mostraProduto();
												
												l.addProduto(pd);
												System.out.println("Novo Produto adicionado com Sucesso!");
												System.out.println();
												
												break;
											
											case 3:
												
												System.out.println("-------------------Adicionar Diretor-------------------");
												System.out.println();
												
										        System.out.print("Nome do diretor");
										        String nomeDiretorD = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Email do diretor");
										        String emailDiretor = LeDados.leString();
										        System.out.println();
										        										        
										        System.out.print("Insira data de nascimento do diretor (aaaa-mm-dd)");
										        String nascimento = LeDados.leString();
										        System.out.println();
										                										        
										        System.out.print("Página web do diretor");
										        String paginaWebDiretor = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Morada do diretor");
										        String moradaDiretor = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Morada do clube de fãs do diretor");
										        String moradaFasDiretor = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Nome da produtora");
										        String nomeDiretorProdutora = LeDados.leString();
										        System.out.println();
										        
										        HashSet<Jogo> jogosDiretor = new HashSet<Jogo>();
												System.out.print("Quer Adicionar Jogo(s)? (s/n)");
												char rAJ = LeDados.leChar();
												if((rAJ == 's') || (rAJ == 'S')) {
													
													char rAddJogoD = 'n';
													do {
														
														System.out.print("Nome do Jogo");
														String nomeProdutoJogo = LeDados.leString();
														System.out.println();
														
														System.out.print("Saga do Jogo");
														String sagaProdutoJogo = LeDados.leString();
														System.out.println();
														
														System.out.print("Plataforma do Jogo");
														String plataformaProdutoJogo = LeDados.leString();
														System.out.println();
														
														Jogo jDiretor = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
														jogosDiretor.add(jDiretor);
														
														System.out.print("Adicionar mais jogos ao Diretor? (s/n)");
														rAddJogoD = LeDados.leChar();
																											
													} while((rAddJogoD == 's') || (rAddJogoD == 'S'));
					
												}
										        
										        Produtora produtora = null;
										        
										        if(l.srcProdutora(nomeDiretorProdutora) != null) {
										        	
										        	produtora = l.srcProdutora(nomeDiretorProdutora);
										        	
										        } else {
													
													System.out.println("---------------Necessário criar Produtora--------------");
													System.out.println();
											        
											        System.out.print("Email da produtora");
											        String emailProdutora = LeDados.leString();
											        emailProdutora = LeDados.leString();
											        System.out.println();
											        										        
											        System.out.print("Página web do produtora");
											        String paginaWebProdutora = LeDados.leString();
											        System.out.println();
											        
											        System.out.print("Morada da produtora");
											        String moradaProdutora = LeDados.leString();
											        System.out.println();
											        
											        System.out.print("Morada do clube de fãs do diretor");
											        String moradaFasProdutora = LeDados.leString();
											        System.out.println();
											        
											        HashSet<Jogo> jogosProdutora = new HashSet<Jogo>();
											        System.out.print("Quer Adicionar Jogo(s)? (s/n)");
													char rAJP = LeDados.leChar();
													if((rAJP == 's') || (rAJP == 'S')) {
														
														char rAddJogoP = 'n';
														do {
															
															System.out.print("Nome do Jogo");
															String nomeProdutoJogo = LeDados.leString();
															System.out.println();
															
															System.out.print("Saga do Jogo");
															String sagaProdutoJogo = LeDados.leString();
															System.out.println();
															
															System.out.print("Plataforma do Jogo");
															String plataformaProdutoJogo = LeDados.leString();
															System.out.println();
															
															Jogo jProdutora = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
															jogosProdutora.add(jProdutora);
															
															System.out.print("Adicionar mais jogos ao Diretor? (s/n)");
															rAddJogoP = LeDados.leChar();
															System.out.println();
																												
														} while((rAddJogoP == 's') || (rAddJogoP == 'S'));
													
													}
													
													produtora = new Produtora(nomeDiretorProdutora, emailProdutora, paginaWebProdutora, moradaProdutora, moradaFasProdutora);
													produtora.setJogos(jogosProdutora);
													produtora.mostraProdutora();
													
													l.addProdutora(produtora);
													System.out.print("Nova Produtora adicionada com Sucesso!");
													System.out.println();
											     											        
										        }
										        
										        
										        Diretor d = new Diretor(nomeDiretorD, emailDiretor, nascimento, paginaWebDiretor, moradaDiretor, moradaFasDiretor, produtora);
										        d.setJogos(jogosDiretor);
										        produtora.setDiretor(d);
										        d.mostraDiretor();
												
												l.addDiretor(d);
												System.out.print("Novo Diretor adicionado com Sucesso!");
												System.out.println();
												
												break;
												
											case 4:
												
												System.out.println("------------------Adicionar Produtora------------------");
												System.out.println();
												
										        System.out.print("Nome da produtora");
										        String nomeProdutoraP = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Email da produtora");
										        String emailProdutora = LeDados.leString();
										        System.out.println();
										        										        
										        System.out.print("Página web do diretor");
										        String paginaWebProdutora = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Morada da produtora");
										        String moradaProdutora = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Morada do clube de fãs do diretor");
										        String moradaFasProdutora = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Nome do Diretor");
										        String nomeProdutoraDiretor = LeDados.leString();
										        System.out.println();
										        
										        HashSet<Jogo> jogosProdutora = new HashSet<Jogo>();
												System.out.print("Adicionar Jogo(s) ? (s/n)");
												char rAddJogoP = LeDados.leChar();
												if((rAddJogoP == 's') || (rAddJogoP == 'S')) {
													do {
														
														System.out.print("Nome do Jogo");
														String nomeProdutoJogo = LeDados.leString();
														System.out.println();
														
														System.out.print("Saga do Jogo");
														String sagaProdutoJogo = LeDados.leString();
														System.out.println();
														
														System.out.print("Plataforma do Jogo");
														String plataformaProdutoJogo = LeDados.leString();
														System.out.println();
														
														Jogo jProdutora = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
														jogosProdutora.add(jProdutora);
														
														System.out.print("Adicionar mais jogos ao Diretor? (s/n)");
														rAddJogoP = LeDados.leChar();
														System.out.println();
																											
													} while((rAddJogoP == 's') || (rAddJogoP == 'S'));
												
												}
										        
										        Diretor diretor = null;
										        
										        if(l.srcDiretor(nomeProdutoraDiretor) != null) {
										        	
										        	diretor = l.srcDiretor(nomeProdutoraDiretor);
										        	
										        } else {
										        	
													System.out.println("-----------------Necessário criar Diretor----------------");
													System.out.println();
											        
											        System.out.print("Email do diretor");
											        String emailDiretorP = LeDados.leString();
											        emailDiretorP = LeDados.leString();
											        System.out.println();
											        										        
											        System.out.print("Insira data de nascimento do diretor (aaaa-mm-dd)");
											        String nascimentoP = LeDados.leString();
											        System.out.println();
											                										        
											        System.out.print("Página web do diretor");
											        String paginaWebDiretorP = LeDados.leString();
											        System.out.println();
											        
											        System.out.print("Morada do diretor");
											        String moradaDiretorP = LeDados.leString();
											        System.out.println();
											        
											        System.out.print("Morada do clube de fãs do diretor");
											        String moradaFasDiretorP = LeDados.leString();
											        System.out.println();
											        
											        HashSet<Jogo> jogosDiretorP = new HashSet<Jogo>();
													System.out.print("Quer Adicionar Jogo(s)? (s/n)");
													char rAJP = LeDados.leChar();
													if((rAJP == 's') || (rAJP == 'S')) {
														
														char rAddJogoD = 'n';
														do {
															
															System.out.print("Nome do Jogo");
															String nomeProdutoJogo = LeDados.leString();
															System.out.println();
															
															System.out.print("Saga do Jogo");
															String sagaProdutoJogo = LeDados.leString();
															System.out.println();
															
															System.out.print("Plataforma do Jogo");
															String plataformaProdutoJogo = LeDados.leString();
															System.out.println();
															
															Jogo jDiretor = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
															jogosDiretorP.add(jDiretor);
															
															System.out.print("Adicionar mais jogos ao Diretor? (s/n)");
															rAddJogoD = LeDados.leChar();
																												
														} while((rAddJogoD == 's') || (rAddJogoD == 'S'));
						
													}
													
													diretor = new Diretor(nomeProdutoraDiretor, emailDiretorP, nascimentoP, paginaWebDiretorP, moradaDiretorP, moradaFasDiretorP);
													diretor.setJogos(jogosProdutora);
													diretor.mostraDiretor();
													
													l.addDiretor(diretor);
													System.out.print("Nova Diretor adicionado com Sucesso!");
													System.out.println();
											     											        
										        }
										        
										        Produtora Prd = new Produtora(nomeProdutoraP, emailProdutora, paginaWebProdutora, moradaProdutora, moradaFasProdutora, diretor);
										        Prd.setJogos(jogosProdutora);
										        diretor.setProdutora(Prd);
										        Prd.mostraProdutora();
												
												l.addProdutora(Prd);
												System.out.print("Nova Produtora adicionada com Sucesso!");
												System.out.println();
												
												break;
												
											case 5:
												
												System.out.println("------------------Adicionar Empregado------------------");
												System.out.println();
												
										        System.out.print("Nome do Empregado");
										        String nomeEmpregado = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Numero do Empregado");
										        int numEmpregado = LeDados.leInt();
										        System.out.println();
										        
										        System.out.print("Morada do Empregado");
										        String moradaEmpregado = LeDados.leString();
										        System.out.println();
										        
										        Empregado emp = new Empregado(nomeEmpregado, numEmpregado, moradaEmpregado);
												emp.mostraEmpregado();
												
												l.addEmpregado(emp);
												System.out.print("Novo Empregado adicionado com Sucesso!");
												System.out.println();
										        
												break;
												
											case 6:
												
												System.out.println("-------------------Adicionar Cliente-------------------");
												System.out.println();
												
										        System.out.print("Nome do Cliente");
										        String nomeCliente = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Numero do Cliente");
										        int numCliente = LeDados.leInt();
										        System.out.println();
										        
										        System.out.print("Morada do Cliente");
										        String moradaCliente = LeDados.leString();
										        System.out.println();
										        
										        System.out.print("Password do Cliente");
										        String passwordCliente = LeDados.leString();
										        System.out.println();
										        
										        Cliente clt = new Cliente(nomeCliente, numCliente, moradaCliente, passwordCliente);
												clt.mostraCliente();
												
												l.addCliente(clt);
												System.out.print("Novo Cliente adicionado com Sucesso!");
												System.out.println();
												
												break;										
											
											case 7:
												
												System.out.println("-------------------Adicionar Fornecedor-------------------");
												System.out.println();
												
												System.out.print("Nome do Fornecedor");
												String nomeFornecedorF = LeDados.leString();
												System.out.println();
																								
												Fornecedor f = new Fornecedor(nomeFornecedorF);
												f.mostraFornecedor();
												
												l.addFornecedor(f);
												System.out.println("Novo Fornecedor adicionado com Sucesso!");
												System.out.println();
												
												break;
												
											case 8:
												System.out.println("A voltar ao menu de gestão de dados..");
												break;
												
											default:
								                System.out.println("Opção inválida. Tente novamente.");
								                System.out.println(); 
										}
									
									} while(op211 != 8);
									
									break;
										
								case 2:
									
									do {
										
										System.out.println("--------------------Alterar Dados---------------------");
										System.out.println();
										System.out.println("#1 -> Jogo");
										System.out.println("#2 -> Produto");
										System.out.println("#3 -> Diretor");
										System.out.println("#4 -> Produtora");
										System.out.println("#5 -> Cliente");
										System.out.println("#6 -> Empregado");
										System.out.println("#7 -> Fornecedor");
										System.out.println("#8 -> Sair");
										System.out.println();
										System.out.println("------------------------------------------------------");
										System.out.println(); 
										
										System.out.print("Escolha uma Opção - ");
										op212 = LeDados.leInt();
										System.out.println();
										
										switch (op212) {
										
											case 1:
												
												System.out.print("Nome do Jogo");
												String nomeJogo = LeDados.leString();
												System.out.println();
												
												System.out.print("Saga do Jogo");
												String sagaJogo = LeDados.leString();
												System.out.println();
												
												System.out.print("Plataforma do Jogo");
												String plataformaJogo = LeDados.leString();
												System.out.println();
												
												Jogo j = l.srcJogoN(nomeJogo, sagaJogo, plataformaJogo);
												
												if (j == null) {
													System.out.print("Jogo não encontrado");
													break;
												}
												
												int op2121;
												
												do {
													
													j.mostraJogo();
													
													System.out.println("------------Alterar Dados de " + j.getNome() + "---------------");
													System.out.println();
													System.out.println("#1  -> Nome");
													System.out.println("#2  -> Saga");
													System.out.println("#3  -> Estilo");
													System.out.println("#4  -> Plataforma");
													System.out.println("#5  -> Duração");
													System.out.println("#6  -> Produtora");
													System.out.println("#7  -> Diretor");
													System.out.println("#8  -> Quantidade em stock");
													System.out.println("#9  -> Localização");
													System.out.println("#10 -> Custo de compra");
													System.out.println("#10 -> Fornecedor");
													System.out.println("#11 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2121 = LeDados.leInt();
													System.out.println();
													
													switch (op2121) {
													
														case 1:
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															j.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
														
														case 2:
															System.out.print("Nova Saga");
															String saga = LeDados.leString();
															j.setSaga(saga);
															System.out.println();
															System.out.println("Saga atualizada!");
															
															break;

														case 3:
															System.out.print("Novo Estilo");
															String estilo = LeDados.leString();
															
															Estilo jE = l.srcEstilo(j.getEstilo());
															l.remJogoEstilo(jE, j);
															
															Estilo e = l.srcEstilo(estilo);
															
															if(e != null) {
																
																String eNome = e.getNome();
																j.setEstilo(eNome);
																System.out.println();
																
																System.out.println("Estilo atualizado!");
																
															} else {
																System.out.println("Estilo não encontrado!");
															}
															
															break;
															
														case 4:
															System.out.print("Nova Plataforma");
															String plataforma = LeDados.leString();
															j.setPlataforma(plataforma);
															System.out.println();
															System.out.println("Plataforma atualizada!");
															
															break;
															
														case 5:
															System.out.print("Nova Duração");
															float duracao = LeDados.leFloat();
															j.setDuracao(duracao);
															System.out.println();
															System.out.println("Duração atualizada!");
															
															break;
															
														case 6:
															System.out.print("Nova Produtora");
															String produtora = LeDados.leString();
															
															Produtora jP = l.srcProdutora(j.getProdutora());
															l.remJogoProdutora(jP, j);
															
															Produtora p = l.srcProdutora(produtora);
															
															if(p != null) {
															
																String pNome = p.getNome();
																j.setProdutora(pNome);
																System.out.println();
																
																System.out.println("Produtora atualizada!");
															
															} else {
																System.out.println("Produtora não encontrada!");
															}
															
															break;
															
														case 7:
															System.out.print("Novo Diretor");
															String diretor = LeDados.leString();
															
															Diretor jD = l.srcDiretor(j.getDiretor());
															l.remJogoDiretor(jD, j);
															
															Diretor d = l.srcDiretor(diretor);
															
															if(d != null) {
															
																String dNome = d.getNome();
																j.setDiretor(dNome);
																System.out.println();
																
																System.out.println("Diretor atualizada!");
																
															
															} else {
																System.out.println("Diretor não encontrado!");
															}
															
															break;
															
														case 8:
															System.out.print("Nova quantidade em Stock");
															int quantidade = LeDados.leInt();
															
															j.getStock().setQuantidade(quantidade);
																				
															System.out.println();
															System.out.println("Quantidade em Stock atualizada!");
															
															break;
															
														case 9:
															System.out.print("Nova Localização");
															String localizacao = LeDados.leString();
															j.setLocalizacao(localizacao);
															System.out.println();
															System.out.println("Localização atualizada!");
															
															break;
															
														case 10:
															System.out.print("Novo custo de Compra");
															float cCusto = LeDados.leFloat();
															j.setCustoCompra(cCusto);
															System.out.println();
															System.out.println("Custo de Compra atualizado!");
															
															break;
															
														case 11:
															System.out.print("Novo Fornecedor");
															String fornecedor = LeDados.leString();
															
															Fornecedor jF = l.srcFornecedor(j.getFornecedor());
															l.remJogoFornecedora(jF, j);
															
															Fornecedor f = l.srcFornecedor(fornecedor);
															
															if(f != null) {
															
																String fNome = f.getNome();
																j.setFornecedor(fNome);
																System.out.println();
																
																System.out.println("Fornecedor atualizada!");
																
															
															} else {
																System.out.println("Fornecedor não encontrado!");
															}
															
															break;
															
														case 12:
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
													
												} while(op2121 != 11);
												
												System.out.println("");
												
												break;

											case 2:

												System.out.print("Nome do Produto");
												String nomePro = LeDados.leString();
												System.out.println();
												
												Produto Pro = l.srcProduto(nomePro);
												
												if (Pro == null) {
													System.out.print("Produto não encontrado");
													break;
												}
												
												int op2122;
												
												do {
													
													Pro.mostraProduto();
													
													System.out.println("------------Alterar Dados de " + Pro.getNome() + "---------------");
													System.out.println();
													System.out.println("#1 -> Nome");
													System.out.println("#2 -> Jogos");
													System.out.println("#3 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2122 = LeDados.leInt();
													System.out.println();
													
													switch (op2122) {
													
														case 1:
															
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															Pro.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
															
														case 2:
															
															HashSet<Jogo> jogosPro = new HashSet<Jogo>();
															System.out.print("Adicionar os novos jogos ao Produto");
															char rAddJogoD = 'n';
															
																do {
																	
																	System.out.print("Nome do Jogo");
																	String nomeProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	System.out.print("Saga do Jogo");
																	String sagaProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	System.out.print("Plataforma do Jogo");
																	String plataformaProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	Jogo jPro = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
																	jogosPro.add(jPro);
																	
																	System.out.print("Adicionar mais jogos ao Produto? (s/n)");
																	rAddJogoD = LeDados.leChar();
																														
																} while((rAddJogoD == 's') || (rAddJogoD == 'S'));
								
															Pro.setJogos(jogosPro);
															
															break;
															
														case 3: 
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
												} while (op2122 != 3);
												
												break;

											case 3:

												System.out.print("Nome do Diretor");
												String nomeDir = LeDados.leString();
												System.out.println();
												
												Diretor Dir = l.srcDiretor(nomeDir);
												
												if (Dir == null) {
													System.out.print("Diretor não encontrado");
													break;
												}
												
												int op2123;
												
												do {
													
													Dir.mostraDiretor();
													
													System.out.println("------------Alterar Dados de " + Dir.getNome() + "---------------");
													System.out.println();
													System.out.println("#1  -> Nome");
													System.out.println("#2  -> Email");
													System.out.println("#3  -> Nascimento");
													System.out.println("#4  -> Pagina Web");
													System.out.println("#5  -> Morada");
													System.out.println("#6  -> Morada de clube de Fas");
													System.out.println("#7  -> Produtora");
													System.out.println("#8  -> Extra");
													System.out.println("#9  -> Jogos");
													System.out.println("#10 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2123 = LeDados.leInt();
													System.out.println();
													
													switch (op2123) {
													
														case 1:
															
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															Dir.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
															
														case 2:
															
															System.out.print("Novo Email");
															String mail = LeDados.leString();
															Dir.setEmail(mail);
															System.out.println();
															System.out.println("Email atualizado!");
															
															break;
															
														case 3:
															
															System.out.print("Novo data de Nascimento");
															String ddn = LeDados.leString();
															Dir.setNascimento(ddn);
															System.out.println();
															System.out.println("Data de Nascimento atualizada!");
															
															break;
															
														case 4:
															
															System.out.print("Nova Pagina Web");
															String pw = LeDados.leString();
															Dir.setPaginaWeb(pw);
															System.out.println();
															System.out.println("Data de Nascimento atualizada!");
															
															break;
															
														case 5:
															
															System.out.print("Nova Morada");
															String Morada = LeDados.leString();
															Dir.setMorada(Morada);
															System.out.println();
															System.out.println("Morada atualizada!");
															
															break;
															
														case 6:
															
															System.out.print("Nova Morada de clube de Fas");
															String MoradaFas = LeDados.leString();
															Dir.setMoradaFas(MoradaFas);
															System.out.println();
															System.out.println("Morada de clube de Fas atualizada!");
															
															break;
															
														case 7:
															
															System.out.print("Nova Produtora");
															String Produtora = LeDados.leString();
															
															Produtora DirProdutora = l.srcProdutora(Produtora);
															
															if(DirProdutora != null) {
																
																Dir.setProdutora(DirProdutora);
																System.out.println();
																System.out.println("Produtora atualizada!");
																
															} else {
																System.out.println("Produtora não encontrada");
																System.out.println();
															}
															
															break;
															
														case 8:
															
															System.out.print("Nova informação adicional");
															String EXTRA = LeDados.leString();
															Dir.setExtra(EXTRA);
															System.out.println();
															System.out.println("Informação adicional atualizada!");
															
															break;
															
														case 9:
															
															HashSet<Jogo> jogosDir = new HashSet<Jogo>();
															System.out.print("Adicionar os novos jogos ao Produto");
															char rAddJogoD = 'n';
															
																do {
																	
																	System.out.print("Nome do Jogo");
																	String nomeProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	System.out.print("Saga do Jogo");
																	String sagaProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	System.out.print("Plataforma do Jogo");
																	String plataformaProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	Jogo jPro = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
																	jogosDir.add(jPro);
																	
																	System.out.print("Adicionar mais jogos ao Produto? (s/n)");
																	rAddJogoD = LeDados.leChar();
																														
																} while((rAddJogoD == 's') || (rAddJogoD == 'S'));
								
															Dir.setJogos(jogosDir);
															
															break;
															
														case 10: 
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
												} while (op2123 != 10);
												
												break;

											case 4:

												System.out.print("Nome da Produtora");
												String nomePRD = LeDados.leString();
												System.out.println();
												
												Produtora prd = l.srcProdutora(nomePRD);
												
												if (prd == null) {
													System.out.print("Produtora não encontrada");
													break;
												}
												
												int op2124;
												
												do {
													
													prd.mostraProdutora();
													
													System.out.println("------------Alterar Dados de " + prd.getNome() + "---------------");
													System.out.println();
													System.out.println("#1 -> Nome");
													System.out.println("#2 -> Email");
													System.out.println("#3 -> Pagina Web");
													System.out.println("#4 -> Morada");
													System.out.println("#5 -> Morada de clube de Fas");
													System.out.println("#6 -> Diretor");
													System.out.println("#7 -> Extra");
													System.out.println("#8 -> Jogos");
													System.out.println("#9 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2124 = LeDados.leInt();
													System.out.println();
													
													switch (op2124) {
													
														case 1:
															
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															prd.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
															
														case 2:
															
															System.out.print("Novo Email");
															String mail = LeDados.leString();
															prd.setEmail(mail);
															System.out.println();
															System.out.println("Email atualizado!");
															
															break;
															
														case 3:
															
															System.out.print("Nova Pagina Web");
															String pw = LeDados.leString();
															prd.setPaginaWeb(pw);
															System.out.println();
															System.out.println("Data de Nascimento atualizada!");
															
															break;
															
														case 4:
															
															System.out.print("Nova Morada");
															String Morada = LeDados.leString();
															prd.setMorada(Morada);
															System.out.println();
															System.out.println("Morada atualizada!");
															
															break;
															
														case 5:
															
															System.out.print("Nova Morada de clube de Fas");
															String MoradaFas = LeDados.leString();
															prd.setMoradaFas(MoradaFas);
															System.out.println();
															System.out.println("Morada de clube de Fas atualizada!");
															
															break;
															
														case 6:
															
															System.out.print("Novo Diretor");
															String dir = LeDados.leString();
															
															Diretor PrdDiretor = l.srcDiretor(dir);
															
															if(PrdDiretor != null) {
																
																prd.setDiretor(PrdDiretor);
																System.out.println();
																System.out.println("Diretor atualizad0!");
																
															} else {
																System.out.println("Diretor não encontrado");
																System.out.println();
															}
															
															break;
															
														case 7:
															
															System.out.print("Nova informação adicional");
															String EXTRA = LeDados.leString();
															prd.setExtra(EXTRA);
															System.out.println();
															System.out.println("Informação adicional atualizada!");
															
															break;
															
														case 8:
															
															HashSet<Jogo> jogosPrd = new HashSet<Jogo>();
															System.out.print("Adicionar os novos jogos ao Produto");
															char rAddJogoD = 'n';
															
																do {
																	
																	System.out.print("Nome do Jogo");
																	String nomeProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	System.out.print("Saga do Jogo");
																	String sagaProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	System.out.print("Plataforma do Jogo");
																	String plataformaProdutoJogo = LeDados.leString();
																	System.out.println();
																	
																	Jogo jPro = l.srcJogoN(nomeProdutoJogo, sagaProdutoJogo, plataformaProdutoJogo);
																	jogosPrd.add(jPro);
																	
																	System.out.print("Adicionar mais jogos ao Produto? (s/n)");
																	rAddJogoD = LeDados.leChar();
																														
																} while((rAddJogoD == 's') || (rAddJogoD == 'S'));
								
																prd.setJogos(jogosPrd);
															
															break;
															
														case 9: 
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
												} while (op2124 != 9);
												
												break;

											case 5:

												System.out.print("Nome do Cliente");
												String nomeCl = LeDados.leString();
												System.out.println();
												
												Cliente cl = l.srcCliente(nomeCl);
												
												if (cl == null) {
													System.out.print("Cliente não encontrado");
													break;
												}
												
												int op2125;
												
												do {
													
													cl.mostraCliente();
													
													System.out.println("------------Alterar Dados de " + cl.getNome() + "---------------");
													System.out.println();
													System.out.println("#1 -> Nome");
													System.out.println("#2 -> Numero");
													System.out.println("#3 -> Morada");
													System.out.println("#4 -> Password");
													System.out.println("#5 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2125 = LeDados.leInt();
													System.out.println();
													
													switch (op2125) {
													
														case 1:
															
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															cl.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
															
														case 2:
															
															System.out.print("Novo Numero");
															int num = LeDados.leInt();
															cl.setNum(num);
															System.out.println();
															System.out.println("Numero atualizado!");
															
															break;
															
														case 3:
															
															System.out.print("Nova Morada");
															String mor = LeDados.leString();
															cl.setMorada(mor);
															System.out.println();
															System.out.println("Morada atualizada!");
															
															break;
															
														case 4:
															
															System.out.print("Nova Password");
															String morF = LeDados.leString();
															cl.setPassword(morF);
															System.out.println();
															System.out.println("Password atualizada!");
															
															break;
															
														case 5: 
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
												} while (op2125 != 5);
												
												break;

											case 6:

												System.out.print("Nome do Empregado");
												String nomeEmp = LeDados.leString();
												System.out.println();
												
												Empregado emp = l.srcEmpregado(nomeEmp);
												
												if (emp == null) {
													System.out.print("Empregado não encontrado");
													break;
												}
												
												int op2126;
												
												do {
													
													emp.mostraEmpregado();
													
													System.out.println("------------Alterar Dados de " + emp.getNome() + "---------------");
													System.out.println();
													System.out.println("#1 -> Nome");
													System.out.println("#2 -> Numero");
													System.out.println("#3 -> Morada");
													System.out.println("#4 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2126 = LeDados.leInt();
													System.out.println();
													
													switch (op2126) {
													
														case 1:
															
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															emp.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
															
														case 2:
															
															System.out.print("Novo Numero");
															int num = LeDados.leInt();
															emp.setNum(num);
															System.out.println();
															System.out.println("Numero atualizado!");
															
															break;
															
														case 3:
															
															System.out.print("Nova Morada");
															String mor = LeDados.leString();
															emp.setMorada(mor);
															System.out.println();
															System.out.println("Morada atualizada!");
															
															break;
															
														case 4: 
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
												} while (op2126 != 4);
												
												break;
												
											case 7:

												System.out.print("Nome do Fornecedor");
												String nomeFor = LeDados.leString();
												System.out.println();
												
												Fornecedor fr = l.srcFornecedor(nomeFor);
												
												if (fr == null) {
													System.out.print("Fornecedor não encontrado");
													break;
												}
												
												int op2127;
												
												do {
													
													fr.mostraFornecedor();
													
													System.out.println("------------Alterar Dados de " + fr.getNome() + "---------------");
													System.out.println();
													System.out.println("#1 -> Nome");
													System.out.println("#2 -> Numero");
													System.out.println("#3 -> Morada");
													System.out.println("#4 -> Sair");
													System.out.println();
													System.out.println("------------------------------------------------------");
													System.out.println(); 
													
													System.out.print("Escolha uma Opção - ");
													op2127 = LeDados.leInt();
													System.out.println();
													
													switch (op2127) {
													
														case 1:
															
															System.out.print("Novo Nome");
															String nome = LeDados.leString();
															
															
															
															fr.setNome(nome);
															System.out.println();
															System.out.println("Nome atualizado!");
															
															break;
															
														case 2:
															System.out.println("A voltar ao menu de gestão de dados..");
															break;
															
														default:
											                System.out.println("Opção inválida. Tente novamente.");
											                System.out.println(); 
													
													}
													
												} while (op2127 != 2);
												
												break;
												
											case 8:
												System.out.println("A voltar ao menu de gestão de dados..");
												break;
												
											default:
								                System.out.println("Opção inválida. Tente novamente.");
								                System.out.println(); 
										
										}
										
									} while (op212 != 8);
									
									break;
									
								case 3:
										
									do {
												
										System.out.println("--------------------Remover Dados---------------------");
										System.out.println();
										System.out.println("#1 -> Jogo");
										System.out.println("#2 -> Produto");
										System.out.println("#3 -> Diretor");
										System.out.println("#4 -> Produtora");
										System.out.println("#5 -> Cliente");
										System.out.println("#6 -> Empregado");
										System.out.println("#7 -> Fornecedor");
										System.out.println("#8 -> Sair");
										System.out.println();
										System.out.println("------------------------------------------------------");
										System.out.println(); 
												
										System.out.print("Escolha uma Opção - ");
										op212 = LeDados.leInt();
										System.out.println();
												
										switch (op212) {
												
										case 1:
													
											System.out.println("---------------------Remover Jogo---------------------");
											System.out.println();
													
											System.out.print("Nome do Jogo");
											String nomeJogo = LeDados.leString();
											System.out.println();
											
											System.out.print("Nome da Saga");
											String saga = LeDados.leString();
											System.out.println();
											
											System.out.print("Modelo de Jogo");
											String modelo = LeDados.leString();
											System.out.println();
											
											Jogo j = l.srcJogoN(nomeJogo, saga, modelo);
											j.mostraJogo();
											
											Estilo Er = l.srcEstilo(j.getEstilo());
											Produtora Pr = l.srcProdutora(j.getProdutora());
											Diretor Dr = l.srcDiretor(j.getDiretor());
											Fornecedor Fr = l.srcFornecedor(j.getFornecedor());
																						
											if(l.remJogo(nomeJogo, saga, modelo) == true ) {
												
												System.out.println("Jogo removido com sucesso!");
												l.remJogoEstilo(Er, j);
												l.remJogoProdutora(Pr, j);
												l.remJogoDiretor(Dr, j);
												l.remJogoFornecedora(Fr, j);
												
											} else {
												System.out.println("Operação falhou.. Jogo não encontrado..");
											}
																					
											break;
										
										case 2:
											
											System.out.println("--------------------Remover Produto--------------------");
											System.out.println();
													
											System.out.print("Nome do Jogo");
											String nomeProduto = LeDados.leString();
											System.out.println();
																						
											Produto p = l.srcProduto(nomeProduto);
											p.mostraProduto();

											if(l.remProduto(nomeProduto) == true ) {
												System.out.println("Produto removido com sucesso!");
											} else {
												System.out.println("Operação falhou.. Produto não encontrado..");
											}
											
											break;

										case 3:

											System.out.println("--------------------Remover Diretor--------------------");
											System.out.println();
													
											System.out.print("Nome do Diretor");
											String nomeDiretor = LeDados.leString();
											System.out.println();
																						
											Diretor d = l.srcDiretor(nomeDiretor);
											d.mostraDiretor();
											
											if(l.remDiretor(nomeDiretor) == true ) {
												System.out.println("Diretor removido com sucesso!");
											} else {
												System.out.println("Operação falhou.. Diretor não encontrado..");
											}
											
											break;

										case 4:

											System.out.println("-------------------Remover Produtora-------------------");
											System.out.println();
													
											System.out.print("Nome da Produtora");
											String nomeProdutora = LeDados.leString();
											System.out.println();
																						
											Produtora prd = l.srcProdutora(nomeProdutora);
											prd.mostraProdutora();
											
											if(l.remProdutora(nomeProdutora) == true ) {
												System.out.println("Produtora removida com sucesso!");
											} else {
												System.out.println("Operação falhou.. Produtora não encontrada..");
											}
											
											break;

										case 5:

											System.out.println("------------------Remover Cliente------------------");
											System.out.println();
													
											System.out.print("Nome de Cliente");
											String nCliente = LeDados.leString();
											System.out.println();
																						
											Cliente cl = l.srcCliente(nCliente);
											cl.mostraCliente();
											
											if(l.remCliente(nCliente) == true ) {
												System.out.println("Cliente removido com sucesso!");
											} else {
												System.out.println("Operação falhou.. Cliente não encontrado..");
											}
											
											break;

										case 6:

											System.out.println("-----------------Remover Empregado-----------------");
											System.out.println();
													
											System.out.print("Nome do Empregado");
											String nomeEmpregado = LeDados.leString();
											System.out.println();
																						
											Empregado emp = l.srcEmpregado(nomeEmpregado);
											emp.mostraEmpregado();
											
											if(l.remEmpregado(nomeEmpregado) == true ) {
												System.out.println("Empregado removido com sucesso!");
											} else {
												System.out.println("Operação falhou.. Empregado não encontrado..");
											}
											
											break;

										case 7:
											
											System.out.println("-----------------Remover Fornecedor------------------");
											System.out.println();
											
											System.out.print("Nome do Fornecedor");
											String nomeFornecedor = LeDados.leString();
											System.out.println();
																							
											Fornecedor f = l.srcFornecedor(nomeFornecedor);
											f.mostraFornecedor();
											
											l.addFornecedor(f);
											System.out.println("Novo Fornecedor adicionado com Sucesso!");
											System.out.println();
											
											if(l.remFornecedor(nomeFornecedor) == true ) {
												System.out.println("Fornecedor removido com sucesso!");
											} else {
												System.out.println("Operação falhou.. Fornecedor não encontrado..");
											}
											
											break;
											
										case 8:
											System.out.println("A voltar ao menu de gestão de dados..");
											break;
																						
										default:
											System.out.println("Opção inválida. Tente novamente.");
							                System.out.println(); 
												
										}  
											
									} while(op212 != 8);
										
									break;
										
								case 4:
									System.out.println("A voltar ao menu de administrador..");
									break;
										
								default:
									System.out.println("Opção inválida. Tente novamente.");
									System.out.println();
								}
							
							} while(op21 != 4);
							
							break;
	
						case 2:
							
							do {
								
								System.out.println("------------------Registo de Vendas-------------------");
								System.out.println();
								System.out.println("#1 -> Registar Venda");
								System.out.println("#2 -> Remover Venda");
								System.out.println("#3 -> Ver Registo de Vendas");
								System.out.println("#4 -> Sair");
								System.out.println();
								System.out.println("------------------------------------------------------");
								System.out.println(); 
								
								System.out.print("Escolha uma Opção - ");
								op22 = LeDados.leInt();
								System.out.println();
								
								switch (op22) {
								
								case 1:
									
									System.out.println("------------------Registar Venda-------------------");
									System.out.println();
									String nC = "";
									char rAddV = 's';
									HashSet<Produto> P = new HashSet<>();
									
									System.out.print("Cliente Especial? (s/n)");
									char cE = LeDados.leChar();
									System.out.println();
									
									Cliente C = null;
									if((cE == 's') || (cE == 'S')) {
										
										System.out.print("Nome do Cliente");
										nC = LeDados.leString();
										nC = LeDados.leString();
										System.out.println();
										
										C = l.srcCliente(nC);
										
									}
									
									System.out.println();
									
									Empregado e = null;
									do {
									
										System.out.print("Nome do Empregado");
										String nomeE = LeDados.leString();
										nomeE = LeDados.leString();
										System.out.println();
									
										e = l.srcEmpregado(nomeE);
									
									} while(e == null);
									
									System.out.print("Data da venda (dd:mm:aaaa)");
									String horasV = LeDados.leString();
									System.out.println();
									
									do {
									
										System.out.print("Nome do Produto");
										String nomeProduto = LeDados.leString();
										System.out.println();
										
										System.out.print("Quantas unidades");
										int quantidadeProduto = LeDados.leInt();
										System.out.println();
										
										Produto p = l.srcProduto(nomeProduto);
										
										if(p != null) {
										
											l.jogoSrc(p);
											
											for(Jogo j : p.getJogos()) {
												
												if(j.getPesquisado() == true) {
													
													l.addJogoMPR(j, quantidadeProduto);
													
												}
												
												if(j.getPromocao() == true) {
													
													l.addJogoMP(j, quantidadeProduto);
													
												}
												
											}
																					
											for(int i = 0; i < quantidadeProduto; i++) {
											
												P.add(p);
											
											}
											
											System.out.print("Adicionar mais produtos? (s/n)");
											rAddV = LeDados.leChar();
										
										} else {
											System.out.print("Produto não encontrado.. Adicione um Produto:");
										}
										
										
																			
									} while((rAddV == 's') || (rAddV == 'S'));
																		
									for(Produto a : P) {
										
										if(C != null) { 
											C.addProduto(a);
										}
										
										for(Jogo j : a.getJogos()) {
											
											Fornecedor f = l.srcFornecedor(j.getFornecedor());
											f.setVendas(f.getVendas() + 1);
											
											j.getStock().setQuantidade(j.getStock().getQuantidade() - 1);
											j.getStock().setVendas(j.getStock().getVendas() + 1);
											
										}
																			
									}
									
									if(C != null) {
										nC = "N/A";
									}
									
									Venda v = new Venda(nC,e ,horasV, P);
									
									if(C != null) {
										v.setCliente(C.getNome());
									}
									
									l.addVenda(v);
									
									System.out.println("Venda Registada com sucesso!");
									System.out.println();
																										
									break;
									
								case 2:
									
									System.out.println("------------------Remover Venda-------------------");
									
									System.out.print("Nome do Cliente");
									String ce = LeDados.leString();
									System.out.println();
									HashSet<Produto> Ps  = new HashSet<>();
									char rrV = 'n';
									
									do {
										
										System.out.print("Nome do Produto");
										String pr = LeDados.leString();
										
										Produto p = l.srcProduto(pr);
										Ps.add(p);
										
										System.out.print("Adicionar mais Produtos? (s/n)");
										rrV = LeDados.leChar();
										
									} while((rrV == 's') || (rrV == 'S'));
									
									if (l.remVenda(ce, Ps) == true) {
										System.out.println("Venda removida com sucesso!");
									} else {
										System.out.println("Problema ao remover a venda..");
									}
									
									break;
									
								case 3:

									System.out.println("-----------------Lista de Vendas------------------");
									
									l.lisVenda();
									
									break;
									
								case 4:
									System.out.println("A voltar ao menu de administrador..");
									break;
										
								default:
									System.out.println("Opção inválida. Tente novamente.");
									System.out.println();
									
								}
							} while(op22 != 4);
							
							break;
							
						case 3:
							
							do {
						    	
								System.out.println("---------------------Promoções-----------------------");
								System.out.println();
								System.out.println("#1 -> Adicionar Promoção");
								System.out.println("#2 -> remover Promoção");
								System.out.println("#3 -> Sair");
								System.out.println();
								System.out.println("------------------------------------------------------");
								System.out.println();
								
								System.out.print("Escolha uma Opção - ");
								op24 = LeDados.leInt();
								System.out.println();
								
								switch (op24) {
									
								case 1:
									
									do {
								    	
										System.out.println("------------------Adicionar Promoção------------------");
										System.out.println();
										System.out.println("#1 -> Todos os Produtos");
										System.out.println("#2 -> Nome de Produto");
										System.out.println("#3 -> Estilo de Jogo");
										System.out.println("#4 -> Diretor");
										System.out.println("#5 -> Produtora");
										System.out.println("#5 -> Fornecedor");
										System.out.println("#7 -> Sair");
										System.out.println();
										System.out.println("------------------------------------------------------");
										System.out.println();
										
										System.out.print("Escolha uma Opção - ");
										op241 = LeDados.leInt();
										System.out.println();
										
										switch (op241) {
										
										case 1:
											
											System.out.println("----------Adicionar Promoção em todos os Jogos-----------");
											System.out.println();
											
											System.out.println("Percentagem de promoção de 0 a 100");
											float f = (100 - LeDados.leFloat()) / 100;
											System.out.println();
											
											HashSet<Produto> all = l.allProduto();
											
											for(Produto a : all) {
												
												for(Jogo j : a.getJogos()) {
													
													j.setCustoVenda(1+f);
													j.setPromocao(true);
													
												}
												
											}
											
											System.out.println("Promoção adicionada com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 2:
											
											System.out.println("----------Adicionar Promoção em Jogo-----------");
											System.out.println();
											
											System.out.println("Percentagem de promoção de 0 a 100");
											float fJ = (100 - LeDados.leFloat()) / 100;
											System.out.println();
											
											System.out.println("Nome do Produto");
											String nomeP = LeDados.leString();
											System.out.println();
											
											Produto P = l.srcProduto(nomeP);
										
											for(Jogo j : P.getJogos()) {
												j.setCustoVenda(1+fJ);
											}

											System.out.println("Promoção adicionada com sucesso!");								
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 3:

											System.out.println("--------------Adicionar Promoção em Estilo--------------");
											System.out.println();
											
											System.out.println("Percentagem de promoção de 0 a 100");
											float fE = (100 - LeDados.leFloat()) / 100;
											System.out.println();

											System.out.println("Nome do Produto");
											String nomeE = LeDados.leString();
											System.out.println();
											
											Estilo e = l.srcEstilo(nomeE);
											
											for(Jogo a : e.getJogos()) {
																																				
												a.setCustoVenda(1 + fE);
												a.setPromocao(true);
																								
											}
											
											System.out.println("Promoção adicionada com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 4:
											
											System.out.println("--------------Adicionar Promoção em Diretor--------------");
											System.out.println();
											
											System.out.println("Percentagem de promoção de 0 a 100");
											float fD = (100 - LeDados.leFloat()) / 100;
											System.out.println();

											System.out.println("Nome do Diretor");
											String nomeD = LeDados.leString();
											System.out.println();
											
											Diretor d = l.srcDiretor(nomeD);
											
											for(Jogo a : d.getJogos()) {
																																				
												a.setCustoVenda(1 + fD);
												a.setPromocao(true);
																								
											}
											
											System.out.println("Promoção adicionada com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 5:
											
											System.out.println("-------------Adicionar Promoção em Produtora--------------");
											System.out.println();
											
											System.out.println("Percentagem de promoção de 0 a 100");
											float fP = (100 - LeDados.leFloat()) / 100;
											System.out.println();

											System.out.println("Nome da Produtora");
											String nomePr = LeDados.leString();
											System.out.println();
											
											Produtora p = l.srcProdutora(nomePr);
											
											for(Jogo a : p.getJogos()) {
																																				
												a.setCustoVenda(1 + fP);
												a.setPromocao(true);
																								
											}
											
											System.out.println("Promoção adicionada com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 6:
											
											System.out.println("-------------Adicionar Promoção em Fornecedor--------------");
											System.out.println();
											
											System.out.println("Percentagem de promoção de 0 a 100");
											float fF = (100 - LeDados.leFloat()) / 100;
											System.out.println();

											System.out.println("Nome da Produtora");
											String nomeF = LeDados.leString();
											System.out.println();
											
											Fornecedor F = l.srcFornecedor(nomeF);
											
											for(Jogo a : F.getJogos()) {
																																				
												a.setCustoVenda(1 + fF);
												a.setPromocao(true);
																								
											}
											
											System.out.println("Promoção adicionada com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 7:
											System.out.println("A voltar ao menu de promoções..");
											break;
												
										default:
											System.out.println("Opção inválida. Tente novamente.");
											System.out.println();
											
										
										}
										
									} while(op241 != 7);
									
									break;
									
								case 2:
									
									do {
								    	
										System.out.println("------------------Remover Promoção------------------");
										System.out.println();
										System.out.println("#1 -> Todos os Produtos");
										System.out.println("#2 -> Nome de Produto");
										System.out.println("#3 -> Estilo de Jogo");
										System.out.println("#4 -> Diretor");
										System.out.println("#5 -> Produtora");
										System.out.println("#5 -> Fornecedor");
										System.out.println("#7 -> Sair");
										System.out.println();
										System.out.println("------------------------------------------------------");
										System.out.println();
										
										System.out.print("Escolha uma Opção - ");
										op241 = LeDados.leInt();
										System.out.println();
										
										switch (op241) {
										
										case 1:
											
											System.out.println("----------Remover Promoção em todos os Jogos-----------");
											System.out.println();
											
											HashSet<Produto> all = l.allProduto();
											
											for(Produto a : all) {
												
												for(Jogo j : a.getJogos()) {
													
													j.setCustoVenda(j.getCustoCompra() *2);
													j.setPromocao(false);
													
												}
												
											}
											
											System.out.println("Promoção removida com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 2:
											
											System.out.println("----------Remover Promoção em Jogo-----------");
											System.out.println();
											
											System.out.println("Nome do Produto");
											String nomeP = LeDados.leString();
											System.out.println();
											
											Produto P = l.srcProduto(nomeP);
										
											for(Jogo j : P.getJogos()) {
												j.setCustoVenda(j.getCustoCompra() *2);
												j.setPromocao(false);
												
											}

											System.out.println("Promoção Removido com sucesso!");								
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 3:

											System.out.println("--------------Remover Promoção em Estilo--------------");
											System.out.println();

											System.out.println("Nome do Produto");
											String nomeE = LeDados.leString();
											System.out.println();
											
											Estilo e = l.srcEstilo(nomeE);
											
											for(Jogo a : e.getJogos()) {
																																				
												a.setCustoVenda(a.getCustoCompra() *2);
												a.setPromocao(false);
																								
											}
											
											System.out.println("Promoção removida com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 4:
											
											System.out.println("--------------Remover Promoção em Diretor--------------");
											System.out.println();

											System.out.println("Nome do Diretor");
											String nomeD = LeDados.leString();
											System.out.println();
											
											Diretor d = l.srcDiretor(nomeD);
											
											for(Jogo a : d.getJogos()) {
																																				
												a.setCustoVenda(a.getCustoCompra() *2);
												a.setPromocao(false);
																								
											}
											
											System.out.println("Promoção removida com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 5:
											
											System.out.println("-------------Remover Promoção em Produtora--------------");
											System.out.println();

											System.out.println("Nome da Produtora");
											String nomePr = LeDados.leString();
											System.out.println();
											
											Produtora p = l.srcProdutora(nomePr);
											
											for(Jogo a : p.getJogos()) {
																																				
												a.setCustoVenda(a.getCustoCompra() *2);
												a.setPromocao(false);
																								
											}
											
											System.out.println("Promoção removida com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 6:
											
											System.out.println("-------------Remover Promoção em Fornecedor--------------");
											System.out.println();

											System.out.println("Nome da Produtora");
											String nomeF = LeDados.leString();
											System.out.println();
											
											Fornecedor F = l.srcFornecedor(nomeF);
											
											for(Jogo a : F.getJogos()) {
																																				
												a.setCustoVenda(a.getCustoCompra() *2);
												a.setPromocao(false);
																								
											}
											
											System.out.println("Promoção removida com sucesso!");
											System.out.println("----------------------------------------------------------");
											System.out.println();
											
											break;
											
										case 7:
											System.out.println("A voltar ao menu de promoções..");
											break;
												
										default:
											System.out.println("Opção inválida. Tente novamente.");
											System.out.println();
											
										
										}
										
									} while(op241 != 7);
									
									break;
									
								case 3:
									System.out.println("A voltar ao menu de administrador..");
									break;
										
								default:
									System.out.println("Opção inválida. Tente novamente.");
									System.out.println();
									
								}
								
							} while(op24 != 3);
		
							break;
		
						case 4:
		
							do {
						    	
								System.out.println("--------------------Estatisticas----------------------");
								System.out.println();
								System.out.println("#1 -> Jogos mais Vendidos");
								System.out.println("#2 -> Estilo mais procurado");
								System.out.println("#3 -> Produtora com jogos mais vendidos");
								System.out.println("#4 -> Diretore com jogos mais vendidos");
								System.out.println("#5 -> Jogos pesquisados e comprados");
								System.out.println("#6 -> Jogos comprados em promoção");
								System.out.println("#7 -> Sair");
								System.out.println();
								System.out.println("------------------------------------------------------");
								System.out.println();
								
								System.out.print("Escolha uma Opção - ");
								op23 = LeDados.leInt();
								System.out.println();
								
								switch (op23) {
									
								case 1:
									
									System.out.println("---------------Top 5 Jogos mais vendidos--------------");
									System.out.println();
									
									try {
										
										Jogo[] top = l.top5();
										for (Jogo j : top) {
											System.out.println("Jogo: " + j.getNome() + "  Vendas: " + j.getStock().getVendas());
										}
									
									} catch(Exception erro) {
										System.out.println("Tente novamente quando forem vendidos mais jogos..");
									}
									
									System.out.println("------------------------------------------------------");
									System.out.println();
									
									break;
									
								case 2:
									
									System.out.println("------------Estilos mais pesquisados-----------");
									System.out.println();
									
									Estilo e = l.topEstilo();
									int iE = e.getPesquisas();
									
									System.out.println("Estilo: " + e.getNome() + "  Pesquisas: " + iE);
									
									System.out.println("------------------------------------------------------");
									System.out.println();
									
									break;
									
								case 3:
									
									System.out.println("------------Diretor com jogos mais vendidos-----------");
									System.out.println();
									
									Diretor d = l.topDiretor();
									int i = d.getTotalVendas();
									
									System.out.println("Diretor: " + d.getNome() + "  Vendas: " + i);
									
									System.out.println("------------------------------------------------------");
									System.out.println();
									
									break;
									
								case 4:
									
									System.out.println("-----------Produtora com jogos mais vendidos----------");
									System.out.println();
									
									Produtora p = l.topProdutora();
									int iP = p.getTotalVendas();
									
									System.out.println("Diretor: " + p.getNome() + "  Vendas: " + iP);
									
									System.out.println("------------------------------------------------------");
									System.out.println();
									
									break;
									
								case 5:
									
									System.out.println("-------------Jogos Pesquisados e Comprados------------");
									System.out.println();
																		
									l.mostraJogoMPR();
									
									System.out.println("------------------------------------------------------");
									System.out.println();
									
									break;
								
								case 6:
									
									System.out.println("-------------Jogos Comprados em Promoção-------------");
									System.out.println();
																		
									l.mostraJogoMP();
									
									System.out.println("------------------------------------------------------");
									System.out.println();
									
									break;
								
								case 7:
									System.out.println("A voltar ao menu de administrador..");
									break;
										
								default:
									System.out.println("Opção inválida. Tente novamente.");
									System.out.println();
									
								}
								
							} while(op23 != 7);
		
							break;
		
						case 5:
							System.out.println("A voltar ao menu incial..");
							
							break;
							
						default:
			                System.out.println("Opção inválida. Tente novamente.");
			                System.out.println();  
						
						}   
						
			    	} while(op2 != 5);
				
				} else {
					System.out.println("Foi excedido o limite de tentativas.. A voltar para o menu.."); 
				}
				
			    break;

				
			case 3:
				
				l.saveClientePes();
				l.allJogoPesquisadoF();
				l.saveFiles();
				l.saveVendas();
				break;
				
			default:
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println();  
                
			}   
			
    	} while(op != 3);
		
		
	}
	
}
