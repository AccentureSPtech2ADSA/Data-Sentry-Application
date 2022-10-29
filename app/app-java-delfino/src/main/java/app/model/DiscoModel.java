
package app.model;

public class DiscoModel {
  private String nomeDisco;
  private Long tamanhoDisco;

  public String getNomeDisco() {
    return nomeDisco;
  }

  public void setNomeDisco(String nomeDisco) {
    this.nomeDisco = nomeDisco;
  }

  public Long getTamanhoDisco() {
    return tamanhoDisco;
  }

  public void setTamanhoDisco(Long tamanhoDisco) {
    this.tamanhoDisco = tamanhoDisco;
  }

  public Double getTamanhoDiscoFormatado(){
    return Math.floor(tamanhoDisco * 0.000000001);
  }

  @Override
  public String toString() {
    return "DiscoModel{" + "nomeDisco=" + nomeDisco + ", tamanhoDisco=" + tamanhoDisco + '}';
  }
  
  
}
