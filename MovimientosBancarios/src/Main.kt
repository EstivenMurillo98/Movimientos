import dao.RegistroDeMovimientos
import dto.MovimientosDto
import java.util.*

fun main() {
    val ListaMovimientos = mutableListOf(MovimientosDto(1, 5000,  Calendar.getInstance().time))
    ListaMovimientos.add(MovimientosDto(2, -15000,  Calendar.getInstance().time))
    ListaMovimientos.add(MovimientosDto(3, 2500,  Calendar.getInstance().time))
    ListaMovimientos.add(MovimientosDto(4, 40000,  Calendar.getInstance().time))
    ListaMovimientos.add(MovimientosDto(5, -500,  Calendar.getInstance().time))

    var validacionConsulta = true
    while (validacionConsulta){
        try {
            println("-------------------------------------------------------")
            println("|Seleccione el numero de la opción que desea realizar |")
            println("-------------------------------------------------------")
            println("|1 = Agregar un nuevo movimiento                      |")
            println("|2 = Consultar movimientos mas altos en el ultimo año |")
            println("|3 = Consultar los ultimo 3 movimientos realizados    |")
            println("|4 = Consultar promedio de transacciones positivas    |")
            println("|5 = Consultar promedio de transacciones negativas    |")
            println("|6 = Consultar movimientos mayores a 500.000          |")
            println("|7 = Finalizar consultas                              |")
            println("-------------------------------------------------------")
            var opcion = readLine()?.toInt() as Int

            when (opcion){
                1 -> RegistroDeMovimientos().registarMovimiento()
                2 -> println("Opcion 2")
                3 -> println("Opcion 3")
                4 -> println("Opcion 4")
                5 -> println("Opcion 5")
                6 -> println("Opcion 6")
                7 -> validacionConsulta = false
                else -> println("Esta opción seleccionada no es valida")
            }
        } catch (e: Exception) {
            println("Solo se puede elegir la opciones mostradas")
            Thread.sleep(1500)
        }
    }
}