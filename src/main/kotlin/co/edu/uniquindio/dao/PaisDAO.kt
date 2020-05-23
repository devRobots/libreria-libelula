package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Pais

class PaisDAO : IDao<Pais>() {
    init {
        this.nombre = "Pais"
        propiedades = arrayListOf(
            "id", "nombre"
        )
    }

    override fun generarTabla(): Boolean {
        val parametros = arrayListOf(
            "INTEGER NOT NULL",
            "VARCHAR(50) NOT NULL"
        )

        return generarTabla(parametros)
    }

    override fun buscar(id: String): Pais? {
        return null
    }

    override fun listar(): List<Pais> {
        return emptyList()
    }

    override fun eliminar(id: String): Boolean {
        return false
    }

    override fun actualizar(nuevaEntidad: Pais): Boolean {
        return false
    }

    override fun insertar(entidad: Pais): Boolean {
        return false
    }
}