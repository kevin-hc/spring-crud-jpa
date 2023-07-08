package com.springboot.CRUD.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.springboot.CRUD.models.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext// para inyectar el entity manager
	private EntityManager em;// El EntityManager proporciona métodos para realizar operaciones de persistencia en la base de datos, como guardar, actualizar, eliminar y consultar entidades.

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
