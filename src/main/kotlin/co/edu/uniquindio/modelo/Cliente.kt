package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

class Cliente(
    id: Int,
    nombre: String,
    direccion: String?,
    correo: String,
    fechaNacimiento: Date,
    val compras: ArrayList<Venta> = ArrayList(),
    val autoresFavoritos: ArrayList<Autor> = ArrayList()
): Persona(id, nombre, direccion, correo, fechaNacimiento)