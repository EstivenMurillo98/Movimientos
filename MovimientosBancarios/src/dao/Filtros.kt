package dao

import dto.MovimientosDto

interface Filtros {
    fun GetMovimientoMasAltoUltimoAno(listaMovimientos: List<MovimientosDto>) : MovimientosDto
    fun GetUltimosTresMovimientos(listaMovimientos: List<MovimientosDto>) : List<MovimientosDto>
    fun GetMovimientosMayoresAUnMonto(listaMovimientos: List<MovimientosDto>) : List<MovimientosDto>
    fun GetPromedioMovimientos(listaMovimientos: List<MovimientosDto>): MutableMap<String, List<MovimientosDto>>
    fun GetTodosLosMovimientos(listaMovimientos: List<MovimientosDto>) : List<MovimientosDto>
}