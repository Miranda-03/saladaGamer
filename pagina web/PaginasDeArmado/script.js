let usuarioRegistrado;

$.ajax({
  url: "http://localhost:8080/api/datos/componenteActual",
  type: 'GET'
})
.done(function (data) {

    objeto = new Vue({
      el: '#MostrarComponente1',
      data: {
        "componente" : data.componentes
      }
    })

    console.log(data);

    Logeado = false;

})
.fail(function (jqXHR, textStatus, errorThrown) {
  console.log("error, no se pudo obtener datos");
  console.log(jqXHR);
  console.log(textStatus);
  console.log(errorThrown);
});


function marca(marc){
 
        $.ajax({
            url: "http://localhost:8080/api/datos/procesador/" + marc,
            type: 'GET'
          })
          .done(function (data) {
          
              objeto = new Vue({
                el: '#MostrarComponente',
                data: {
                  "componente" : data.componente
                }
              })
          
            

              Logeado = false;
          
          })
          .fail(function (jqXHR, textStatus, errorThrown) {
            console.log("error, no se pudo obtener datos");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
          });

          
          //document.getElementById("div-botones-procesadores").style.display = "none";
          
          window.location.reload();

         
}

let instanciaArmado = 0;
let componente = "";

function agregar(id){
    instanciaArmado = instanciaArmado + 1;
    if(instanciaArmado == 1){
        componente = "procesador";
    }
    else if(instanciaArmado == 2){
      componente = "motherboard";
    }
    else if(instanciaArmado == 3){
      componente ="memoriaRam";
    }
    else if(instanciaArmado == 4){
      componente ="gpu";
    }
    else if(instanciaArmado == 5){
      componente ="fuente";
    }
    else if(instanciaArmado == 6){
      componente ="cooler";
    }

      $.ajax({
        url: "http://localhost:8080/api/datos/componenteElegido/" + componente + "/" + id,
        type: 'GET'
      })
      .done(function (data) {
      
          objeto = new Vue({
            el: '#MostrarComponente',
            data: {
              "componentes" : data.componente
            }
          })
      
          console.log(data);
      
          Logeado = false;
      
      })
      .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo obtener datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
      });

    


      window.location.reload();
}