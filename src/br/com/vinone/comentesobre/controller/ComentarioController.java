package br.com.vinone.comentesobre.controller;

import br.com.vinone.comentesobre.dao.*;
import br.com.vinone.comentesobre.model.*;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ComentarioController {
	
	private final Result result;
	private final ComentarioDAO dataAccess;

	public ComentarioController(Result result, ComentarioDAO comentarioDAO) {
		this.result = result;
		this.dataAccess =  comentarioDAO;
	}
	
	@Get
	@Path("/{comentario.assunto}")
	public void comentar(Comentario comentario){
		result.include("assunto", comentario.getAssunto());
	}
	
	@Path("/")
	public void index() {
	}
}
