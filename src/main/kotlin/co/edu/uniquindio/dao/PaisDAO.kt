package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Pais

class PaisDAO : IDao<Pais>() {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Pais (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "Constraint pk_pais Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
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
        val propiedades = arrayListOf(
            "nombre"
        )
        val parametros = arrayListOf(
            entidad.nombre
        )
        return insertar("Pais", propiedades, parametros)
    }
}