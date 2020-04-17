package br.edu.ufersa.multcare.service;

import org.springframework.stereotype.Service;
import weka.classifiers.trees.J48;

@Service
public interface AnaliseDeRiscoDeDRCService {

    void realizarClassificacaoAnalise() throws Exception;
}
