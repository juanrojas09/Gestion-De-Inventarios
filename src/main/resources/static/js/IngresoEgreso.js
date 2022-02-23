$(document).ready(function(){
    //registrarMovimiento();


});

async function registrarMovimiento(){
    let datos={}
    datos.concepto=document.getElementById('concepto').value;
    datos.monto=document.getElementById('monto').value;
    datos.tipo=document.getElementById('form').value;
    console.log(datos.tipo)
    const tiempo=Date.now();
    datos.fecha=new Date(tiempo)
    console.log(datos.fecha)


    const request=await fetch('api/movimientos',{
        method:'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(datos)
    });
    alert("movimiento registrado correctamente");
    location.reload()
    const movimientos=await request.json();


}