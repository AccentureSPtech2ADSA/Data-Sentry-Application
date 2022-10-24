
package app.model;

public class DiscoModel {
    
    private String nomeDisco;
    private String modeloDisco;
    private String serialDisco;
    private Double tamanhoDisco;
    private String replaceVirgulaTamanhoDisco;

    public String getNomeDisco() {
        return nomeDisco;
    }

    public void setNomeDisco(String nomeDisco) {
        this.nomeDisco = nomeDisco;
    }

    public String getModeloDisco() {
        return modeloDisco;
    }

    public void setModeloDisco(String modeloDisco) {
        this.modeloDisco = modeloDisco;
    }

    public String getSerialDisco() {
        return serialDisco;
    }

    public void setSerialDisco(String serialDisco) {
        this.serialDisco = serialDisco;
    }

    public Double getTamanhoDisco() {
        return Math.floor(tamanhoDisco * 0.000000001);
    }

    public void setTamanhoDisco(Double tamanhoDisco) {
        this.tamanhoDisco = tamanhoDisco;
    }

    public String getReplaceVirgulaTamanhoDisco() {
        return replaceVirgulaTamanhoDisco;
    }

    public void setReplaceVirgulaTamanhoDisco(String replaceVirgulaTamanhoDisco) {
        this.replaceVirgulaTamanhoDisco = getTamanhoDisco().toString().replaceAll("\\,", ".");
    }
}
