package co.edu.uniquindio.modelo

class Categoria(
    id: Int,
    val nombre: String,
    val descripcion: String
) : Entidad(id) {
    constructor(nombre: String, descripcion: String) : this(-1, nombre, descripcion)
}