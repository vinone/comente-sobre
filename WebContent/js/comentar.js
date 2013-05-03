var grid = $(".table ");
var mainForm = $(".form-vertical");

$(document).ready(function(){
	var assunto = mainForm.find(":hidden").val();
	
	listarComentariosPorAssunto(assunto);
	
	mainForm.find(".btn-primary").click(function(){
		var postData = mainForm.serialize();
		var action = mainForm.attr("action").val() + assunto;
		
		$.ajax({  
		    type:"post",  
		    url: action,  
		    data: postData,
		    dataType: "json",  
		    success: function(data){
		    	alert(data);
		    	listarComentariosPorAssunto(assunto);
	    	},
		    error: function(xhr, textStatus, errorThrown){ alert("Erro!"); }
		});
	});
});


function listarComentariosPorAssunto(assunto){
	$.getJSON("/comente-sobre/listar/" + assunto,function(comentarios){
		preencherGrid(comentarios.list);
	});
}

function preencherGrid(data){
	grid.children("tbody").remove();
	var html = "";
	for(var i = 0, qtde = data.length;i<qtde;i++){
		html += '<tr>';
		html += '<td>' + data[i].autor.email + '</td>';
		html += '<td>' + data[i].descricao + '</td>';
		html += '</tr>';
	}
 	grid.append(html);
}