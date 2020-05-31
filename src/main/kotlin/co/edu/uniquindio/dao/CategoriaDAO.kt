package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Categoria

class CategoriaDAO: IDao<Categoria>() {
    override fun generarTabla(): Boolean {
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Categoria (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "Constraint pk_categoria Primary Key (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Categoria? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Categoria>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Categoria): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Categoria): Boolean {
        TODO("Not yet implemented")
    }
}