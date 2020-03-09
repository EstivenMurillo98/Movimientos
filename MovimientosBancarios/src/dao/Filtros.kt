package dao

import dto.MovimientosDto

interface Filtros {
    fun GetMovimientoMasAltoUltimoAño(listaMovimientos: List<MovimientosDto>);
    fun GetUltimosTresMovimientos(listaMovimientos: List<MovimientosDto>);
    fun GetMovimeintosNegativo(): Map<Int, Int>
}