package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.LibroCategoria

object LibroCategoriaDAO: IDao<LibroCategoria>("Libro_Categoria") {
    override fun generarTabla(): Boolean {
        CategoriaDAO.generarTabla()
        LibroDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL," +
                        "libro INTEGER NOT NULL," +
                        "categoria INTEGER NOT NULL," +
                        "Constraint pk_libro_categoria Primary Key (id)," +
                        "Constraint fk_libro_categoria_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_libro_categoria_categoria Foreign Key (categoria) references Categoria (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }
}