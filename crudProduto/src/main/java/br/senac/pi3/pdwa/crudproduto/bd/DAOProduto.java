package br.senac.pi3.pdwa.crudproduto.bd;

import br.senac.pi3.pdwa.crudproduto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Métodos de CRUD do banco de dados*/
public class DAOProduto {
    
        public static void insert(Produto produto) throws SQLException {
            
        String query = "INSERT INTO PRODUTO  (nome, desc, qtd, id, valorCompra, valorVenda) VALUES(?,?,?,?,?,?)";
        
            try(Connection connection = ConnectionUtils.obterConexao();
                 PreparedStatement stmt = connection.prepareStatement(query);    ) {
                produto = new Produto();
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDesc());
                stmt.setInt(3, produto.getQtd());
                stmt.setInt(4, produto.getId());
                stmt.setFloat(5, produto.getValorCompra());
                stmt.setFloat(6, produto.getValorVenda());
                stmt.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
            

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

    public static void remove(String nomeProd) {

        String querySql = "DELETE FROM PRODUTO WHERE (NOME=?)";

        try (Connection connection = ConnectionUtils.obterConexao();
                PreparedStatement stmt = connection.prepareStatement(querySql);) {

            stmt.setString(1, nomeProd);
            stmt.executeUpdate();
            while (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void select(String nomeProd, String tipoProd) {
        String querySql;
        String join = " INNER JOIN PRODUTOBD.PRODUTO_CATEGORIA AS PROCAT ON PRO.ID = PROCAT.ID_PRODUTO ";
        String join2 = " INNER JOIN PRODUTOBD.CATEGORIA AS CAT ON CAT.ID = PROCAT.ID_CATEGORIA ";

//       if (tipoProd == null && nomeProd == null){
//            querySql = "SELECT PRO.*, CAT.* FROM PRODUTOBD.PRODUTO AS PRO " + join + join2;             
        if (tipoProd == null) {
            tipoProd = "";
        } else if (nomeProd == null) {
            nomeProd = "";
        }
        querySql = "SELECT PRO.*, CAT.* FROM PRODUTOBD.PRODUTO AS PRO " + join + join2
                + "WHERE CAT.NOME LIKE '%" + tipoProd + "%' " + " AND PRO.NOME LIKE '%" + nomeProd + "'";

        System.out.println("***Produtos***");
        try (Connection conn = ConnectionUtils.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(querySql);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {

                long id = resultados.getLong("ID");
                String prodNome = resultados.getString("PRO.NOME");
                String procate = resultados.getString("CAT.NOME");
                String descProd = resultados.getString("DESCRICAO");
                float preCompra = resultados.getFloat("PRECO_COMPRA");
                float preVenda = resultados.getFloat("PRECO_VENDA");
                int Qtd = resultados.getInt("QUANTIDADE");
                Date dtCadastro = resultados.getDate("DT_CADASTRO");

                System.out.println("Código: " + id);
                System.out.println("Nome: " + prodNome);
                System.out.println("Categoria: " + procate);
                System.out.println("Desc: " + descProd);
                System.out.println("Preço de Compra: " + preCompra);
                System.out.println("Preço de Venda: " + preVenda);
                System.out.println("Qtd: " + Qtd);
                System.out.println("Data de Cadastro: " + dtCadastro);
                System.out.println("----------------------------------");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
