package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Editorial

object EditorialDAO: IDao<Editorial>("Editorial") {
    override fun generarTabla(): Boolean {
        CiudadDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "correo VARCHAR(50)," +
                        "ciudad INTEGER NOT NULL," +
                        "Constraint pk_editorial Primary Key (id)," +
                        "Constraint fk_editorial_ciudad Foreign Key (ciudad) references Ciudad (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Editorial): Boolean {
        TODO("Not yet implemented")
    }

}
