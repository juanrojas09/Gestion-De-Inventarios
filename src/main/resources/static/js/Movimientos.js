//llamo a las tablas con jquery
$(document).ready(function () {
    cargarMovimientos();
$('#movimientos').DataTable();




});

async function cargarMovimientos(){

    const request=await fetch('api/movimientos',{
        method:'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        }

    });
    const movimientos = await request.json();

    let lista=''

    for(let movimiento of movimientos){

let eliminar='<a href="#" onclick="eliminarMovimiento(' + movimiento.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fa fa-trash"></i></a>'
        let html='<tr><td>'+movimiento.id+'</td><td>'+movimiento.concepto+'</td><td> $'+movimiento.monto+'</td><td> '+movimiento.fecha+'</td><td> '+movimiento.tipo+'</td><td>'+eliminar+'</td></tr>';
        lista+=html;

}
    document.querySelector('#movimientos tbody').outerHTML=lista;
    let lista1='';
    for(let mov of movimientos){
        let a=0;
        let html='';
        console.log(mov.tipo)

        if(mov.tipo==='Ingreso'){
            a-=mov.monto;
            console.log(a)
            html='\<td> $'+a+'</td>';
            lista1-=a;



        }else{
            if(mov.tipo==='Egreso'){
                a+=mov.monto;
                console.log(a)
                html='\<td> $'+a+'</td>';
              lista1-=a;
            }
        }




    }
    document.querySelector('#card1 p').outerHTML='$'+lista1;
}

async function eliminarMovimiento(id){
    if(!confirm("quiere eliminar el movimiento?")){
        return;
    }
    const request = await fetch('eliminar/'+id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization':localStorage.token
        }

    });
location.reload();
}