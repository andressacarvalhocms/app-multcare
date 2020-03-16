package br.edu.ufersa.multcare.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamesController {
/*	
	@RequestMapping("/exames/adicionar")
    public String adicionar() {
        return null;
    }
	
	@RequestMapping("/exames/alterar")
    public String alterar(@RequestParam Map<String,String> allRequestParams) throws DbContextException {
		
		String id  = allRequestParams.get("id");
		
		Exame exame = Repositories.exames.findById(Integer.parseInt(id));
        if(exame == null) {
        	return "not found";
        }
        
        String nome  = allRequestParams.get("nome");
        String resultado = allRequestParams.get("resultado");
        
        exame.setNome(nome);
        exame.setResultado(resultado);
        
        Repositories.persist(exame);
        
        return "ok";
    }
	
	@RequestMapping("/exames/excluir")
    public String excluir(@RequestParam int id) throws DbContextException {
		
        Exame exame = Repositories.exames.findById(id);
        if(exame == null) {
        	return "not found";
        }
        
        Repositories.remove(exame);
        return "ok";
    }
	
	@RequestMapping("/exames/listar")
    public List<Exame> listar() throws DbContextException {
		List<Exame> exames = Repositories.exames.findAll();
        return exames;
    } */
}
