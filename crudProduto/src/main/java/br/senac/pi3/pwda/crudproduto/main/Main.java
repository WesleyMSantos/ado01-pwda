package br.senac.pi3.pwda.crudproduto.main;

import br.senac.pi3.pdwa.crudproduto.bd.DAOProduto;
import br.senac.pi3.pdwa.crudproduto.model.Produto;
import br.senac.pi3.pdwa.crudproduto.servico.ServicoProduto;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        String tipoProd = null;
        String prod = null;
        int opc;

        ServicoProduto produto = new ServicoProduto();
        Scanner leitor = new Scanner(System.in);

        do {

            System.out.println("***Bem Vindo***");
            System.out.println("[1] Buscar Produto");
            System.out.println("[2] Deletar Produto");
            System.out.println("[3] Inserir Produto");
            System.out.println("[4] Atualizar Produto");
            System.out.println("[0] Sair");
            opc = leitor.nextInt();

            switch (opc) {
                case 1:

                    System.out.println("Deseja pesquisar por categoria de produto:");
                    System.out.println("[1] Sim");
                    System.out.println("[2] Não");
                    int opc2 = leitor.nextInt();

                    if (opc2 == 1) {
                        System.out.println("Digite a categoria do produto:");
                        tipoProd = leitor.next();
                    } else {
                        tipoProd = "";
                    }

                    System.out.println("Deseja visualizar todos o produtos:");
                    System.out.println("[1] Sim");
                    System.out.println("[2] Não");
                    int opc3 = leitor.nextInt();

                    if (opc3 == 2) {
                        System.out.print("Digite o nome do produto: ");
                        prod = leitor.next();
                    }

                    produto.select(prod, tipoProd);
                    break;
                case 2:
                    String nomeProd,
                     retorno;
                    System.out.println("Digite o nome do Produto para ser Deletado: ");
                    nomeProd = leitor.next();
                    retorno = ServicoProduto.remove(nomeProd);
                    if (retorno == null) {
                        System.out.println("Produto excluído com sucesso!");
                    }

                    break;

                case 3:
                    System.out.println("Digite o nome do produto: ");
                    String nome = leitor.next();
                    System.out.println("Digite a descrição do produto: ");
                    String descricao = leitor.next();
                    System.out.println("Digite a quantidade de produtos: ");
                    int quantidade = leitor.nextInt();
                    System.out.println("Digite o valor da compra: ");
                    float valorCompra = leitor.nextFloat();
                    System.out.println("Digite o valor unitário do produto: ");
                    float valorVenda = leitor.nextFloat();

                    Produto product = new Produto();
                    DAOProduto dao = new DAOProduto();

                    product.setNome(nome);
                    product.setDescricao(descricao);
                    product.setQuantidade(quantidade);
                    product.setValorCompra(valorCompra);
                    product.setValorVenda(valorVenda);

                    dao.insert(product);
                    break;

                case 4:
                    System.out.println("Digite a ID do produto a ser atualizado");
                    int id = leitor.nextInt();
                    System.out.println("Digite o nome do produto: ");
                    String novoNome = leitor.next();
                    System.out.println("Digite a descrição do produto: ");
                    String novaDescricao = leitor.next();
                    System.out.println("Digite a quantidade de produtos: ");
                    int novaQuantidade = leitor.nextInt();
                    System.out.println("Digite o valor da compra: ");
                    float novoValorCompra = leitor.nextFloat();
                    System.out.println("Digite o valor unitário do produto: ");
                    float novoValorVenda = leitor.nextFloat();

                    Produto p = new Produto();

                    p.setId(id);
                    p.setNome(novoNome);
                    p.setDescricao(novaDescricao);
                    p.setQuantidade(novaQuantidade);
                    p.setValorCompra(novoValorCompra);
                    p.setValorVenda(novoValorVenda);

                    try {
                        produto.update(p);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

            }

        } while (opc != 0);

    }
}
