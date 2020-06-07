package co.edu.uniquindio.sql

import java.sql.*
import java.util.*
import kotlin.collections.HashMap

object SQLConnector : ICrudSQL {
    private var conexion: Connection? = null
    private val props: Properties = Properties()

    @Throws(SQLException::class)
    private fun cerrarConexion() {
        if (conexion != null) {
            conexion!!.close()
        }
    }

    @Throws(SQLException::class)
    private fun abrirConexion() {
        conexion = DriverManager.getConnection(props.getProperty("url"), props)
    }

    @Throws(SQLException::class)
    override fun generarTabla(sentencia: String): Boolean {
        abrirConexion()

        return if (conexion != null) {
            val ps = conexion!!.prepareStatement(sentencia)
            ps.execute()
            ps.close()

            cerrarConexion()
            true
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    @Throws(SQLException::class)
    override fun consultarFilas(
        sentencia: String,
        propiedades: List<String>,
        parametros: List<Any?>
    ): List<Map<String, Any?>> {
        abrirConexion()

        if (conexion != null) {
            val result: ArrayList<MutableMap<String, Any>> = ArrayList()

            val rs: ResultSet
            val ps: PreparedStatement

            try {
                ps = conexion!!.prepareStatement(sentencia)
                for (i in parametros.indices) {
                    ps.setString(i + 1, if (parametros[i] != null) parametros[i].toString() else null)
                }

                rs = ps.executeQuery()
                val rsMetaData = rs.metaData
                val numberOfColumns = rsMetaData.columnCount

                while (rs.next()) {
                    val objetoRes = emptyMap<String, Any>().toMutableMap()
                    for (i in 0 until numberOfColumns) {
                        objetoRes[propiedades[i]] = rs.getObject(i + 1)
                    }
                    result.add(objetoRes)
                }
            } catch (ex: Exception) {
                throw SQLException("Imposible realizar consulta=>" + ex.message)
            }
            rs.close()
            ps.close()
            cerrarConexion()
            return result
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    @Throws(SQLException::class)
    override fun consultarFila(
        sentencia: String,
        propiedades: List<String>,
        parametros: List<Any?>
    ): Map<String, Any?> {
        return if (conexion != null) {
            val rs: ResultSet
            val ps: PreparedStatement
            val objResultado: MutableMap<String, Any> = HashMap()
            try {
                abrirConexion()
                ps = conexion!!.prepareStatement(sentencia)
                for (i in parametros.indices) {
                    ps.setString(i + 1, if (parametros[i] != null) parametros[i].toString() else null)
                }
                rs = ps.executeQuery()
                val rsMetaData = rs.metaData
                val numberOfColumns = rsMetaData.columnCount
                if (rs.next()) {
                    for (i in 0 until numberOfColumns) {
                        objResultado[propiedades[i]] = rs.getObject(i + 1)
                    }
                }
            } catch (ex: Exception) {
                throw SQLException("Imposible realizar consulta=>" + ex.message)
            }
            rs.close()
            ps.close()
            cerrarConexion()
            objResultado
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    @Throws(SQLException::class)
    override fun actualizar(sentencia: String, parametros: List<Any?>): Boolean {
        return if (conexion != null) {
            abrirConexion()
            val cs = conexion!!.prepareCall(sentencia)
            for (i in parametros.indices) {
                cs.setString(i + 1, if (parametros[i] != null) parametros[i].toString() else null)
            }
            cs.execute()
            cs.close()
            cerrarConexion()
            true
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    @Throws(SQLException::class)
    override fun insertar(sentencia: String, parametros: List<Any?>): Boolean {
        abrirConexion()

        if (conexion != null) {
            val cs = conexion!!.prepareCall(sentencia)
            for (i in parametros.indices) {
                cs.setString(i + 1, if (parametros[i] != null) parametros[i].toString() else null)
            }
            cs.execute()
            cs.close()
            cerrarConexion()
            return true
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    @Throws(SQLException::class)
    override fun eliminar(sentencia: String, parametros: List<Any?>): Boolean {
        abrirConexion()

        return if (conexion != null) {
            val cs = conexion!!.prepareCall(sentencia)
            for (i in parametros.indices) {
                cs.setString(i + 1, if (parametros[i] != null) parametros[i].toString() else null)
            }
            cs.execute()
            cs.close()
            cerrarConexion()
            true
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    init {
        props.setProperty(
            "url",
            "jdbc:mysql://localhost:3306/libelula?" +
                    "autoReconnect=true" +
                    "&useSSL=false" +
                    "&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false" +
                    "&serverTimezone=UTC"
        )
        props.setProperty("driver", "com.mysql.jdbc.Driver")
        props.setProperty("user", "root")
        props.setProperty("password", "root")
    }
}