package co.edu.uniquindio.modelo

import java.util.*

class Cliente(
    id: Int,
    nombre: String,
    direccion: String?,
    correo: String,
    fechaNacimiento: Date
): Persona(id, nombre, direccion, correo, fechaNacimiento)