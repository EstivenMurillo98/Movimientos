package dao

import dto.MovimientosDto
import java.text.SimpleDateFormat
import java.util.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistroDeMovimientos {

    fun registrarMovimiento(): MutableList<MovimientosDto> {
        var id: Int = 0
        var monto: Int = 0
        var fechaCompleta: LocalDate = LocalDate.MAX
        println("---------------------------------")
        println("|Ingrese el id de la transacción|")
        println("---------------------------------")
        var validacionId = true
        while (validacionId){
            try {
                id = readLine()?.toInt() as Int
                validacionId = false
            } catch (e: Exception) {
                println("Tiene que ser un valor numerico mayor a cero y no en decimal")
            }
        }
        var validacionMonto = true
        while (validacionMonto){
            println("------------------------------------")
            println("|Ingrese el monto de la transacción|")
            println("------------------------------------")
            try {
                monto = readLine()?.toInt() as Int
                validacionMonto = false
            } catch (e: Exception) {
                println("Tiene que ser un valor numerico mayor a cero")
            }
        }

        var validacionfecha = true
        while (validacionfecha){
            try {
                println("Ingrese el año de la transacción")
                val año = readLine()?.toString() as String
                println("Ingrese el mes de la transacción")
                val mes = readLine()?.toString() as String
                println("Ingrese el día de la transacción")
                val dia = readLine()?.toString() as String
                val date = "$año-$mes-$dia"
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                fechaCompleta = LocalDate.parse(date, formatter)
                validacionfecha = false
            } catch (e: Exception) {
                println("La fecha ingresada no es correcta")
            }
        }
        return mutableListOf(MovimientosDto(id, monto, fechaCompleta))
    }


}