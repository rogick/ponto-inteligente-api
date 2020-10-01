package com.rgk.ponto.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rgk.ponto.api.entity.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {
	
	private @Autowired EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "879898789877898";
	
	@Before
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa Exemplo");
		empresa.setCnpj(CNPJ);
		empresaRepository.save(empresa);
	}
	
	@After
	public final void tearDown() {
		empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
		Empresa empresa = empresaRepository.findByCnpj(CNPJ);
		
		assertEquals(CNPJ, empresa.getCnpj());
	}

}
