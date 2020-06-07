package co.edu.uniquindio.modelo

class Pais(
    id: Int,
    val nombre: String,
    val ciudades: List<Ciudad> = ArrayList()
) : Entidad(id) {
    constructor(nombre: String): this(-1, nombre)
}