package com.hazloakki.cuenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.cuenta.api.CuentaException;
import com.hazloakki.cuenta.entity.CuentaEntity;
import com.hazloakki.cuenta.modelo.CuentaDto;
import com.hazloakki.cuenta.repository.CuentaRepository;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public CuentaEntity guardarCuenta(CuentaDto cuentaDto) {
		CuentaEntity cuentaEntity = CuentaEntity.from(cuentaDto);
		return cuentaRepository.save(cuentaEntity);
	}

	@Override
	public CuentaEntity obtenerCuenta(String idCuenta) {
		return cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> CuentaException.from("No se encontro la cuenta : '%s'", idCuenta));
	}

	@Override
	public CuentaEntity modificarCuenta(CuentaDto cuentaDto) {

		CuentaEntity cuentaOptional = cuentaRepository.findById(String.valueOf(cuentaDto.getIdCuenta())).orElseThrow(
				() -> CuentaException.from("No se encontro la cuenta : '%s'", String.valueOf(cuentaDto.getIdCuenta())));

		cuentaOptional.setId(cuentaDto.getIdCuenta());

		return cuentaRepository.save(cuentaOptional);

	}

}
