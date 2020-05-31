package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Editorial

class EditorialDAO: IDao<Editorial>() {
    override fun generarTabla(): Boolean {
        CiudadDAO().generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Editorial (" +
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

    override fun buscar(id: String): Editorial? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Editorial>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Editorial): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Editorial): Boolean {
        TODO("Not yet implemented")
    }

}
