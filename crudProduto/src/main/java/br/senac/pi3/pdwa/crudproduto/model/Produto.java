package br.senac.pi3.pdwa.crudproduto.model;

public class Produto {

    private String nome;
    private String descricao;
    private int quantidade;
    private int id;
    private float valorCompra;
    private float valorVenda;

    /*
    public Produto(String nome, String descricao, int quantidade, float valorCompra, float valorVenda ){
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the desc
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param desc the desc to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the qtd
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorCompra
     */
    public float getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
