package dto

import java.time.LocalDate

data class MovimientosDto(
    val id: Int,
    val monto: Int,
    val fecha: LocalDate
)