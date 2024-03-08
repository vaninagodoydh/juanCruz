package com.dh.ClinicMVC.dao.implementacion;

import com.dh.ClinicMVC.dao.BD;
import com.dh.ClinicMVC.dao.IDao;
import com.dh.ClinicMVC.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private static final Logger LOGGER = Logger.getLogger(DomicilioDaoH2.class);

    private static final String INSERT_PACIENTES = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_INGRESO, DOMICILIO_ID) VALUES (?,?,?,?,?)";

    @Override
    public Paciente guardar(Paciente paciente) {
        LOGGER.info("Estamos guardando un paciente");
        Connection connection = null;

        try {
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            domicilioDaoH2.guardar(paciente.getDomicilio());

            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PACIENTES, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, paciente.getDomicilio().getId());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                paciente.setId(rs.getInt(1));
            }
            LOGGER.info("SE CREO EL PACIENTE " + paciente.getId());

        } catch (Exception e) {

        }
        return paciente;
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

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }
}
