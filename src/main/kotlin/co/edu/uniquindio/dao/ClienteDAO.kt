package co.edu.uniquindio.dao

import co.edu.uniquindio.modelo.Cliente

object ClienteDAO : IDao<Cliente>("Cliente") {
    override fun generarTabla(): Boolean {
        PersonaDAO.generarTabla()
        return try {
            sqlConnector.generarTabla(
                "CREATE TABLE $nombre (" +
                        "id INTEGER NOT NULL AUTO_INCREMENT," +
                        "Constraint pk_$nombre Primary Key (id)," +
                        "Constraint fk_${nombre}_persona Foreign Key (id) references Persona (id)" +
                        ")"
            )
        } catch (ex: Exception) {
            false
        }
    }
}