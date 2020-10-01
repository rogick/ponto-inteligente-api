package com.rgk.ponto.api.service;

import java.util.Optional;

import com.rgk.ponto.api.entity.Empresa;

public interface EmpresaService {
	
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	Empresa persistir(Empresa empresa);

}
