package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Autor

object AutorDAO: IDao<Autor>("Autor") {
    override fun generarTabla(): Boolean {
        PaisDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
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

    override fun insertar(entidad: Autor): Boolean {
        TODO("Not yet implemented")
    }

}
