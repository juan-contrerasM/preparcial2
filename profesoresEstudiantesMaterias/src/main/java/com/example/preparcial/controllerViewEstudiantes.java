package com.example.preparcial;

import com.example.preparcial.model.Materia;
import com.example.preparcial.model.Estudiante;
import com.example.preparcial.model.Profesor;
import com.example.preparcial.utils.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controllerViewEstudiantes implements Initializable {


    //----------------------------------fxml iniciarsesion--------------------
    @FXML
    private Label lblLogin;
    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblpassword;
    @FXML
    private Pane paneLoggin;
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsuario;
    //--------------------------------fxml cliente-----------------------------------------

    //----------------------------------------pedidos-------------------------
    @FXML
    private Button btnRefrescar;
    @FXML
    private Label lblPedidos;

    @FXML
    private TextArea txtAreaP;
    @FXML
    private Label lblProductos;

    @FXML
    private Label lblTotal;
    @FXML
    private Button btnLimpiar;
    //---------------------------------atributos fxml productos-----------------------------
    @FXML
    private TextField Buscador;

    @FXML
    private TextField BuscadorCliente;

    @FXML
    private TableView<Estudiante> tableDatos;
    @FXML
    private TableColumn<Estudiante, String> columnaUno;
    @FXML
    private TableColumn<Estudiante, String> columnaDos;
    @FXML
    private TableColumn<Estudiante, String> columnaTres;
    @FXML
    private TableColumn<Estudiante, String> columna4;
    @FXML
    private TableColumn<Estudiante, Integer> columna5;
    @FXML
    private TableColumn<Estudiante, String> columna6;
    @FXML
    private TableColumn<Estudiante,String> columna7;

    //tabla materia
    @FXML
    private TableView<Materia> tableDatosProMateria;
    @FXML
    private TableColumn<Materia, String> columnaUnoMateria;
    @FXML
    private TableColumn<Materia, String> columnaDosMateria;
    @FXML
    private TableColumn<Materia, String> columnaTresMateria;
    @FXML
    private TableColumn <Materia,String> columna4Materia;

    //tabla profesor
    @FXML
    private TableView<Profesor> tableDatosProfesorProfesor;
    @FXML
    private TableColumn<Profesor, String> columnaUnoProfesor;
    @FXML
    private TableColumn<Profesor, String> columnaDosProfesor;
    @FXML
    private TableColumn<Profesor, String> columnaTresProfesor;
    @FXML
    private TableColumn<Profesor, String> columna4Profesor;
    @FXML
    private TableColumn<Profesor, Integer> columna5Profesor;
    @FXML
    private TableColumn<Profesor, String> columna6Profesor;
    @FXML
    private TableColumn<Profesor, String> columna7Profesor;
    @FXML
    private TableColumn<Profesor, String> columna8Profesor;
    @FXML
    private TableColumn<Profesor, String> columna9Profesor;

    //---
    @FXML
    private Pane paneCampos;



    @FXML
    private Pane panePrincipal;

    @FXML
    private Pane panePrincipalCliente;

    @FXML
    private Pane paneTable;

    @FXML
    private Pane paneTableCliente;











    // -----------------------------atributos java producto---------------------------------------

    //se crean atributos para obtener campos de texto
    private String nombre = "";
    private String codigo = "";
    private float precio = 0;
    private float sumaTotal = 0;
    private String mensaje = "";
    private ArrayList<String>asignaciones=new ArrayList<>();
    //------------------------Atributos de tipo java cliente--------------
 //estudiantes
    private ArrayList<Estudiante> listaEstudiante = new ArrayList<Estudiante>();
    private ObservableList<Estudiante> listaPrincipalEstudiantes = FXCollections.observableArrayList();
//profesores
    private ArrayList<Profesor> listaProfesors = new ArrayList<>();
    private ObservableList<Profesor> listaPrincipaProfesors = FXCollections.observableArrayList();
//materrias
private ArrayList<Materia> listaMateria = new ArrayList<>();
    private ObservableList<Materia> listaPrincipalMaterias = FXCollections.observableArrayList();


    private Materia materiaSeleccionado;
    private Estudiante productoSeleccionado;








    //--------------------------------------------------INITIALIZABLE----------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        panePrincipal.setDisable(true);
        panePrincipalCliente.setDisable(true);



        //estudiantes
        try {
            //se carga en txt
            listaEstudiante = Persistencia.cargarEstudiante();
            listaPrincipalEstudiantes.clear();
            listaPrincipalEstudiantes.addAll(listaEstudiante);


            //se agrega la informaciona  la tabla
            columnaUno.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("codigo"));
            columnaDos.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
            columnaTres.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("apellido"));
            columna4.setCellValueFactory((new PropertyValueFactory<Estudiante, String>("sexo")));
            columna5.setCellValueFactory((new PropertyValueFactory<Estudiante, Integer>("edad")));
            columna6.setCellValueFactory((new PropertyValueFactory<Estudiante, String>("correoElectronico")));
            columna7.setCellValueFactory((new PropertyValueFactory<Estudiante, String>("telefono")));
            tableDatos.setItems(listaPrincipalEstudiantes);


            //se guarda en el txt
            Persistencia.guardarEstudiantes(listaEstudiante);


            registrarAcciones("Productos cargados", 1, "se carga la informacion del txt");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    //profesores
        try {
        //se carga en txt
        listaProfesors = Persistencia.cargarProfesors();
        listaPrincipaProfesors.clear();
        listaPrincipaProfesors.addAll(listaProfesors);


        //se agrega la informaciona  la tabla
        columnaUnoProfesor.setCellValueFactory(new PropertyValueFactory<Profesor, String>("codigo"));
        columnaDosProfesor.setCellValueFactory(new PropertyValueFactory<Profesor, String>("nombre"));
        columnaTresProfesor.setCellValueFactory(new PropertyValueFactory<Profesor, String>("apellido"));
        columna4Profesor.setCellValueFactory((new PropertyValueFactory<Profesor, String>("sexo")));
        columna5Profesor.setCellValueFactory((new PropertyValueFactory<Profesor, Integer>("edad")));
        columna6Profesor.setCellValueFactory((new PropertyValueFactory<Profesor, String>("correoElectronico")));
        columna7Profesor.setCellValueFactory((new PropertyValueFactory<Profesor, String>("telefono")));
        columna8Profesor.setCellValueFactory((new PropertyValueFactory<Profesor, String>("progama")));
        columna9Profesor.setCellValueFactory((new PropertyValueFactory<Profesor, String>("profesion")));
        tableDatosProfesorProfesor.setItems(listaPrincipaProfesors);


        //se guarda en el txt
        Persistencia.guardarProdesores(listaProfesors);


        registrarAcciones("Productos cargados", 1, "se carga la informacion del txt");


    } catch (IOException e) {
        throw new RuntimeException(e);
    }

        //materias
        try {
            //se carga en txt
            listaMateria = Persistencia.cargarMaterias();
            listaPrincipalMaterias.clear();
            listaPrincipalMaterias.addAll(listaMateria);


            //se agrega la informaciona  la tabla
            columnaUnoMateria.setCellValueFactory(new PropertyValueFactory<Materia, String>("codigo"));
            columnaDosMateria.setCellValueFactory(new PropertyValueFactory<Materia, String>("nombre"));
            columnaTresMateria.setCellValueFactory(new PropertyValueFactory<Materia, String>("intensidadHoraria"));
            columna4Materia.setCellValueFactory((new PropertyValueFactory<Materia, String>("tipoMateria")));
            tableDatosProMateria.setItems(listaPrincipalMaterias);


            //se guarda en el txt
            Persistencia.guardarMaterias(listaMateria);


            registrarAcciones("Productos cargados", 1, "se carga la informacion del txt");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //organizar declararr array antes del for y volver a guardar los datos de la persistencia
        try {
            ArrayList<String>asignacion=Persistencia.cargarAsignacion();
            for (String a:asignacion) {
                mensaje+=a+"\n";

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        txtAreaP.setText(mensaje);
        mensaje="";




    }


    //------------------------------------------------inicio sesion--------------------------------
    @FXML
    void entrar(ActionEvent event) {
        ArrayList<String> Usuarios = Persistencia.archivoPropiedades();
        boolean banderaU = false;
        boolean banderaP = false;

        for (String u : Usuarios) {
            if (u.equals(txtUsuario.getText())) {
                banderaU = true;
            }
            if (u.equals(txtPassword.getText())) {
                banderaP = true;
            }
            if (banderaP == true && banderaU == true) {
                panePrincipal.setDisable(false);
                paneLoggin.setDisable(true);
                panePrincipalCliente.setDisable(false);
                break;
            }
        }
    }


    //-----------------------------------------------log---------------------------------------------------------------

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
    //--------------------------------------------------Pedidos---------------------------

    @FXML
    void selecionar(MouseEvent event) {

        // se toomana los datos del producto seleccionado
        SelectionModel<Estudiante> selectionModel = tableDatos.getSelectionModel();
        productoSeleccionado = selectionModel.getSelectedItem();


        // Aquí guardamos la propiedades del producto seleccionado
        String nombreEstudiante = productoSeleccionado.getNombre();




        mensaje += "nombre: " + nombreEstudiante  ;
    }
    @FXML
    void selecionarMateria(MouseEvent event) {
        SelectionModel<Materia> selectionModel = tableDatosProMateria.getSelectionModel();
        materiaSeleccionado = selectionModel.getSelectedItem();
        mensaje+=" materia: "+materiaSeleccionado.getNombre();

    }

    @FXML
    void selecionarProfesor(MouseEvent event) {
        SelectionModel<Profesor> selectionModel = tableDatosProfesorProfesor.getSelectionModel();
        Profesor profesorSeleccionado = selectionModel.getSelectedItem();
        mensaje+=" profesor: "+profesorSeleccionado.getNombre();

    }

    @FXML
    void selecionarEstudiantes(MouseEvent event) {
        SelectionModel<Estudiante> selectionModel = tableDatos.getSelectionModel();
        Estudiante estudianteSeleccionado = selectionModel.getSelectedItem();
        mensaje+=" estudiante: "+estudianteSeleccionado.getNombre();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtAreaP.setText("");
        lblTotal.setText("");
        sumaTotal = 0;
        mensaje="";
    }

    @FXML
    void refrescar(ActionEvent event) throws IOException {
        asignaciones=Persistencia.cargarAsignacion();
        asignaciones.add(mensaje);
        mensaje="";
        for (String a:asignaciones) {
            mensaje+=a+"\n";
        }
        txtAreaP.setText(mensaje);


        Persistencia.guardarAsignacion(asignaciones);
        mensaje="";

        //------------------------------codigo reutilizable---------------------------------------


    }
    //enviamos un mensaje
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}