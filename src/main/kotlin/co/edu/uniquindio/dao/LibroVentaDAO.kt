package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Libro
import co.edu.uniquindio.modelo.Venta

class LibroVentaDAO : IDao<Map<Libro, Venta>>() {
    override fun generarTabla(): Boolean {
        LibroDAO().generarTabla()
        VentaDAO().generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Libro_Venta (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "cantidad INTEGER," +
                        "libro INTEGER NOT NULL," +
                        "venta INTEGER NOT NULL," +
                        "Constraint pk_libro_venta Primary Key (id)," +
                        "Constraint fk_libro_venta_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_libro_venta_venta Foreign Key (venta) references Venta (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: String): Map<Libro, Venta>? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Map<Libro, Venta>>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Map<Libro, Venta>): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Map<Libro, Venta>): Boolean {
        TODO("Not yet implemented")
    }

}