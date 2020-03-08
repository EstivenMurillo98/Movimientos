package dao

import dto.MovimientosDto

class MovimientosDao : Filtros {

    lateinit var movimientos : List<MovimientosDto>
    constructor(movimientos : List<MovimientosDto>)
    {
        this.movimientos = movimientos
    }

    override fun GetMontoMaximo(): List<MovimientosDto> {
        print("acá están tus movimeintos")
        return movimientos
    }

    override fun GetMovimeintosNegativo(): Map<Int, Int> {
        TODO("Not yet implemented")
    }
}