package dao

import dto.MovimientosDto

class ImprimirConsultas {

    fun imprimirMovimiento(movimiento: MovimientosDto){
        println("ID: ${movimiento.id}  Monto:  ${movimiento.monto}  Fecha: ${movimiento.fecha}")
        Thread.sleep(2000)
    }

    fun imprimirMovimientos(movimientos : List<MovimientosDto>){
        movimientos.forEach { println("ID: ${it.id}  Monto:  ${it.monto}  Fecha: ${it.fecha}") }
        Thread.sleep(2000)
    }

    fun imprimirPromedios(promedioMovimientos: MutableMap<String, List<MovimientosDto>>) {
        print("El promedio de las transacciones negativas es: ")
        println((promedioMovimientos["negativas"] as List<MovimientosDto>).map { it.monto }.average())
        print("El promedio de las transacciones positivas es: ")
        println((promedioMovimientos["positivas"] as List<MovimientosDto>).map { it.monto }.average())
        Thread.sleep(2000)
    }

    fun imprimirIdMontos(movimientos : List<MovimientosDto>){
        movimientos.forEach { println("ID: ${it.id}") }
        Thread.sleep(2000)
    }

}