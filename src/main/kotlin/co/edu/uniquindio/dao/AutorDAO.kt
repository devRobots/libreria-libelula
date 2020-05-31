package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Autor

class AutorDAO: IDao<Autor>() {
    override fun generarTabla(): Boolean {
        PaisDAO().generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE Autor (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "nombre VARCHAR(50) NOT NULL," +
                        "descripcion VARCHAR(110)," +
                        "seudonimo VARCHAR(50)," +
                        "nacionalidad INTEGER NOT NULL," +
                        "Constraint pk_autor Primary Key (id)," +
                        "Constraint fk_autor_pais Foreign Key (nacionalidad) references Pais (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }

    override fun buscar(id: Int): Autor? {
        TODO("Not yet implemented")
    }

    override fun listar(): List<Autor>? {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(nuevaEntidad: Autor): Boolean {
        TODO("Not yet implemented")
    }

    override fun insertar(entidad: Autor): Boolean {
        TODO("Not yet implemented")
    }

}
