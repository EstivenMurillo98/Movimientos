package co.com

import co.com.dto.MovimientosDto

interface IFilters {
    fun GetMaxMount(): List<MovimientosDto>;
    fun GetMovimeintoNegativo(): Map<Int, Int>
}