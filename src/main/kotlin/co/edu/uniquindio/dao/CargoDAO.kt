package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Cargo

object CargoDAO: IDao<Cargo>("Cargo") {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "Constraint pk_cargo Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Cargo? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Cargo> {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Cargo): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Cargo): Boolean {
        TODO("Not yet implemented")
    }

}