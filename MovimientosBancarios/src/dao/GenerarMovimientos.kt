package dao

import dto.MovimientosDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.concurrent.ThreadLocalRandom

class GenerarMovimientos {
    fun crearMovimientosAleatoreos(numero : Int) : MutableList<MovimientosDto> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val listaMovimientos = mutableListOf<MovimientosDto>()
        for (i in 1..numero){
            val anio = ThreadLocalRandom.current().nextInt(2018, 2020).toString()
            var mes = ThreadLocalRandom.current().nextInt(1, 12).toString()
            mes = (if (mes.length < 2){ "0$mes"} else { mes }).toString()
            var dia = ThreadLocalRandom.current().nextInt(1, 31).toString()
            dia = (if (dia.length < 2){ "0$dia"} else { dia }).toString()
            listaMovimientos.add(
                        MovimientosDto(
                            listaMovimientos.size+1,
                            ThreadLocalRandom.current().nextInt(-1000000, 1000000),
                            LocalDate.parse("$anio-$mes-$dia", formatter)
                        )

            )
        }
        return listaMovimientos
    }
}