package br.senac.pi3.pdwa.crudproduto.model;

public class Validador {

    public static void Validar(Produto produto) throws Exception {
        if (produto.getDescricao().isEmpty() || produto.getDescricao() == null) {
            throw new Exception("Inserir descrição do produto!");
        }
        if (produto.getNome().isEmpty() || produto.getNome() == null) {
            throw new Exception("Inserir nome do produto!");
        }
        if (produto.getQuantidade() <= 0) {
            throw new Exception("A quantidade inserida deve ser maior que zero! ");
        }
        if (produto.getValorCompra() <= 0) {
            throw new Exception("O valor de compra deve ser maior que zero! ");
        }
        if (produto.getValorVenda() <= 0) {
            throw new Exception("O valor de venda deve ser maior que zero! ");
        }
    }
}
