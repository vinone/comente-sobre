package br.com.vinone.comentesobre.controller;

import java.util.List;

import br.com.vinone.comentesobre.dao.*;
import br.com.vinone.comentesobre.model.*;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

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
		String assunto = comentario.getAssunto();
		
		result.include("assunto", assunto);
		
		List<Comentario> comentarios = dataAccess.ConsultarPorAssunto(assunto);
		result.include("comentarios",comentarios);
	}
	
	@Path("/")
	public void index() {
	}
	
	@Post("/salvar")
	public void salvar(Comentario comentario){
		try{
			dataAccess.Comentar(comentario);
		}catch(Exception exception){
			result.include("error-message", exception.getMessage());
		}finally{
			result.use(Results.logic())
				.redirectTo(ComentarioController.class)
					.comentar(comentario);
		}
	}
}
