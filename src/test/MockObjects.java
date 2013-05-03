package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import com.thoughtworks.xstream.XStream;
import br.com.vinone.comentesobre.model.Autor;
import br.com.vinone.comentesobre.model.Comentario;

public class MockObjects {
	
	public static String getSerializedComentarios() throws NullAttributeException{
		XStream writer = JSONSerialization.getXStreamJSON();
		writer.alias("list", List.class);
		return writer.toXML(getComentarios());
	}
	
	public static List<Comentario> getComentarios() throws NullAttributeException{
		List<Comentario> comentarios = new ArrayList<Comentario>();
		comentarios.add(getComentario("testes","Testes dão consistência ao seu código de produção."));
		comentarios.add(getComentario("testes","Testes deixam as portas da evolução sempre abertas."));
		return comentarios;
	}
	
	public static Comentario getComentario(String assunto,String descricao) throws NullAttributeException{
		return new Comentario(assunto,descricao,getAutor());
	}
	
	public static Autor getAutor(){
		return new Autor("autor@email.com");
	}
}
