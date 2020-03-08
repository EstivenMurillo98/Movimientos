package dao

import dto.MovimientosDto

interface Filtros {
    fun GetMontoMaximo(): List<MovimientosDto>;
    fun GetMovimeintosNegativo(): Map<Int, Int>
}