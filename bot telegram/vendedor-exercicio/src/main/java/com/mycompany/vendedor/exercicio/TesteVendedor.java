
package com.mycompany.vendedor.exercicio;

public class TesteVendedor {
    
    public static void main(String[] args) {
        
        VendedorComissao vendedorComissao = 
                new VendedorComissao(1, "Matheus", 300.0, 10.0);
        VendedorComissaoMaisFixo vendedorComissaoMaisFixo = 
                new VendedorComissaoMaisFixo(
                        2, 
                        "Vitoria", 
                        300.0, 
                        10.0, 
                        1600.0
                );
        
        System.out.println(vendedorComissao.calcularSalario());
        System.out.println(vendedorComissaoMaisFixo.calcularSalario());
        
    }
    
}
