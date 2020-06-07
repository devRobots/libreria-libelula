package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Libro
import co.edu.uniquindio.modelo.Proveedor

object LibroProveedorDAO: IDao<Map<Libro, Proveedor>>("Libro_Proveedor") {
    override fun generarTabla(): Boolean {
        LibroDAO.generarTabla()
        ProveedorDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "libro INTEGER NOT NULL AUTO_INCREMENT," +
                        "proveedor INTEGER NOT NULL," +
                        "Constraint pk_libro_proveedor Primary Key (libro, proveedor)," +
                        "Constraint fk_libro_proveedor_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_libro_proveedor_proveedor Foreign Key (proveedor) references Proveedor (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Map<Libro, Proveedor>? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Map<Libro, Proveedor>> {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Map<Libro, Proveedor>): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Map<Libro, Proveedor>): Boolean {
        TODO("Not yet implemented")
    }
}