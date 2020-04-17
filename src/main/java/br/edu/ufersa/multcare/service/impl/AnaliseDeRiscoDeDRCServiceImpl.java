package br.edu.ufersa.multcare.service.impl;

import br.edu.ufersa.multcare.service.AnaliseDeRiscoDeDRCService;
import org.springframework.stereotype.Component;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import static br.edu.ufersa.multcare.shared.baseaprendizagem.BaseAprendizagemSingleton.obterBaseAprendizagem;

@Component
public class AnaliseDeRiscoDeDRCServiceImpl implements AnaliseDeRiscoDeDRCService {


    @Override
    public void realizarClassificacaoAnalise() throws Exception {


        Instances instances = obterBaseAprendizagem();
        // 1.1 - espeficicação do atributo classe
        instances.setClassIndex(8);
        // (2) Construção do modelo classificador (treinamento)
        //------------------------------------------------------
        J48 k3 = new J48();
        k3.setOptions(new String[] { "-C", "0.25", "-M", "2", "-doNotMakeSplitPointActualValue" });
        k3.buildClassifier(instances);

        //        // 3.1 criação de uma nova instância
        Instance novo = new DenseInstance(10);
        novo.setDataset(instances);
        novo.setValue(0, "F"); // hipertensao
        novo.setValue(1, "F"); // diabets
        novo.setValue(2, 2.7); // creatina
        novo.setValue(3, 30); // ureia
        novo.setValue(4, 27); // microalbuminuria
        novo.setValue(5, 52); // idade
        novo.setValue(6, "M"); // sexo
        novo.setValue(7, 25.1); // tfg
//
//     // 3.2 classificação de uma nova instância
        double pred = k3.classifyInstance(novo);
//
//		        // 3.4 imprime a string correspondente ao valor de pred
        Attribute a = novo.attribute(8);
        String predClass = a.value((int) pred);
        System.out.println("Predição: " + predClass);

    }
}
