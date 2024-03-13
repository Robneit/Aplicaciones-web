package com.utsem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utsem.model.Empleados;

public interface EmpleadoRepository extends JpaRepository<Empleados, Long> {
    // Método para buscar un empleado por su número de empleado
    Empleados findByid(Long id);

}
