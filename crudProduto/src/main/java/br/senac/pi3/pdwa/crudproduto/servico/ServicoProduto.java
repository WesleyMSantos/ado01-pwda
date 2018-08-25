/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
