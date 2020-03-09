import dao.MovimientosDao
import dao.RegistroMovimiento
import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val ListaMovimientos = mutableListOf(MovimientosDto(1,510000, LocalDate.parse("2019-12-28", formatter)))
    ListaMovimientos.add(MovimientosDto(2,-150000, LocalDate.parse("2019-01-10", formatter)))
    ListaMovimientos.add(MovimientosDto(3,2400, LocalDate.parse("2020-02-18", formatter)))
    ListaMovimientos.add(MovimientosDto(4,3500000, LocalDate.parse("2020-02-18", formatter)))
    ListaMovimientos.add(MovimientosDto(5,-7000, LocalDate.parse("2019-05-30", formatter)))

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
            println("|6 = Consultar movimientos mayores a 500000           |")
            println("|7 = Mostrar todos los movimientos                    |")
            println("|8 = Finalizar consultas                              |")
            println("-------------------------------------------------------")
            print("Ingrese su opción -> ")
            var opcion = readLine()?.toInt() as Int
            when (opcion){
                1 -> ListaMovimientos.add(RegistroMovimiento().registrarMovimiento()[0])
                2 -> MovimientosDao().GetMovimientoMasAltoUltimoAno(ListaMovimientos)
                3 -> MovimientosDao().GetUltimosTresMovimientos(ListaMovimientos)
                4 -> println("Opcion 4")
                5 -> println("Opcion 5")
                6 -> MovimientosDao().GetMovimientosMayoresAUnMonto(ListaMovimientos)
                7 -> MovimientosDao().GetTodosLosMovimientos(ListaMovimientos)
                8 -> validacionConsulta = false
                else -> println("Esta opción seleccionada no es valida")
            }
        } catch (e: Exception) {
            println("Solo se puede elegir la opciones mostradas")
            Thread.sleep(1500)
        }
    }
    println("Gracias por usar este programa de consultas vuelva pronto")
}
