package dao

import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistroMovimiento {

    fun registrarMovimiento(): MutableList<MovimientosDto> {
        return mutableListOf(MovimientosDto(registroId(), registroMonto(), registroFecha()))
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