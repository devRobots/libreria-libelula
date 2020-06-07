package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.LibroVenta

object LibroVentaDAO : IDao<LibroVenta>("Libro_Venta") {
    override fun generarTabla(): Boolean {
        LibroDAO.generarTabla()
        VentaDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "cantidad INTEGER," +
                        "libro INTEGER NOT NULL," +
                        "venta INTEGER NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_${nombre}_venta Foreign Key (venta) references Venta (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }
}