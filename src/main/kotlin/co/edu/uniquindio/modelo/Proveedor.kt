package co.edu.uniquindio.modelo

import kotlin.collections.ArrayList

class Proveedor(
    id: Int,
    val nombre: String,
    val correo: String,
    val libros: ArrayList<Libro> = ArrayList(),
    val pedidos: ArrayList<Pedido> = ArrayList()
) : Entidad(id)