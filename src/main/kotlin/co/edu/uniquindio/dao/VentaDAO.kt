package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Venta

class VentaDAO: IDao<Venta>() {
    override fun generarTabla(): Boolean {
        EmpleadoDAO().generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Venta (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "fecha_compra DATE," +
                        "valor_total DOUBLE," +
                        "empleado INTEGER NOT NULL," +
                        "persona INTEGER NOT NULL," +
                        "Constraint pk_venta Primary Key (id)," +
                        "Constraint fk_venta_empleado Foreign Key (empleado) references Empleado (id)," +
                        "Constraint fk_venta_persona Foreign Key (persona) references Persona (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Venta? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Venta>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Venta): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Venta): Boolean {
        TODO("Not yet implemented")
    }
}