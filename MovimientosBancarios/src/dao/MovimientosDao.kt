package dao

import dto.MovimientosDto

class MovimientosDao : Filtros {


    override fun GetMovimientoMasAltoUltimoAño(listaMovimientos: List<MovimientosDto>) {
        val movimiento = listaMovimientos.sortedByDescending { it.fecha }.sortedByDescending { it.monto }.take(1)
        println("Su movimiento mas alto es:")
        println("ID: " + movimiento[0].id + " Monto: " + movimiento[0].monto + " Fecha: " + movimiento[0].fecha)
        Thread.sleep(2000)
    }

    override fun GetUltimosTresMovimientos(listaMovimientos: List<MovimientosDto>){
        listaMovimientos.takeLast(3).forEach {
            println("ID: " + it.id + " Monto: " + it.monto + " Fecha: " + it.fecha)
        }
        Thread.sleep(2000)
    }

    override fun GetMovimeintosNegativo(): Map<Int, Int> {
        TODO("Not yet implemented")
    }
}