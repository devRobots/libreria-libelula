package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Ciudad

class CiudadDAO : IDao<Ciudad>() {
    override fun generarTabla(): Boolean {
        PaisDAO().generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Ciudad (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "pais INTEGER NOT NULL," +
                        "Constraint pk_ciudad Primary Key (id)," +
                        "Constraint fk_ciudad_nacionalidad Foreign Key (pais) references Pais (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Ciudad? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Ciudad>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Ciudad): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Ciudad): Boolean {
        TODO("Not yet implemented")
    }
}