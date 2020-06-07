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
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_persona Foreign Key (id) references Persona (id)," +
                        "Constraint fk_${nombre}_cargo Foreign Key (cargo) references Cargo (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Empleado): Boolean {
        TODO("Not yet implemented")
    }
}