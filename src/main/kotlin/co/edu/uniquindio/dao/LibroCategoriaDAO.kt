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
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_libro Foreign Key (libro) references Libro (id)," +
                        "Constraint fk_${nombre}_categoria Foreign Key (categoria) references Categoria (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }
}