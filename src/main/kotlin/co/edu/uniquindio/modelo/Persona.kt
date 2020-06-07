package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

open class Persona(
    val id: Int,
    val nombre: String,
    val direccion: String?,
    val correo: String,
    val fechaNacimiento: Date,
    val telefonos: ArrayList<Telefono> = ArrayList()
)