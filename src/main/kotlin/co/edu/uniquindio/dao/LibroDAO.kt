package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Libro

object LibroDAO: IDao<Libro>() {
    override fun generarTabla(): Boolean {
        EditorialDAO.generarTabla()
        AutorDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Libro (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "precio DOUBLE NOT NULL," +
                        "titulo VARCHAR(50) NOT NULL," +
                        "fecha_publicacion DATE NOT NULL," +
                        "autor INTEGER NOT NULL," +
                        "editorial INTEGER NOT NULL," +
                        "libro_categoria INTEGER NOT NULL," +
                        "libro_proveedor INTEGER NOT NULL," +
                        "Constraint pk_libro Primary Key (id)," +
                        "Constraint fk_libro_autor Foreign Key (autor) references Autor (id)," +
                        "Constraint fk_libro_editorial Foreign Key (editorial) references Editorial (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Libro? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Libro>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Libro): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Libro): Boolean {
        TODO("Not yet implemented")
    }
}