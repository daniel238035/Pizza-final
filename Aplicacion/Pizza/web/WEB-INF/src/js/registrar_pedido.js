

$(document).ready(function(){
    $('.correcto').css({
      "display": "block"
    });
   $('.correcto').fadeOut(2000);    
});

function calcular_vuelto (){
  var r1 = document.getElementById("efectivo").value;
  var r2 = document.getElementById("importe").value;


  if (isNaN(parseFloat(document.getElementById('importe').value))) {
        alert("Indique el Monto");
        document.getElementById("importe").innerText = "0";
        document.getElementById("importe").focus();
      } else if (isNaN(parseFloat(document.getElementById('efectivo').value))) {
        alert("Indique el Efectivo");
        document.getElementById("efectivo").innerText = "0";
        document.getElementById("efectivo").focus();
      }
  else if (parseInt(r1) >= parseInt(r2)) {
    resul = parseFloat(r1) - parseFloat(r2);
    var resultado = resul.toFixed(2)
    document.getElementById("vuelto").value = resultado ;

  }else {
    document.getElementById("efectivo").value = 0;
    document.getElementById("efectivo").focus();
  }
}

//CALCULA EL SUBTOTAL Y EL IMPORTE
function calcular_subtotal(){
  var sumatotal=0;
  for (var i = 1; i < 10; i++) {
    var pi = document.getElementById("prec"+i).value;
    var ci = document.getElementById("cant"+i).value;

    var resul= pi * parseInt(ci);
    var resultado = resul.toFixed(2);
    document.getElementById("sub"+i).value = resultado;
    sumatotal = parseFloat(sumatotal)+parseFloat(resultado);
  }
  var resul = sumatotal.toFixed(2);
  document.getElementById("importe").value = resul;
}

//function validarSiNumero(numero){
//    if (!/^([0-9])*$/.test(numero))
//      alert("El valor " + numero + " no es un número");
//  }
