/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3.pdwa.crudproduto.model;

/**
 *
 * @author ezau
 */
public class Validador {

    public static void Validar(Produto produto) throws Exception {
        if(produto.getDesc().isEmpty() || produto.getDesc() == null){
            throw new Exception("Inserir descrição do produto!");
        }
        if(produto.getNome().isEmpty() || produto.getNome() == null){
            throw new Exception("Inserir nome do produto!");
        }
        if(produto.getQtd()<= 0){
            throw new Exception("A quantidade inserida deve ser maior que zero! ");
        }
        if(produto.getValorCompra()<=0){
            throw new Exception("O valor de compra deve ser maior que zero! ");
        }
        if(produto.getValorVenda()<=0){
            throw new Exception("O valor de venda deve ser maior que zero! ");
        }
    }
}
