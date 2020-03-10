import dao.MovimientosDao
import dao.RegistroMovimiento
import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val listaMovimientos = mutableListOf(MovimientosDto(1,510000, LocalDate.parse("2019-12-28", formatter)))
    listaMovimientos.add(MovimientosDto(2,-150000, LocalDate.parse("2019-01-10", formatter)))
    listaMovimientos.add(MovimientosDto(3,2400, LocalDate.parse("2020-02-18", formatter)))
    listaMovimientos.add(MovimientosDto(4,3500000, LocalDate.parse("2020-02-18", formatter)))
    listaMovimientos.add(MovimientosDto(5,-7000, LocalDate.parse("2019-05-30", formatter)))

    var validacionConsulta = true
    while (validacionConsulta){
        try {
            println("-----------------------------------------------------------------")
            println("|     Seleccione el numero de la opción que desea realizar      |")
            println("-----------------------------------------------------------------")
            println("|1 = Agregar un nuevo movimiento                                |")
            println("|2 = Consultar movimiento mas alto en el ultimo año             |")
            println("|3 = Consultar los ultimo 3 movimientos realizados              |")
            println("|4 = Consultar promedio de movimientos positivas y negativos    |")
            println("|5 = Consultar movimientos mayores a 500000                     |")
            println("|6 = Mostrar todos los movimientos                              |")
            println("|7 = Finalizar consultas                                        |")
            println("-----------------------------------------------------------------")
            print("Ingrese su opción -> ")
            when (readLine()?.toInt() as Int){
                1 -> listaMovimientos.add(RegistroMovimiento().registrarMovimiento()[0])
                2 -> imprimirMovimiento(MovimientosDao().GetMovimientoMasAltoUltimoAno(listaMovimientos))
                3 -> imprimirMovimientos(MovimientosDao().GetUltimosTresMovimientos(listaMovimientos))
                4 -> imprimirPromedios(MovimientosDao().GetPromedioMovimientos(listaMovimientos))
                5 -> imprimirIdMontos(MovimientosDao().GetMovimientosMayoresAUnMonto(listaMovimientos))
                6 -> imprimirMovimientos(MovimientosDao().GetTodosLosMovimientos(listaMovimientos))
                7 -> validacionConsulta = false
                else -> println("Esta opción seleccionada no es valida")
            }
        } catch (e: Exception) {
            println("Solo se puede elegir la opciones mostradas")
            Thread.sleep(1500)
        }
    }
    println("Gracias por usar este programa de consultas vuelva pronto")
}

fun imprimirMovimientos(movimientos : List<MovimientosDto>){
    movimientos.forEach { println("ID: ${it.id}  Monto:  ${it.monto}  Fecha: ${it.fecha}") }
    Thread.sleep(2000)
}

fun imprimirMovimiento(movimiento: MovimientosDto){
    println("ID: ${movimiento.id}  Monto:  ${movimiento.monto}  Fecha: ${movimiento.fecha}")
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
