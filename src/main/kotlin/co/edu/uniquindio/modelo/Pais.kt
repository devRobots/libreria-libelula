package co.edu.uniquindio.modelo

class Pais(
    val id: Int,
    val nombre: String,
    val ciudades: ArrayList<Ciudad> = ArrayList(),
    val autores: ArrayList<Autor> = ArrayList()
)