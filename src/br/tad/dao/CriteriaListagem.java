package br.tad.dao;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import br.tad.modelo.Produto;

public class CriteriaListagem {
	
	
	public List<Produto> listaProduto(){
		
		
		adicionarProdutos();
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		List<Produto> listaProdutos = null;

		
		Criteria criteria = session.createCriteria(Produto.class);
		listaProdutos = criteria.list();
		
		for(Produto p : listaProdutos){
			System.out.println(p.getNome());
		}
		
		criteria.addOrder(Order.asc("nome"));
		listaProdutos = criteria.list();
		
		for(Produto p : listaProdutos){
			System.out.println(p.getNome());
		}
		
		session.close();
		
		
		return listaProdutos;
	}
	
	public  void adicionarProdutos(){
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");


		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
	Collection<Produto> listaProdutosInserir = new ArrayList<Produto>();
		
		Produto produto = new Produto();
		
		produto.setNome("Prateleira");		
		produto.setDescricao("Uma prateleira para colocar livros 2");
		produto.setPreco(35.90);
				
		listaProdutosInserir.add(produto);
		
		produto = new Produto();		
		produto.setNome("X-Box");		
		produto.setDescricao("UM Console para jogar!");
		produto.setPreco(999.00);
		listaProdutosInserir.add(produto);
		
		produto = new Produto();
		
		produto.setNome("Play Station 3");		
		produto.setDescricao("UM Console para jogar!");
		produto.setPreco(999.90);
		listaProdutosInserir.add(produto);
		
		produto = new Produto();		
		produto.setNome("Abajur");		
		produto.setDescricao("UM Abajur para iluminar");
		produto.setPreco(45.00);
		listaProdutosInserir.add(produto);
				
		
		Transaction tx = session.beginTransaction();
		
		for(Produto p : listaProdutosInserir){
			session.save(p);
		}
		
		tx.commit();
	}
	
	
}