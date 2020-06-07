package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Empleado

object EmpleadoDAO : IDao<Empleado>("Empleado") {
    override fun generarTabla(): Boolean {
        CargoDAO.generarTabla()
        PersonaDAO.generarTabla()
        return try {
            return sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL," +
                        "cargo INTEGER NOT NULL," +
                        "Constraint pk_empleado Primary Key (id)," +
                        "Constraint fk_empleado_persona Foreign Key (id) references Persona (id)," +
                        "Constraint fk_empleado_cargo Foreign Key (cargo) references Cargo (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Empleado? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Empleado> {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        return eliminarPorId(id)
    }

    override fun actualizar(nuevaEntidad: Empleado): Boolean {
        val eliminacion = eliminarPorId(nuevaEntidad.id)
        return if (eliminacion) insertar(nuevaEntidad) else eliminacion
    }

    override fun insertar(entidad: Empleado): Boolean {
        TODO("Not yet implemented")
    }
}