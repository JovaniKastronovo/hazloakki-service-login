package com.hazloakki.cuenta.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.cuenta.modelo.CuentaDto;
import com.hazloakki.cuenta.service.CuentaService;


/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
	@Autowired
	private CuentaService cuentaService;
	

	@PostMapping
	@ResponseStatus(CREATED)
	public CuentaDto crearCuenta(@RequestBody CuentaDto cuentaDto) {
		return cuentaService.guardarCuenta(cuentaDto).to();
	}
	
	@GetMapping("/{id}")
	public CuentaDto readCuenta(@PathVariable("id") String idCuenta) {
		return cuentaService.obtenerCuenta(idCuenta).to();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public CuentaDto updateCuenta(@RequestBody CuentaDto cuentaDto) {
		return cuentaService.modificarCuenta(cuentaDto).to();			
	}
	
}
