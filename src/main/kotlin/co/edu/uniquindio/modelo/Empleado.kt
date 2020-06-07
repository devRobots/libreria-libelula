package co.edu.uniquindio.modelo

import java.util.*

class Empleado(
    id: Int,
    nombre: String,
    direccion: String?,
    correo: String,
    fechaNacimiento: Date,
    cargo: Cargo
) : Persona(id, nombre, direccion, correo, fechaNacimiento)