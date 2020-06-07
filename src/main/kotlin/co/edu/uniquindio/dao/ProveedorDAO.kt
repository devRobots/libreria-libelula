package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Proveedor

object ProveedorDAO: IDao<Proveedor>("Proveedor") {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "correo VARCHAR(50)," +
                        "Constraint pk_$nombre Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Proveedor): Boolean {
        TODO("Not yet implemented")
    }
}