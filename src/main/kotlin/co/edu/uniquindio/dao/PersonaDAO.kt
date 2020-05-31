package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Persona

class PersonaDAO: IDao<Persona>() {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Persona (" +
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

    override fun buscar(id: String): Persona? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Persona>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Persona): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Persona): Boolean {
        TODO("Not yet implemented")
    }

}