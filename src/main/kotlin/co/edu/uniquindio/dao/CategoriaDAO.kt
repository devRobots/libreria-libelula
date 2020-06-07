package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Categoria

object CategoriaDAO: IDao<Categoria>("Categoria") {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Categoria): Boolean {
        TODO("Not yet implemented")
    }
}