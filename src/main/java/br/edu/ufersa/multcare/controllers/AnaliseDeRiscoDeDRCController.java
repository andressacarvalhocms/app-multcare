 package br.edu.ufersa.multcare.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.persistence.exceptions.DbContextException;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@RestController
public class AnaliseDeRiscoDeDRCController {
	
	@RequestMapping("/consultar-historico-analises")
    public String consultarHistoricoAnalises() throws DbContextException {
	//	List<Analise> analises = Repositories.analises.findAll();
	//	List<Analise> analises = Repositories.analises.findAll();
		
		// validar
		
        return null;
    }
	
	@GetMapping("/analise")
	public static void main(String[] args) throws Throwable {
//        //------------------------------------------------------
//        // (1) importação da base de dados de treinamento
//        //------------------------------------------------------
         DataSource source = new DataSource("base_treinamento.arff");
         Instances D = source.getDataSet();
//         
//         // 1.1 - espeficicação do atributo classe
         D.setClassIndex(8);
//        //------------------------------------------------------
//        // (2) Construção do modelo classificador (treinamento)
//        //------------------------------------------------------
         J48 k3 = new J48();
        k3.setOptions(new String[] { "-C", "0.25", "-M", "2", "-doNotMakeSplitPointActualValue" });
        k3.buildClassifier(D);
//         
//
//        // 3.1 criação de uma nova instância
       Instance novo = new DenseInstance(10);
       novo.setDataset(D);
       novo.setValue(0, "F");
       novo.setValue(1, "F");
       novo.setValue(2, 2.7);
       novo.setValue(3, 30);
       novo.setValue(4, 27);
       novo.setValue(5, 52);
       novo.setValue(6, "M");
       novo.setValue(7, 25.1);
//
//     // 3.2 classificação de uma nova instância
        double pred = k3.classifyInstance(novo);
//
//		        // 3.4 imprime a string correspondente ao valor de pred
		Attribute a = novo.attribute(8);
		String predClass = a.value((int) pred);
		System.out.println("Predição: " + predClass);
		//System.out.println("Predição: ");
	}
}