/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import com.github.britooo.looca.api.core.Looca;
import java.util.ArrayList;
import java.util.List;
import app.model.DiscoModel;
import com.github.britooo.looca.api.group.discos.Disco;

/**
 *
 * @author guilherme-narciso
 */
public class LoocaDisco {
  
  private Looca looca;
  
  public LoocaDisco(){
    looca = new Looca();
  }
  
  public List<DiscoModel> pegarListaDiscos(){
    List<DiscoModel> discos = new ArrayList();
    
    for (Disco disk : looca.getGrupoDeDiscos().getDiscos()) {
       DiscoModel disco = new DiscoModel();
       disco.setNomeDisco(disk.getNome());
       disco.setTamanhoDisco(disk.getTamanho());
       
       discos.add(disco);
    }
    return discos;
  }
}
