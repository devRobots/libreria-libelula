package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Cargo

class CargoDAO: IDao<Cargo>() {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Cargo (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "Constraint pk_cargo Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: String): Cargo? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Cargo>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Cargo): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Cargo): Boolean {
        TODO("Not yet implemented")
    }

}