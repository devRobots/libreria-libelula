package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

class Cliente(
    cedula: Int,
    nombre: String,
    direccion: String?,
    correo: String,
    fechaNacimiento: Date,
    val compras: ArrayList<Venta> = ArrayList(),
    val autoresFavoritos: ArrayList<Autor> = ArrayList()
): Persona(cedula, nombre, direccion, correo, fechaNacimiento)