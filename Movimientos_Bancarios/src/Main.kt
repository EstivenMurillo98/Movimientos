import co.com.dao.MovimientosDao
import co.com.dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun main() {
    var id: Int = 0
    var monto: Int = 0
    //var fecha: Date

    println("Ingrese el id de la transaccion")

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
        println("Ingrese el monto de la transaccion")
        try {
            monto = readLine()?.toInt() as Int
            validacionMonto = false
        } catch (e: Exception) {
            println("Tiene que ser un valor numerico mayor a cero")
        }
    }

    val string = "2020-03-02"
    val date = LocalDate.parse(string, DateTimeFormatter.ISO_DATE)
    println(date)

    //val fechas: Date = date

    val ListaMovimientos = mutableListOf(MovimientosDto(id, monto as Int,  Calendar.getInstance().time))
    println(ListaMovimientos)

    val move = MovimientosDao(ListaMovimientos).GetMaxMount()
    //move.GetMaxMount()
}