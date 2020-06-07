package co.edu.uniquindio

import co.edu.uniquindio.dao.*
import co.edu.uniquindio.modelo.Ciudad
import co.edu.uniquindio.modelo.Pais
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import kotlin.system.exitProcess

class Main : Application() {

    /**
     * Metodo start de JavaFX
     *
     * Inicializacion de la GUI
     */
    override fun start(primaryStage: Stage?) {
        val loader = FXMLLoader(javaClass.getResource("./vista/VistaPrincipal.fxml"))
        val parent: Parent = loader.load()

        val scene = Scene(parent)

        primaryStage?.scene = scene
        primaryStage?.title = "Libreria Libelula"

        primaryStage?.minHeight = 400.0
        primaryStage?.minWidth = 600.0

        primaryStage?.show()
    }

    /**
     * Metodo main
     */
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DAOMaster.generarTablas()
            /*
            val pais = PaisDAO.buscar(2, Pais::class, omitir = arrayListOf("ciudades"))
            println(pais?.nombre)
            val res = CiudadDAO.insertar(
                Ciudad(
                    "Tangamandapio",
                    pais!!
                )
            )
            println(res)
            */
            exitProcess(0)
            //launch(Main::class.java)
        }
    }
}