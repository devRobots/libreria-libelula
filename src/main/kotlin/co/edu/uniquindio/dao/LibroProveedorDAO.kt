package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.LibroProveedor

object LibroProveedorDAO: IDao<LibroProveedor>("Libro_Proveedor") {
    override fun generarTabla(): Boolean {
        LibroDAO.generarTabla()
        ProveedorDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "libro INTEGER NOT NULL AUTO_INCREMENT," +
                        "proveedor INTEGER NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_${nombre}_proveedor Foreign Key (proveedor) references Proveedor (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }
}