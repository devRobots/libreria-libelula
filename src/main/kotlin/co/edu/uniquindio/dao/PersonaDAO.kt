package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Persona

object PersonaDAO: IDao<Persona>("Persona") {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "direccion VARCHAR(50)," +
                        "correo VARCHAR(50)," +
                        "fecha_nacimiento DATE," +
                        "Constraint pk_persona Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Persona): Boolean {
        TODO("Not yet implemented")
    }

}