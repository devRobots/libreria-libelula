package co.edu.uniquindio.modelo

class Ciudad(
    val id: Int,
    val nombre: String,
    val pais: Pais,
    val editoriales: ArrayList<Editorial> = ArrayList()
)