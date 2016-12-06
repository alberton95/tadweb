package br.tad;
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




import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.tad.dao.CriteriaListagem;
import br.tad.dao.ProdutoDAO;
import br.tad.modelo.Produto;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/produtoService")
public class ProdutoService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/listaXml")
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public List<Produto> listar() {
    	
    	List<Produto> listaProduto = new CriteriaListagem().listaProduto();     	
    	
    	return listaProduto;
    }
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/listaJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarJson() {
    	
    	List<Produto> listaProduto = new CriteriaListagem().listaProduto();     	
    	
    	return listaProduto;
    }
    
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/incluir")   
    @Produces(MediaType.APPLICATION_JSON)
    public String incluir(
    		@QueryParam(value = "nome") String nome,
    		@QueryParam(value = "descricao") String descricao,
    		@QueryParam(value = "preco") String preco
    		) {
    	
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto.setNome(nome);
    	produto.setDescricao(descricao);
    	produto.setPreco(new Double(preco));    	    	
    	dao.adicionaProduto(produto);
    	    	
    	return "sucesso";
    }
    
    @GET
    @Path("/alterar")   
    @Produces(MediaType.APPLICATION_JSON)
    public String alterar(
    		@QueryParam(value = "nome") String nome,
    		@QueryParam(value = "descricao") String descricao,
    		@QueryParam(value = "preco") double preco,
    		@QueryParam(value = "id") Long id
    		) {
    	
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto = dao.buscarProduto(id);
    	if(produto!=null){
    		produto.setNome(nome);
    		produto.setDescricao(descricao);
    		produto.setPreco(new Double(preco));    	    	
    		dao.alterar(produto, nome, descricao, preco);
    	}
    	    	
    	return "sucesso";
    }
    
    @GET
    @Path("/remover")   
    @Produces(MediaType.APPLICATION_JSON)
    public String remover(
    		@QueryParam(value = "id") Long id
    		)
    {
    	
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto = dao.buscarProduto(id);
    	if(produto!=null){  	    	
    		dao.remover(produto);
    		return "sucesso";
    	}
    	 
    	return "Produto não encontrado!";
    }
    
    @GET
    @Path("/buscar")   
    @Produces(MediaType.APPLICATION_JSON)
    public Produto buscar(
    		@QueryParam(value = "id") Long id
    		)
    {
    	
    	
    	ProdutoDAO dao = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto = dao.buscarProduto(id);
    	 
    	return produto;
    }
    
    
}