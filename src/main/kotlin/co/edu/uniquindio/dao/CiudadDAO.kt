package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Ciudad

class CiudadDAO : IDao<Ciudad>() {
    init {
        this.nombre = "Ciudad"
        propiedades = arrayListOf(
            "id", "nombre", "pais"
        )
    }

    override fun generarTabla(): Boolean {
        PaisDAO().generarTabla()

        val parametros = arrayListOf(
            "INTEGER NOT NULL",
            "VARCHAR(50) NOT NULL",
            "INTEGER NOT NULL"
        )

        return generarTabla(parametros)
    }

    override fun buscar(id: String): Ciudad? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Ciudad>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Ciudad): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Ciudad): Boolean {
        TODO("Not yet implemented")
    }
}