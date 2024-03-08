package com.dh.ClinicMVC.service.implementation;

import com.dh.ClinicMVC.dao.IDao;
import com.dh.ClinicMVC.dao.implementacion.PacienteDaoH2;
import com.dh.ClinicMVC.model.Paciente;
import com.dh.ClinicMVC.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService() {
        this.pacienteIDao = new PacienteDaoH2();
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Paciente paciente) {

    }
}
