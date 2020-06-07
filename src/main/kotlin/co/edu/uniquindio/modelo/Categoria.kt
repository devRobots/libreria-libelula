package co.edu.uniquindio.modelo

class Categoria(
    id: Int,
    val nombre: String,
    val descripcion: String,
    val libros: ArrayList<Libro> = ArrayList()
) : Entidad(id) {
    constructor(nombre: String, descripcion: String) : this(-1, nombre, descripcion)
}