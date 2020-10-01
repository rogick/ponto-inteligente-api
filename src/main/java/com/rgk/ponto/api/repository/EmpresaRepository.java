package com.rgk.ponto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.rgk.ponto.api.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, java.lang.Long> {
	
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
	

}
