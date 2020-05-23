package co.edu.uniquindio.modelo

class Pais(
    val id: Int,
    val nombre: String,
    val ciudades: List<Ciudad> = ArrayList()
) {
    constructor(nombre: String): this(-1, nombre)
}