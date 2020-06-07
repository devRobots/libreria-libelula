package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

class Pedido (
    id: Int,
    val fechaPedido: Date,
    val empleado: Empleado,
    val proveedor: Proveedor,
    val libros: ArrayList<Libro> = ArrayList()
) : Entidad(id)