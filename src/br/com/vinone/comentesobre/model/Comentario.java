package br.com.vinone.comentesobre.model;	

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@NotNull
	private String assunto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Autor autor;
	
	@NotNull
	private String descricao;
	
	protected Comentario(){}
	
	public Comentario(String assunto,String descricao, Autor autor) throws NullAttributeException{
		this.setAssunto(assunto);
		this.setDescricao(descricao);
		this.setAutor(autor);
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) throws NullAttributeException {
		if(assunto.isEmpty()) 
			atributoNullException("assunto");
			
		this.assunto = assunto;
	}
	
	public Autor getAutor(){
		return autor;
	}
	
	public void setAutor(Autor autor) throws NullAttributeException {
		if(autor == null)
			atributoNullException("autor");

		this.autor = autor;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String descricao) throws NullAttributeException {
		if(descricao.isEmpty())
			atributoNullException("comentario");
		this.descricao = descricao;
	}
	
	private void atributoNullException(String atributo) throws NullAttributeException{
		throw new NullAttributeException("not-null", atributo);
	}

}
