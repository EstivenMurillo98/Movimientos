package dao

import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistroMovimiento {

    fun registrarMovimiento(): MutableList<MovimientosDto> {
        val listaMovimientos = mutableListOf<MovimientosDto>()
        try {
            listaMovimientos.add(MovimientosDto(registroId(), registroMonto(), registroFecha()))
            loop@ while (true){
                println("-----------------------------------")
                println("|Deseas ingresar otro movimiento? |")
                println("-----------------------------------")
                println("|             1 - Si              |")
                println("|             2 - No              |")
                println("-----------------------------------")
                print("-> ")
                when(readLine()?.toInt() as Int){
                    1 -> listaMovimientos.add(MovimientosDto(registroId(), registroMonto(), registroFecha()))
                    2 -> break@loop
                    else -> println("Esta opción no es valida")
                }
            }
        } catch (e: Exception) {
            println("Tiene que ser un valor numerico mayor a cero")
        }
        return listaMovimientos
    }

    private fun registroId() : Int {
        while (true){
            try {
                println("---------------------------------")
                println("|Ingrese el id de la transacción|")
                println("---------------------------------")
                print("-> ")
                return readLine()?.toInt() as Int
            } catch (e: Exception) {
                println("Tiene que ser un valor numerico mayor a cero")
            }
        }
    }

    private fun registroMonto() : Int {
        while (true){
            try {
                println("------------------------------------")
                println("|Ingrese el monto de la transacción|")
                println("------------------------------------")
                print("-> ")
                return readLine()?.toInt() as Int
            } catch (e: Exception) {
                println("Tiene que ser un valor numerico mayor a cero")
            }
        }
    }

    private fun registroFecha() : LocalDate {
        while (true){
            try {
                println("----------------------------------")
                println("|Ingrese el año de la transacción|")
                println("----------------------------------")
                print("-> ")
                val ano = readLine() as String
                println("----------------------------------")
                println("|Ingrese el mes de la transacción|")
                println("----------------------------------")
                print("-> ")
                val mes = readLine() as String
                println("----------------------------------")
                println("|Ingrese el día de la transacción|")
                println("----------------------------------")
                print("-> ")
                val dia = readLine() as String
                val date = "$ano-$mes-$dia"
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                return LocalDate.parse(date, formatter)
            } catch (e: Exception) {
                println("La fecha ingresada no es correcta")
            }
        }
    }
}