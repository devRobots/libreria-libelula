package co.edu.uniquindio.modelo

class Ciudad(
    id: Int,
    val nombre: String,
    val pais: Pais,
    val editoriales: ArrayList<Editorial> = ArrayList()
) : Entidad(id)