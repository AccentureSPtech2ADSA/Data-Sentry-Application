package app.controller;

import app.model.ProcessModel;
import com.github.britooo.looca.api.group.processos.Processo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessController extends ControllerLooca {

  public List<ProcessModel> getProcessPerMemo() {

    List<ProcessModel> models = new ArrayList<>();
    List<Processo> processosFiltrados = looca
            .getGrupoDeProcessos()
            .getProcessos()
            .stream()
            .distinct()
            .sorted(
                    Comparator
                            .comparingDouble(Processo::getUsoCpu)
                            .reversed())
            .limit(20)
            .collect(Collectors.toList());

    processosFiltrados
            .forEach(process -> {
              ProcessModel model = new ProcessModel();
              model.setName(process.getNome());
              model.setPid((long)process.getPid());
              model.setUseBytesDisk(process.getBytesUtilizados());
              model.setUseCpu(process.getUsoCpu());
              model.setUseMem(process.getUsoMemoria());
              
              models.add(model);
            });
    return models;
  }
}
