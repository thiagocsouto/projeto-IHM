function GerarMatricula(){
	var txt = "F";
	var aleatorio = Math.floor(Math.random() * 20000);
	document.getElementById('matricula').value = (txt + 0 + 0 + aleatorio);
}

