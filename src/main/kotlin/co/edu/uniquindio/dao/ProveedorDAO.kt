package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Proveedor

class ProveedorDAO: IDao<Proveedor>() {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Proveedor (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "correo VARCHAR(50)," +
                        "Constraint pk_proveedor Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: String): Proveedor? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Proveedor>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Proveedor): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Proveedor): Boolean {
        TODO("Not yet implemented")
    }
}