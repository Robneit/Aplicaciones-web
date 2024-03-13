package com.utsem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.utsem.model.Usuario;
import java.util.Optional;
import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
		
	Optional<Usuario> findByUsernameAndPassword(String username, String password);
	
	List<Usuario> findByNombreContainsOrPaternoContainsOrMaternoContains
	(String nombre, String paterno, String materno);

}
