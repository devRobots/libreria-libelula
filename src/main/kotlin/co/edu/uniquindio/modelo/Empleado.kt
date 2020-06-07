package co.edu.uniquindio.modelo

import java.util.*

class Empleado(
    cedula: Int,
    nombre: String,
    direccion: String?,
    correo: String,
    fechaNacimiento: Date,
    cargo: Cargo
) : Persona(cedula, nombre, direccion, correo, fechaNacimiento)