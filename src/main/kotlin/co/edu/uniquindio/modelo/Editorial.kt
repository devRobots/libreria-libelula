package co.edu.uniquindio.modelo

class Editorial(
    val id: Int,
    val nombre: String,
    val correo: String,
    val ciudad: Ciudad,
    val libros: ArrayList<Libro> = ArrayList()
)