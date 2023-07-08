package com.springboot.CRUD.models.service;

import com.springboot.CRUD.models.dao.IClienteDao;
import com.springboot.CRUD.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired// = autocablado
    private IClienteDao clienteDao;//Inyectamos el objeto clienteDao de tipo IClienteDao para poder usar sus métodos
    @Override
    @Transactional(readOnly = true)//solo lectura
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional//lectura y modificacion
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)//solo lectura
    public Cliente findOne(Long id) {
        return clienteDao.findOne(id);
    }

    @Override
    @Transactional//lectura y modificacion
    public void delete(Long id) {
        clienteDao.delete(id);
    }
}
