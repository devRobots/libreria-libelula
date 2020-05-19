package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

class Proveedor(
    idProveedor: Int,
    nombre: String,
    direccion: String,
    correo: String,
    fechaNacimiento: Date,
    val libros: ArrayList<Libro> = ArrayList(),
    val pedidos: ArrayList<Pedido> = ArrayList()
): Persona(idProveedor, nombre, direccion, correo, fechaNacimiento)