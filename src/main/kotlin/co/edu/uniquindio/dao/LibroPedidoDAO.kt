package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.LibroPedido

object LibroPedidoDAO: IDao<LibroPedido>("Libro_Pedido") {
    override fun generarTabla(): Boolean {
        LibroDAO.generarTabla()
        PedidoDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "cantidad_libros INTEGER," +
                        "libro INTEGER NOT NULL," +
                        "pedido INTEGER NOT NULL," +
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_${nombre}_pedido Foreign Key (pedido) references Pedido (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }
}