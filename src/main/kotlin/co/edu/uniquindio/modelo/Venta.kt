package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

class Venta(
    id: Int,
    val fechaVenta: Date,
    val cliente: Cliente,
    val empleado: Empleado,
    val libros: ArrayList<Libro> = ArrayList()
) : Entidad(id)