package br.com.vinone.comentesobre.dao;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import br.com.caelum.vraptor.ioc.Component;
import br.com.vinone.comentesobre.model.Comentario;

@Component
public class Comentarios implements ComentarioDAO {
	
	private final Session _session;
	
	public Comentarios(Session session){
		this._session = session;
	}
	
	@Override
	public void Comentar(Comentario comentario) {
		this._session.save(comentario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> ConsultarPorAssunto(String assunto) {
		String expressao = "SELECT c FROM Comentario c WHERE c.assunto like :assunto";
		
		List<Comentario> comentarios = this._session
				.createQuery(expressao)
					.setParameter("assunto", assunto + "%").list();
		
		return comentarios;
	}
}
