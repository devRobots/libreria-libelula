package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Categoria
import co.edu.uniquindio.modelo.Libro

class LibroCategoriaDAO: IDao<Map<Libro, Categoria>>() {
    override fun generarTabla(): Boolean {
        CategoriaDAO().generarTabla()
        LibroDAO().generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Libro_Categoria (" +
                        "libro INTEGER NOT NULL AUTO_INCREMENT," +
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

    override fun buscar(id: String): Map<Libro, Categoria>? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Map<Libro, Categoria>>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Map<Libro, Categoria>): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Map<Libro, Categoria>): Boolean {
        TODO("Not yet implemented")
    }
}