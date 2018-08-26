
package br.senac.pi3.pdwa.crudproduto.servico;

import br.senac.pi3.pdwa.crudproduto.bd.DAOProduto;
import br.senac.pi3.pdwa.crudproduto.model.Produto;
import br.senac.pi3.pdwa.crudproduto.model.Validador;

/*Os métodos dessa classe validam o produto e chamam os metodos da DAO*/
public class ServicoProduto {

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
}
