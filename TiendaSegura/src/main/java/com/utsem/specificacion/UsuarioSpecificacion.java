package com.utsem.specificacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.utsem.DTO.FiltrosUsuarioDTO;
import com.utsem.model.Usuario;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UsuarioSpecificacion implements Specification<Usuario> {
	
	private static final long serialVersionUID = -1941033314937557860L;
	FiltrosUsuarioDTO filtros=new FiltrosUsuarioDTO();
	

	public UsuarioSpecificacion(FiltrosUsuarioDTO filtros) {
		super();
		this.filtros = filtros;
	}


	@Override
	public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> CriteriaQuery, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub`
		List<Predicate> predicadosTexto = new ArrayList<>();
		List<Predicate> predicadosFinal = new ArrayList<>();
		

        if (filtros.getTexto().equals("")) {
            predicadosTexto.add(criteriaBuilder.like
            		(root.get("nombre"), "%" + filtros.getTexto()+"%"));
            predicadosTexto.add(criteriaBuilder.like
            		(root.get("paterno"), "%" + filtros.getTexto()+"%"));
            predicadosTexto.add(criteriaBuilder.like
            		(root.get("materno"), "%" + filtros.getTexto()+"%"));
            predicadosFinal.add(criteriaBuilder.or
            		(predicadosTexto.toArray(new Predicate[predicadosTexto.size()])));
        }
        
        if(!filtros.getRol().equals("")) {
        	predicadosFinal.add(criteriaBuilder.equal
        			(root.get("rol_id"), filtros.getRol()));
        }
        if(!filtros.getEstdo().equals("")) {
        	predicadosFinal.add(criteriaBuilder.equal
        			(root.get("estatus"), filtros.getEstdo()));
        }
        if(predicadosFinal.size()>0) return criteriaBuilder.and(
        		predicadosFinal.toArray(new Predicate[predicadosFinal.size()]));
        
        
		return null;
	}
	
	
}
