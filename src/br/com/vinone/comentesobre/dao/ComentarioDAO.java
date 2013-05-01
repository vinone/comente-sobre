package br.com.vinone.comentesobre.dao;

import br.com.vinone.comentesobre.model.*;
import java.util.List;

public interface ComentarioDAO {
	void Comentar(Comentario comentario);
	List<Comentario> ConsultarPorAssunto(String assunto);
}
