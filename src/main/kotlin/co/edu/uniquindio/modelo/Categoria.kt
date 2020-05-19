package co.edu.uniquindio.modelo

class Categoria(
    val nombre: String,
    val descripcion: String,
    val libros: ArrayList<Libro> = ArrayList()
)