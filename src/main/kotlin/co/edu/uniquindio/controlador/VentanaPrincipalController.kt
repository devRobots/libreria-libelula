package co.edu.uniquindio.controlador

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.ListView
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TextField

class VentanaPrincipalController {
    @FXML private lateinit var tabPane: TabPane

    @FXML private lateinit var listaLibros: ListView<String>
    @FXML private lateinit var txtLibroTitulo: TextField
    @FXML private lateinit var txtLibroEditorial: TextField
    @FXML private lateinit var txtLibroFecha: TextField
    @FXML private lateinit var txtLibroPrecio: TextField
    @FXML private lateinit var txtLibroAutor: TextField
    @FXML private lateinit var txtLibroCategorias: TextField
    @FXML private lateinit var txtLibroProveedores: TextField

    @FXML private lateinit var listaEmpleados: ListView<String>
    @FXML private lateinit var txtEmpleadoNombre: TextField
    @FXML private lateinit var txtEmpleadoDireccion: TextField
    @FXML private lateinit var txtEmpleadoCorreo: TextField
    @FXML private lateinit var txtEmpleadoFecha: TextField
    @FXML private lateinit var txtEmpleadoCargo: TextField

    @FXML private lateinit var listaVentas: ListView<String>
    @FXML private lateinit var txtVentaFecha: TextField
    @FXML private lateinit var txtVentaValor: TextField
    @FXML private lateinit var txtVentaCliente: TextField
    @FXML private lateinit var txtVentaEmpleado: TextField

    @FXML private lateinit var listaPedidos: ListView<String>
    @FXML private lateinit var txtPedidoFecha: TextField
    @FXML private lateinit var txtPedidoEmpleado: TextField
    @FXML private lateinit var txtPedidoProveedor: TextField

    @FXML private lateinit var listaReportes: ListView<String>

    @FXML
    fun eliminar(event: ActionEvent?) {
    }

    @FXML
    fun modificar(event: ActionEvent?) {
    }

    @FXML
    fun nuevo(event: ActionEvent?) {
    }

    @FXML
    fun reportar(event: ActionEvent?) {
    }

    @FXML
    fun initialize() {
    }
}