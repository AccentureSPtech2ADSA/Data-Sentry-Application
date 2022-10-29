
package com.mycompany.vendedor.exercicio;

public class VendedorComissao {
    
    private Integer codigo;
    private String nome;
    private Double vendas;
    private Double taxa;

    public VendedorComissao(Integer codigo, String nome, Double vendas, Double taxa) {
        this.codigo = codigo;
        this.nome = nome;
        this.vendas = vendas;
        this.taxa = taxa;
    }
    
    public Double calcularSalario(){
        return (taxa / 100) * vendas;
    }
    
}
