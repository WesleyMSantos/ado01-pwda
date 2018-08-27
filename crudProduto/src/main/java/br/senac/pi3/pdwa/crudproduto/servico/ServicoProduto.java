
package br.senac.pi3.pdwa.crudproduto.servico;

import br.senac.pi3.pdwa.crudproduto.bd.DAOProduto;
import br.senac.pi3.pdwa.crudproduto.model.Produto;
import br.senac.pi3.pdwa.crudproduto.model.Validador;
import java.util.ArrayList;
import java.util.List;

/*Os métodos dessa classe validam o produto e chamam os metodos da DAO*/
public class ServicoProduto {
 private static List<Produto> tabelaProdutos = new ArrayList<Produto>();
    
 /*Atualiza o produto*/
    public static void update(Produto produto)
            throws Exception {
        
        Validador.Validar(produto);
        try{
            DAOProduto.update(produto);
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
    public static String remove(String nomeProd){
        
        String retorno = null;
        
        try {
            
            DAOProduto.remove(nomeProd);
            
        } catch (Exception e) {
            e.printStackTrace();
            retorno = "Serviço temporariamente indisponível, contate o Administrador do Sistema!";
        }
        return retorno;
    }
    
     public static String select(String nomeProd, String tipoProd){
         
        String retorno = null;
        
        try {
            
            DAOProduto.select(nomeProd,tipoProd);
            
        } catch (Exception e) {
            e.printStackTrace();
            retorno = "Serviço temporariamente indisponível, contate o Administrador do Sistema!";
        }
        return retorno;
    }

}
