

let Logeado;

$.ajax({
  url: "http://localhost:8080/api/datos/componente/mother/0",
  type: 'GET'
})
.done(function (data) {

    objeto = new Vue({
      el: '#MostrarMothers',
      data: {
        "componente" : data.componente
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


