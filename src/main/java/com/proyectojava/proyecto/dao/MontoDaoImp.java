package com.proyectojava.proyecto.dao;

import com.proyectojava.proyecto.models.Movimientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class MontoDaoImp  implements MontoDao{

    @PersistenceContext(type= PersistenceContextType.EXTENDED)
  private EntityManager em;



    @Override
    @Transactional
    public List<Movimientos> getMovimientos() {
        String query="FROM Movimientos";
        return em.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public List<Movimientos> getMovimiento(Long id) {
        Query query=em.createQuery("FROM Movimientos m where m.id=:id ");
         return query.setParameter("id",id).getResultList();
    }
    @Override
    @Transactional
    public void eliminar(Long id) {
      Query query=em.createQuery("DELETE FROM Movimientos m where m.id=:id");
        query.setParameter("id",id).executeUpdate();




    }

  @Override
 //metodo para el post, donde hago merge a la bd de los datos ingresados del lado del cliente.
  public void registrarMovimientos(Movimientos movimiento) {
    em.merge(movimiento);
  }

  @Modifying

  public void modificar(@Param(value="id") Long id,@Param(value="concepto") String concepto,@Param(value="monto") Double monto){
    Query query=em.createQuery("update Movimientos m set m.concepto = :concepto ,m.monto= :monto where m.id = :id");
    query.setParameter("id",id).executeUpdate();
    query.setParameter("concepto",concepto).executeUpdate();
    query.setParameter("monto",monto).executeUpdate();









    //metodo viejo
    //public void modificar(Long id,String concepto,Double monto) {

     /* Query query=em.createQuery("UPDATE Movimientos m " +
              "SET m.concepto = :concepto , m.monto = :monto " +
              "where m.id= :id " );

      query.setParameter("concepto",concepto).executeUpdate();
      query.setParameter( "monto",monto).executeUpdate();
      query.setParameter("id",id).executeUpdate();*/






    }

    }



