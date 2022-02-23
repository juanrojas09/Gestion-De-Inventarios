
package com.proyectojava.proyecto.controllers;

import com.proyectojava.proyecto.dao.MontoDao;
import com.proyectojava.proyecto.models.Movimientos;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@RestController
public class montoController  {

  @Autowired
  private MontoDao montoDao;

  @RequestMapping(value="movimiento")
    public  Movimientos getMovimiento() {
    java.util.Date fechaActual = new java.util.Date();
      Movimientos movimiento= new Movimientos();
      movimiento.setConcepto("compra de ropa");
      movimiento.setMonto(1500.00);

      return movimiento;


    }

  @RequestMapping(value="api/movimientos",method=RequestMethod.GET)
  public List<Movimientos>  getMovimientos() {
   return montoDao.getMovimientos();




  }

  @RequestMapping(value="api/movimientos/{id}",method=RequestMethod.GET)
  public List<Movimientos>  getMovimiento(@PathVariable("id") Long id) {
    return montoDao.getMovimiento(id);




  }
  @RequestMapping(value="api/movimientos",method=RequestMethod.POST)
  public void registrarMovimiento(@RequestBody Movimientos movimiento){
montoDao.registrarMovimientos(movimiento);
  }

  @RequestMapping(value="eliminar/{id}")
  public void eliminar(@PathVariable("id") Long id){

     montoDao.eliminar(id);
  }



  @RequestMapping(value="modificar/{id}",method=RequestMethod.PUT)
  public void modificar(@PathVariable("id") Long id,String concepto,Double monto) {

montoDao.modificar(id,concepto,monto);

  }


}
