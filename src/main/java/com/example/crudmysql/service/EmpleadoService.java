package com.example.crudmysql.service;

import com.example.crudmysql.Model.Empleado;
import com.example.crudmysql.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado updateEmpleado(Long id, Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        empleado.setNombre(empleadoDetails.getNombre());
        empleado.setApellido(empleadoDetails.getApellido());
        empleado.setEmail(empleadoDetails.getEmail());
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
