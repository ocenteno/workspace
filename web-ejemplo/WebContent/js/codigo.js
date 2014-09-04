// Ya que el c�digo est� separado (en otro fichero fuera del HTML)
// Lo voy a separar todo
// Y voy a poner los eventos desde aqu�

function testAjax() {
	ajax = new XMLHttpRequest();
	// abro conexi�n
	ajax.open(
			"POST", 
			"http://localhost:8080/web-ejemplo/rest/adios/Oliver", 
			true);
	// tengo que preparar la respuesta
	ajax.onreadystatechange = responder;
	// tengo que hacer la petici�n
	ajax.send();
}

function responder(){
	if (ajax.readyState == 4 && ajax.status == 200) {
		var resultado = ajax.responseText;
		alert(resultado);
	}
}

// me invento una funci�n main
function main(){
	// Aqu� voy a enlazar todos los eventos
	var boton1 = document.getElementById("probarAJAX");
	boton1.onclick = testAjax;
}
// la funci�n main se va a ejecutar cuando se cargue la p�gina
window.onload = main;

