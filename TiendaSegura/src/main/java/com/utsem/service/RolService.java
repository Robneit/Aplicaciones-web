package com.utsem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsem.DTO.RolDTO;
import com.utsem.Repository.RolRepository;

@Service
public class RolService {
	@Autowired
	RolRepository rolRepository;
	@Autowired
	ModelMapper mapper;

	public List<RolDTO> listar() {
		return rolRepository.findAll().stream()
		.map(rol->mapper.map(rol, RolDTO.class))
		.collect(Collectors.toList());
	}
}
