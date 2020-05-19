package co.edu.uniquindio.modelo

import java.util.*

class Empleado(
    val codEmpleado: Int,
    cedula: Int,
    nombre: String,
    direccion: String?,
    correo: String,
    fechaNacimiento: Date,
    val cargo: Cargo
) : Persona(cedula, nombre, direccion, correo, fechaNacimiento)