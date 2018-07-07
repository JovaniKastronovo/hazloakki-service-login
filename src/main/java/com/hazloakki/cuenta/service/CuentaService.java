package com.hazloakki.cuenta.service;

import com.hazloakki.cuenta.entity.CuentaEntity;
import com.hazloakki.cuenta.modelo.CuentaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface CuentaService {

	CuentaEntity guardarCuenta(CuentaDto cuentaDto);

	CuentaEntity obtenerCuenta(String idCuenta);

	CuentaEntity modificarCuenta(CuentaDto cuentaDto);
}
