package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Venta

object VentaDAO: IDao<Venta>("Venta") {
    override fun generarTabla(): Boolean {
        EmpleadoDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "fecha_compra DATE," +
                        "valor_total DOUBLE," +
                        "empleado INTEGER NOT NULL," +
                        "persona INTEGER NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_empleado Foreign Key (empleado) references Empleado (id)," +
                        "Constraint fk_${nombre}_persona Foreign Key (persona) references Persona (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Venta): Boolean {
        TODO("Not yet implemented")
    }
}