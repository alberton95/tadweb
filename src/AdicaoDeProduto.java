


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdicaoDeProduto {
	

	
	
	
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
	
	
	
	
}