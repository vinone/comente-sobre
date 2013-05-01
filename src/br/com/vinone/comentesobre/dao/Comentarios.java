package br.com.vinone.comentesobre.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
		return this._session
				.createCriteria(Comentario.class)
					.add(Restrictions.ilike("assunto","%" + assunto + "%")).list();
	}
}
