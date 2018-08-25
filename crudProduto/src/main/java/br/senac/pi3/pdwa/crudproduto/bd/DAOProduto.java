package br.senac.pi3.pdwa.crudproduto.bd;

import br.senac.pi3.pdwa.crudproduto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*Métodos de CRUD do banco de dados*/
public class DAOProduto {

    /*SQL pra atualizar o produto*/
    public static void update(Produto produto)
            throws SQLException {
        try {
            Connection connection = ConnectionUtils.obterConexao();
            produto = new Produto();
            String sql = "UPDATE Produto SET nome?, Descricao=?, preco_compra=?, preco_venda=?, Quantidade=? WHERE id=?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDesc());
            pst.setFloat(3, produto.getValorCompra());
            pst.setFloat(4, produto.getValorVenda());
            pst.setInt(5, produto.getQtd());
            pst.setInt(6, produto.getId());
            
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
