package br.senac.pi3.pwda.crudproduto.main;

import br.senac.pi3.pdwa.crudproduto.model.Produto;
import br.senac.pi3.pdwa.crudproduto.servico.ServicoProduto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String tipoProd = null;
        String prod = null;
        ServicoProduto produto = new ServicoProduto();
        Scanner leitor = new Scanner(System.in);

        System.out.println("***Bem Vindo***");
        System.out.println("[1] Buscar Produto");
        System.out.println("[2] Deletar Produto");
        System.out.println("[3] Inserir Produto");
        System.out.println("[4] Atualizar Produto");
        int opc = leitor.nextInt();
        
        switch(opc){
            case 1:
                    if (opc == 1) {
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
                    }
                    produto.select(prod, tipoProd);
            case 3:
                    System.out.println("Digite o nome do produto: ");
                    String nome = leitor.nextLine();
                    System.out.println("Digite a descrição do produto: ");
                    String descricao = leitor.nextLine();
                    System.out.println("Digite a quantidade de produtos: ");
                    int quantidade = leitor.nextInt();
                    System.out.println("Digite o valor da compra: ");
                    float valorCompra = leitor.nextFloat();
                    System.out.println("Digite o valor unitário do produto: ");
                    float valorVenda = leitor.nextFloat();
                    
                    Produto prod1 = new Produto();
        }
    }       
}
