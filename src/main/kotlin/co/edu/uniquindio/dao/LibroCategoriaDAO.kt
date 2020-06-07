package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Categoria
import co.edu.uniquindio.modelo.Libro

object LibroCategoriaDAO: IDao<Map<Libro, Categoria>>("Libro_Categoria") {
    override fun generarTabla(): Boolean {
        CategoriaDAO.generarTabla()
        LibroDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "libro INTEGER NOT NULL," +
                        "categoria INTEGER NOT NULL," +
                        "Constraint pk_libro_categoria Primary Key (libro, categoria)," +
                        "Constraint fk_libro_categoria_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_libro_categoria_categoria Foreign Key (categoria) references Categoria (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Map<Libro, Categoria>? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Map<Libro, Categoria>> {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Map<Libro, Categoria>): Boolean {
        TODO("No yet implemented")
    }

    override fun insertar(entidad: Map<Libro, Categoria>): Boolean {
        TODO("Not yet implemented")
    }
}