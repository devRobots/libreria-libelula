package co.edu.uniquindio.modelo

class Categoria(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val libros: ArrayList<Libro> = ArrayList()
) {
    constructor(nombre: String, descripcion: String) : this(-1, nombre, descripcion)
}