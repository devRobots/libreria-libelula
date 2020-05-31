package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Empleado

class EmpleadoDAO: IDao<Empleado>() {
    override fun generarTabla(): Boolean {
        CargoDAO().generarTabla()
        PersonaDAO().generarTabla()
        return try {
            return sqlConnector.generarTabla(
                "CREATE TABLE Empleado (" +
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

    override fun buscar(id: String): Empleado? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Empleado>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Empleado): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Empleado): Boolean {
        TODO("Not yet implemented")
    }
}