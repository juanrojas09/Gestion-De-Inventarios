package com.proyectojava.proyecto.dao;
import com.proyectojava.proyecto.models.Movimientos;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
public interface MontoDao {


    @Transactional
    List<Movimientos> getMovimientos();
    List<Movimientos> getMovimiento(Long id);

    void eliminar (Long id);

    void registrarMovimientos(Movimientos movimiento);

    void modificar(Long id,String concepto,Double monto);





}
