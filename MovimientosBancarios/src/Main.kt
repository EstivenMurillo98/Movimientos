import dao.ImprimirConsultas
import dao.MovimientosDao
import dao.RegistroMovimiento
import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    //Creacion de una lista para las consultas iniciales sin crear movimientos
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val listaMovimientos = mutableListOf(MovimientosDto(1,510000, LocalDate.parse("2019-12-28", formatter)))
    listaMovimientos.add(MovimientosDto(2,-150000, LocalDate.parse("2019-01-10", formatter)))
    listaMovimientos.add(MovimientosDto(3,2400, LocalDate.parse("2020-02-18", formatter)))
    listaMovimientos.add(MovimientosDto(4,3500000, LocalDate.parse("2020-02-18", formatter)))
    listaMovimientos.add(MovimientosDto(5,-7000, LocalDate.parse("2019-05-30", formatter)))

    val movimientosDao = MovimientosDao()
    val imprimirConsultas = ImprimirConsultas()
    loop@ while (true){
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
                2 -> imprimirConsultas.imprimirMovimiento(movimientosDao.GetMovimientoMasAltoUltimoAno(listaMovimientos))
                3 -> imprimirConsultas.imprimirMovimientos(movimientosDao.GetUltimosTresMovimientos(listaMovimientos))
                4 -> imprimirConsultas.imprimirPromedios(movimientosDao.GetPromedioMovimientos(listaMovimientos))
                5 -> imprimirConsultas.imprimirIdMontos(movimientosDao.GetMovimientosMayoresAUnMonto(listaMovimientos))
                6 -> imprimirConsultas.imprimirMovimientos(movimientosDao.GetTodosLosMovimientos(listaMovimientos))
                7 -> break@loop
                else -> println("Esta opción seleccionada no es valida")
            }
        } catch (e: Exception) {
            println("Solo se puede elegir una de las opciones mostradas")
            Thread.sleep(1500)
        }
    }
    println("Gracias por usar este programa de consultas vuelva pronto")
}
