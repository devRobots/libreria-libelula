package co.edu.uniquindio.modelo

class Autor(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val seudonimo: String?,
    val nacionalidad: Pais,
    val fans: ArrayList<Cliente> = ArrayList()
)