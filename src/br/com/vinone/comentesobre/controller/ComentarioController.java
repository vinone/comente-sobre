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
	}
	
	@Get("/listar/{assunto}")
	public void listar(String assunto){
		List<Comentario> comentarios = dataAccess
				.ConsultarPorAssunto(assunto);
		
		result.use(Results.json())
				.from(comentarios).include("autor")
					.serialize();
	}
	
	@Path("/")
	public void index() {
	}
	
	//Não consegui fazer funcionar para aceitar a mesma url no post
	//Por isso ficou "/salvar" para conseguir salvar
	@Post("/salvar")
	public void comentar(Comentario comentario,Autor autor){
		String message = "";
		try{
			comentario.setAutor(autor);
			dataAccess.Comentar(comentario);
			message = "{ message: 'obrigado por compartilhar!', type: 'success'}";
		}catch(Exception exception){
			message = "{ message: '" + exception.getMessage() + "', type: 'error'}";
		}finally{
			result.use(Results.json())
			.withoutRoot()
				.from(message).serialize();
		}
	}
}
