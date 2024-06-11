import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;

public class Ficheiro {
	
	//----JOGOS
	//---Carrega os jogos do ficheiro
    public static HashSet<Jogo> loadJogos(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Jogo>) ois.readObject(); 
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos jogos não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os jogos no ficheiro
    public static void saveJogos(String file, HashSet<Jogo> jogos) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(jogos);
        
        }
    
    }
    
    //---HashMap Jogo/Quantidade
    public static HashMap<Jogo, Integer> loadJogosM(String file) 
      throws IOException, ClassNotFoundException {
    	    	
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
    	            
    		return (HashMap<Jogo, Integer>) ois.readObject(); 
    	        
    	} catch (FileNotFoundException e) {
    	    System.out.println("O ficheiro dos jogos promoção/pesquisado&registado não foi encontrado.");
    	    return new HashMap<>();
    	}
    }
    
    //---Guarda os jogos no ficheiro
    public static void saveJogosM(String file, HashMap<Jogo, Integer> jogos) 
      throws IOException {
    	    	
    	try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
    	            
    		oos.writeObject(jogos);
    	        
    	}
    	    
 	}
    
    //----PRODUTOS
    //---Carrega os produtos do ficheiro
    public static HashSet<Produto> loadProdutos(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Produto>) ois.readObject(); 
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos produtos não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os produtos no ficheiro
    public static void saveProdutos(String file, HashSet<Produto> produtos) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(produtos);
        
        }	catch (Exception e) {
            System.out.println("OÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇÇ");
        }
    
    }
    
    //----DIRETORES
    //---Carrega os diretores do ficheiro
    public static HashSet<Diretor> loadDiretores(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Diretor>) ois.readObject(); 
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos diretores não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os diretores no ficheiro
    public static void saveDiretores(String file, HashSet<Diretor> diretores) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(diretores);
        
        }
    
    }
    
    //----PRODUTORAS
    //---Carrega os produtoras do ficheiro
    public static HashSet<Produtora> loadProdutoras(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Produtora>) ois.readObject(); 
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos produtoras não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os diretores no ficheiro
    public static void saveProdutoras(String file, HashSet<Produtora> produtoras) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(produtoras);
        
        }
    
    }
    
    //----EMPREGADOS
    //---Carrega os empregados do ficheiro
    public static HashSet<Empregado> loadEmpregados(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Empregado>) ois.readObject();
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos diretores não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os empregados no ficheiro
    public static void saveEmpregados(String file, HashSet<Empregado> empregados) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(empregados);
        
        }
    
    }
    
    //----CLIENTES
    //---Carrega os clientes do ficheiro
    public static HashSet<Cliente> loadClientes(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Cliente>) ois.readObject();
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos clientes não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os empregados no ficheiro
    public static void saveClientes(String file, HashSet<Cliente> clientes) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(clientes);
        
        }
    
    }
    
    //----FORNECEDORES
    //---Carrega os Fornecedores do ficheiro
    public static HashSet<Fornecedor> loadFornecedores(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Fornecedor>) ois.readObject();
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos clientes não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os Fornecedores no ficheiro
    public static void saveFornecedores(String file, HashSet<Fornecedor> fornecedores) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(fornecedores);
        
        }
    
    }
    
    //----ESTILOS
    //---Carrega os Estilos do ficheiro
    public static HashSet<Estilo> loadEstilos(String file) 
      throws IOException, ClassNotFoundException {
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            
        	return (HashSet<Estilo>) ois.readObject();
        
        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro dos estilos não foi encontrado.");
            return new HashSet<>();
        }
    }
    
    //---Guarda os Estilos no ficheiro
    public static void saveEstilos(String file, HashSet<Estilo> estilos) 
      throws IOException {
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            
        	oos.writeObject(estilos);
        
        }
    
    }
    
    
    
	
}
