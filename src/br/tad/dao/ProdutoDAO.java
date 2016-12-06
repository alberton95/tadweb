package br.tad.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.tad.modelo.Produto;

public class ProdutoDAO {
			
	public void adicionaProduto(Produto produto){			
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();		
		session.save(produto);		
		tx.commit();		
		session.close();
		
	}
	
	
	public List<Produto> listarProdutos(){
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Query query = 
				session.createQuery("select p from Produto p ");
		
		List<Produto> listaRetorno = query.list();
		
		// select p from Produto p where p.outroNome =:produto		
		
		return listaRetorno;
	}
	
	public void remover(Produto produto) {
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(produto);
		tx.commit();
	}
	
	public Produto buscarProduto(Long id){
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Produto alteraproduto = (Produto) session.get(Produto.class, id);
		return alteraproduto;
	}
	
	public void alterar(Produto produto, String nome, String descricao, double preco) {
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		// carrega o produto do banco de dados
		

		Transaction tx = session.beginTransaction();
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setPreco(preco);
		session.update(produto);
		tx.commit();
	}
	
	
}