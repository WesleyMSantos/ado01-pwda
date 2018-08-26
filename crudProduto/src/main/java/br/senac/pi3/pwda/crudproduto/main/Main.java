package br.senac.pi3.pwda.crudproduto.main;

import br.senac.pi3.pdwa.crudproduto.bd.DAOProduto;
import br.senac.pi3.pdwa.crudproduto.servico.ServicoProduto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String tipoProd = null;
        String prod = null;
        ServicoProduto produto = new ServicoProduto();
        Scanner leitor = new Scanner(System.in);

        System.out.println("---Bem Vindo---");
        System.out.println("[1] Buscar Produto");
        System.out.println("[2] Deletar Produto");
        System.out.println("[3] Inserir Produto");
        System.out.println("[4] Atualizar Produto");
        int opc = leitor.nextInt();

        if (opc == 1) {
            System.out.println("Deseja pesquisar por Tipo de produto");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int opc2 = leitor.nextInt();

            if (opc2 == 1) {
                System.out.println("Digite o tipo de produto");
                tipoProd = leitor.next();
            } else {
                tipoProd = "";
            }
            
            System.out.println("Deseja visualizar todos o produtos ou algum específico");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int opc3 = leitor.nextInt();

            if (opc3 == 1) {
                prod = leitor.nextLine();
            }

        }

        produto.select(prod, tipoProd);

    }
}
