package dao

import dto.MovimientosDto

class MovimientosDao : Filtros {

    override fun GetMovimientoMasAltoUltimoAno(listaMovimientos: List<MovimientosDto>) {
        println("Su movimiento mas altos en el ultimo año son: ")
        listaMovimientos.sortedByDescending { it.fecha }.sortedByDescending { it.monto }.take(1)
            .forEach {
                println("ID: " + it.id + " Monto: " + it.monto + " Fecha: " + it.fecha)
            }
        Thread.sleep(2000)
    }

    override fun GetUltimosTresMovimientos(listaMovimientos : List<MovimientosDto>){
        println("Sus ultimos tres movimientos son: ")
        listaMovimientos.takeLast(3).forEach {
            println("ID: " + it.id + " Monto: " + it.monto + " Fecha: " + it.fecha)
        }
        Thread.sleep(2000)
    }

    override fun GetMovimeintosPositivos() : Map<Int, Int> {
        println("Disponible proximamente")
        return GetMovimeintosPositivos()
    }

    override fun GetMovimeintosNegativos() : Map<Int, Int> {
        println("Disponible proximamente")
        return GetMovimeintosNegativos()
    }

    override fun GetMovimientosMayoresAUnMonto(listaMovimientos : List<MovimientosDto>) {
        println("Sus movimientos mayores a 500000 son: ")
        listaMovimientos.filter { it.monto >= 500000 }.forEach { println("ID: " + it.id) }
        Thread.sleep(2000)
    }

    override fun GetTodosLosMovimientos(listaMovimientos : List<MovimientosDto>) {
        println("Sus movimientos son: ")
        listaMovimientos.forEach {
            println("ID: " + it.id + " Monto: " + it.monto + " Fecha: " + it.fecha)
        }
        Thread.sleep(2000)
    }
}