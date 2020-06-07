package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Libro
import co.edu.uniquindio.modelo.Pedido

object LibroPedidoDAO: IDao<Map<Libro, Pedido>>() {
    override fun generarTabla(): Boolean {
        LibroDAO.generarTabla()
        PedidoDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Libro_Pedido (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "cantidad_libros INTEGER," +
                        "libro INTEGER NOT NULL," +
                        "pedido INTEGER NOT NULL," +
                        "Constraint pk_libro_pedido Primary Key (id)," +
                        "Constraint fk_libro_pedido_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_libro_pedido_pedido Foreign Key (pedido) references Pedido (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Map<Libro, Pedido>? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Map<Libro, Pedido>>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Map<Libro, Pedido>): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Map<Libro, Pedido>): Boolean {
        TODO("Not yet implemented")
    }
}