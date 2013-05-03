package test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockSerializationResult;
import br.com.vinone.comentesobre.controller.ComentarioController;
import br.com.vinone.comentesobre.dao.ComentarioDAO;
import br.com.vinone.comentesobre.model.Comentario;

public class ComentarioControllerTest {

	private MockResult _result;
	private MockSerializationResult _resultSerialization;
	
	@Mock
	private ComentarioDAO _dataAccess;
	
	private ComentarioController _controller;
	private String _assunto = "testes";
	
	@Before
	public void initialize(){
		MockitoAnnotations.initMocks(this);
		_result = new MockResult();
		_resultSerialization = new MockSerializationResult();
	}
	
	@Test
	public void dadoUmAssuntoDeveRetornarUmaListaDeComentarios() throws Exception  {
		List<Comentario> comentarios = MockObjects.getComentarios();
		Mockito.when(this._dataAccess.ConsultarPorAssunto(_assunto))
			.thenReturn(comentarios);
		
		_controller = getControllerToSerializedResults();
		_controller.listar(_assunto);
		
		String comentariosEsperados = MockObjects.getSerializedComentarios();
		String comentariosRetornados = this._resultSerialization.serializedResult();
		
		assertEquals(comentariosEsperados, comentariosRetornados);
	}
	
	@Test
	public void dadoUmAssuntoDeveEstarDisponivelNaView() throws Exception{
		_controller = getControllerToResults();
		_controller.comentar(MockObjects
				.getComentario(_assunto, "O teste é além de funcionar, é funcionar bem!"));
		
		String assuntoRetornado = this._result.included().get("assunto").toString();
		
		assertEquals(_assunto,assuntoRetornado);
	}
	
	private ComentarioController getControllerToSerializedResults(){
		return new ComentarioController(_resultSerialization,_dataAccess);
	}
	
	private ComentarioController getControllerToResults(){
		return new ComentarioController(_result,_dataAccess);
	}

}
