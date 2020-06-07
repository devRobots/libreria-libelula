package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Ciudad

object CiudadDAO : IDao<Ciudad>("Ciudad") {
    override fun generarTabla(): Boolean {
        PaisDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
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

    override fun insertar(entidad: Ciudad): Boolean {
        TODO("Not yet implemented")
    }
}