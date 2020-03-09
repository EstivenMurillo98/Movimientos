package dao

import dto.MovimientosDto

interface Filtros {
    fun GetMovimientoMasAltoUltimoAno(listaMovimientos: List<MovimientosDto>);
    fun GetUltimosTresMovimientos(listaMovimientos: List<MovimientosDto>);
    fun GetMovimientosMayoresAUnMonto(listaMovimientos: List<MovimientosDto>);
    fun GetMovimeintosPositivos(): Map<Int, Int>
    fun GetMovimeintosNegativos(): Map<Int, Int>
    fun GetTodosLosMovimientos(listaMovimientos: List<MovimientosDto>)
}