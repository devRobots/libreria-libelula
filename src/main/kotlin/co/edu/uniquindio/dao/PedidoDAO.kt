package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Pedido

object PedidoDAO: IDao<Pedido>("Pedido") {
    override fun generarTabla(): Boolean {
        ProveedorDAO.generarTabla()
        EmpleadoDAO.generarTabla()
        return try {
            return sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "fecha DATE," +
                        "empleado INTEGER NOT NULL," +
                        "proveedor INTEGER NOT NULL," +
                        "Constraint pk_pedido Primary Key (id)," +
                        "Constraint fk_pedido_empleado Foreign Key (empleado) references Empleado (id)," +
                        "Constraint fk_pedido_proveedor Foreign Key (proveedor) references Proveedor (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun insertar(entidad: Pedido): Boolean {
        TODO("Not yet implemented")
    }
}