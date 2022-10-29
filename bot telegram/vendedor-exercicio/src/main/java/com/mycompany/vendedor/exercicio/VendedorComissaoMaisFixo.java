
package com.mycompany.vendedor.exercicio;

public class VendedorComissaoMaisFixo extends VendedorComissao{
    
    private Double salarioFixo;

    public VendedorComissaoMaisFixo(Integer codigo, String nome, Double vendas, Double taxa, Double salarioFixo) {
        super(codigo, nome, vendas, taxa);
        this.salarioFixo = salarioFixo;
    }
    
    
    
    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + salarioFixo; 
    }
    
    
}
