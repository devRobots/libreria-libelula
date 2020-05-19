package co.edu.uniquindio.modelo

import java.util.*
import kotlin.collections.ArrayList

open class Persona(
    protected val id: Int,
    protected val nombre: String,
    protected val direccion: String?,
    protected val correo: String,
    protected val fechaNacimiento: Date,
    protected val telefonos: ArrayList<Telefono> = ArrayList()
)