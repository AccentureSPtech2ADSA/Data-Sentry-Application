package app.model;

public enum ComponentTypeEnum {
  RAM("RAM", "GBs", 1),
  CPU("CPU", "MHz", 2),
  DISCO("DISCO", "GBs", 3);
  
  private final String descricao;
  private final String unidadeMedida;
  private final Integer idTypeComponent;
  
  private ComponentTypeEnum(String descricao, String unidadeMedida, Integer idTypeComponent) {  
    this.descricao = descricao;
    this.unidadeMedida = unidadeMedida;
    this.idTypeComponent = idTypeComponent;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getUnidadeMedida() {
    return unidadeMedida;
  }

  public Integer getIdTypeComponent() {
    return idTypeComponent;
  }
  
}
