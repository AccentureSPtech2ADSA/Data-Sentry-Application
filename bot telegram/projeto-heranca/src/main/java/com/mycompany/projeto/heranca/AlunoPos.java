
package com.mycompany.projeto.heranca;

public class AlunoPos extends Aluno{
    
    private Double nota3;

    public AlunoPos(Integer ra, String nome, Double nota1, Double nota2, Double nota3) {
        super(ra, nome, nota1, nota2);
        this.nota3 = nota3;
    }

    @Override
    public Double calcularMedia() {
        return (super.getNota1() + super.getNota2() + nota3) / 3; 
    }
    
}
