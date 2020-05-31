package co.edu.uniquindio.modelo

import kotlin.collections.ArrayList

class Proveedor(
    id: Int,
    nombre: String,
    correo: String,
    val libros: ArrayList<Libro> = ArrayList(),
    val pedidos: ArrayList<Pedido> = ArrayList()
)