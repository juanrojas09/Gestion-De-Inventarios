$(document).ready(function(){
    Balance();
    $('#movimientos').DataTable();
})

async function Balance(){

    const request=await fetch('api/movimientos',{
        method:'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        }

    });
    const movimientos = await request.json();
let lista='';
    for(let movimiento of movimientos){


        let html='<td> $'+movimiento.monto+'</td>';
     lista+=html;
     console.log(lista);
    }
    document.querySelector('#card1 p').outerHTML=lista;


}