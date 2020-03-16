package br.edu.ufersa.multcare.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlergiasController {
	/*
	@RequestMapping("/alergias/adicionar")
    public String adicionar() {
        return null;
    }
	
	@RequestMapping("/alergias/alterar")
    public String alterar(@RequestParam Map<String,String> allRequestParams) throws DbContextException {
		
		String id  = allRequestParams.get("id");
		
		Alergia alergia = Repositories.alergias.findById(Integer.parseInt(id));
		if(alergia == null) {
        	return "not found";
        }
        
        String nome  = allRequestParams.get("nome");
        String gravidade = allRequestParams.get("gravidade");
        
        alergia.setNome(nome);
        alergia.setGravidade(gravidade);
        
        Repositories.persist(alergia);
        
        return "ok";
    }
	
	@RequestMapping("/alergias/excluir")
    public String excluir(@RequestParam int id) throws DbContextException {
		Alergia alergia = Repositories.alergias.findById(id);
        if(alergia == null) {
        	return "not found";
        }
        
        Repositories.remove(alergia);
        return "ok";
    }
	
	@RequestMapping("/alergias/listar")
    public List<Alergia> listar() throws DbContextException {
		List<Alergia> alergias = Repositories.alergias.findAll();
        return alergias;
    } */
}
