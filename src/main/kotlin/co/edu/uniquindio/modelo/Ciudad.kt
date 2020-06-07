package co.edu.uniquindio.modelo

class Ciudad(
    id: Int,
    val nombre: String,
    val pais: Pais
) : Entidad(id) {
    constructor(nombre: String, pais: Pais) : this(-1, nombre, pais)
}