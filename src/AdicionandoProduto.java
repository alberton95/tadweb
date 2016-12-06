/**
 * Projeto das trilhas de treinamento de Java básico ou avançado 
 * com foco nas certificações java e em treinamentos corporativos. 
 * Fontes disponíveis em https://github.com/rodrigofujioka
 * 
 * Professor: Rodrigo da Cruz Fujioka
 * Ano: 2016
 * http://www.rodrigofujioka.com
 * http://www.fujideia.com.br
 * http://lattes.cnpq.br/0843668802633139
 * 
 * Contato: rcf4@cin.ufpe.br 
 * 
 */


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que define o comportamento para o objeto.
 * @author: Rodrigo
 * @date: 27 de mai de 2016
 * @Time: 01:33:52
 */
public class AdicionandoProduto {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("tad");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Produto produto = new Produto();
		produto.setDescricao("Uma prateleira para colocar livros 2");
		produto.setPreco(35.90);
		produto.setNome("Prateleira");

		
		
		em.persist(produto);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
		System.out.println("Tudo Certo!");		
	}
	
}
