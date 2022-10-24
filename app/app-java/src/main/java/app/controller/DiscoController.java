package app.controller;

import app.model.DiscoModel;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import java.util.ArrayList;
import java.util.List;

public class DiscoController {

    private Looca looca;

    public DiscoController() {
        looca = new Looca();
    }

    public List<DiscoModel> pegarListaDiscos() {
        List<DiscoModel> discos = new ArrayList();

        for (Disco disk : looca.getGrupoDeDiscos().getDiscos()) {
            DiscoModel disco = new DiscoModel();
            disco.setNomeDisco(disk.getNome());
            disco.setTamanhoDisco(disk.getTamanho().doubleValue());
            disco.setModeloDisco(disk.getModelo());
            disco.setSerialDisco(disk.getSerial());

            discos.add(disco);
        }
        return discos;
    }

}
