import dao.MovimientosDao
import dao.RegistroDeMovimientos
import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    println(LocalDate.parse("2020-12-31", formatter))
    val ListaMovimientos = mutableListOf(MovimientosDto(1,5000, LocalDate.parse("2019-12-28", formatter)))
    ListaMovimientos.add(MovimientosDto(2,-1500, LocalDate.parse("2019-01-10", formatter)))
    ListaMovimientos.add(MovimientosDto(3,2400, LocalDate.parse("2020-02-18", formatter)))
    ListaMovimientos.add(MovimientosDto(4,35000, LocalDate.parse("2020-02-18", formatter)))
    ListaMovimientos.add(MovimientosDto(5,-700, LocalDate.parse("2019-05-30", formatter)))

    var validacionConsulta = true
    while (validacionConsulta){
        try {
            println("-------------------------------------------------------")
            println("|Seleccione el numero de la opción que desea realizar |")
            println("-------------------------------------------------------")
            println("|1 = Agregar un nuevo movimiento                      |")
            println("|2 = Consultar movimiento mas alto en el ultimo año   |")
            println("|3 = Consultar los ultimo 3 movimientos realizados    |")
            println("|4 = Consultar promedio de transacciones positivas    |")
            println("|5 = Consultar promedio de transacciones negativas    |")
            println("|6 = Consultar movimientos mayores a 500.000          |")
            println("|7 = Finalizar consultas                              |")
            println("-------------------------------------------------------")
            print("Ingrese opción -> ")
            var opcion = readLine()?.toInt() as Int
            when (opcion){
                1 -> ListaMovimientos.add(RegistroDeMovimientos().registrarMovimiento()[0])
                2 -> MovimientosDao().GetMovimientoMasAltoUltimoAño(ListaMovimientos)
                3 -> MovimientosDao().GetUltimosTresMovimientos(ListaMovimientos)
                4 -> println("Opcion 4")
                5 -> println("Opcion 5")
                6 -> println("Opcion 6")
                7 -> validacionConsulta = false
                8 -> println("Mostrar movimientos")
                else -> println("Esta opción seleccionada no es valida")
            }
        } catch (e: Exception) {
            println("Solo se puede elegir la opciones mostradas")
            Thread.sleep(1500)
        }
    }
}
