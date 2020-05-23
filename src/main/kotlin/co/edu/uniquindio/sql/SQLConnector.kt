package co.edu.uniquindio.sql

import java.sql.*
import java.util.*
import kotlin.collections.HashMap

class SQLConnector() : ICrudSQL {
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
        parametros: List<Any?>,
        propiedades: List<String>
    ): Map<String, List<Any?>> {
        return if (conexion != null) {
            val rs: ResultSet
            val ps: PreparedStatement
            val result: MutableMap<String, List<Any>> = HashMap()

            try {
                abrirConexion()

                ps = conexion!!.prepareStatement(sentencia)
                for (i in parametros.indices) {
                    ps.setString(i + 1, if (parametros[i] != null) parametros[i].toString() else null)
                }
                rs = ps.executeQuery()
                val rsMetaData = rs.metaData
                val numberOfColumns = rsMetaData.columnCount
                val resultados =
                    ArrayList<ArrayList<Any>>()
                while (rs.next()) {
                    val objetoRes = ArrayList<Any>()
                    for (i in 0 until numberOfColumns) {
                        objetoRes.add(rs.getObject(i + 1))
                    }
                    resultados.add(objetoRes)
                }
                for (i in 0 until numberOfColumns) {
                    result[propiedades[i]] = resultados[i]
                }
            } catch (ex: Exception) {
                throw SQLException("Imposible realizar consulta=>" + ex.message)
            }
            rs.close()
            ps.close()
            cerrarConexion()
            result
        } else {
            throw SQLException("No existe conexion con la BD.")
        }
    }

    @Throws(SQLException::class)
    override fun consultarFila(
        sentencia: String,
        parametros: List<Any?>,
        propiedades: List<String>
    ): Map<String, Any?> {
        return if (conexion != null) {
            val rs: ResultSet
            val ps: PreparedStatement
            val objResultado: MutableMap<String, Any> =
                HashMap()
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
    override fun eliminar(sentencia: String, parametros: List<Any?>): Boolean {
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

    init {
        props.setProperty("url", "jdbc:mysql://localhost:3306/libelula?autoReconnect=true&useSSL=false")
        props.setProperty("driver", "com.mysql.jdbc.Driver")
        props.setProperty("user", "root")
        props.setProperty("password", "root")
    }
}