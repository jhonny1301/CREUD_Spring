package com.example.crudmysql.repository;

import com.example.crudmysql.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}