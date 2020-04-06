package dao

import dto.MovimientosDto
import java.lang.StrictMath.abs

class MovimientosDao : Filtros {

    override fun GetMovimientoMasAltoUltimoAno(listaMovimientos: List<MovimientosDto>) : MovimientosDto {
        println("Su movimiento más alto en el ultimo año es: ")
        return listaMovimientos.sortedByDescending { it.fecha.year == 2020 }.maxBy { it.monto }!!
    }

    override fun GetUltimosTresMovimientos(listaMovimientos : List<MovimientosDto>) : List<MovimientosDto> {
        println("Sus ultimos tres movimientos son: ")
        return listaMovimientos.takeLast(3)
    }

    override fun GetPromedioMovimientos(listaMovimientos : List<MovimientosDto>): MutableMap<String, List<MovimientosDto>> {
        val mapaDeMovimientos = mutableMapOf<String, List<MovimientosDto>>()
        mapaDeMovimientos["negativas"] = listaMovimientos.filter { it.monto < 0 }
        mapaDeMovimientos["positivas"] = listaMovimientos.filter { it.monto >= 0 }
        return mapaDeMovimientos
    }

    override fun GetMovimientosMayoresAUnMonto(listaMovimientos : List<MovimientosDto>) : List<MovimientosDto> {
        println("Sus movimientos mayores a 500000 son: ")
        return listaMovimientos.filter { abs(it.monto) >= 500000 }
    }

    override fun GetTodosLosMovimientos(listaMovimientos : List<MovimientosDto>) : List<MovimientosDto> {
        println("Sus movimientos son: ")
        return listaMovimientos
    }
}