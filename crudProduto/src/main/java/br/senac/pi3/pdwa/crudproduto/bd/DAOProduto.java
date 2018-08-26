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
    
    public static void remove(String nomeProd){
        
        String querySql = "DELETE FROM PRODUTO WHERE (NOME=?)";
        
        try(Connection connection = ConnectionUtils.obterConexao();
                PreparedStatement stmt = connection.prepareStatement(querySql);
                ){
            
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
        public static void select(String nomeProd,String tipoProd){
            String querySql;
            if (nomeProd == null){
                querySql = "SELECT ID, NOME, DESCRICAO,PRECO_COMPRA,PRECO_VENDA,QUANTIDADE,DT_CADASTRO FROM PRODUTO";
            }else{
                querySql = "SELECT * FROM PRODUTO WHERE NOME LIKE '(NOME=?%)'";
            }    
            try(Connection conn = ConnectionUtils.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(querySql);
                ResultSet resultados = stmt.executeQuery()){
            
            while(resultados.next()){
                
                long id = resultados.getLong("ID");
                String prodNome = resultados.getString("NOME");
                String descProd = resultados.getString("DESCRICAO");
                float preCompra = resultados.getFloat("PRECO_COMPRA");
                float preVenda = resultados.getFloat("PRECO_VENDA");
                int Qtd = resultados.getInt("QUANTIDADE");
                Date dtCadastro = resultados.getDate("DT_CADASTRO");
                
                System.out.println(id + "|" + prodNome + "|" + descProd + "|" + preCompra + "|"
                + preVenda + "|" + Qtd + "|" + dtCadastro);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }   
}
