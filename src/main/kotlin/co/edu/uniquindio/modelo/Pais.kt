package co.edu.uniquindio.modelo

class Pais(
    id: Int,
    val nombre: String
) : Entidad(id) {
    constructor(nombre: String): this(-1, nombre)
}