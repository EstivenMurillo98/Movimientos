package co.com.dao

import co.com.IFilters
import co.com.dto.MovimientosDto

class MovimientosDao: IFilters {
    lateinit var movement : List<MovimientosDto>
    constructor(movement : List<MovimientosDto>)
    {
        this.movement = movement
    }

    override fun GetMaxMount(): List<MovimientosDto> {
        print("acá están tus movimeintos malparido")
        return movement
    }

    override fun GetMovimeintoNegativo(): Map<Int, Int> {
        TODO("Not yet implemented")
    }

}