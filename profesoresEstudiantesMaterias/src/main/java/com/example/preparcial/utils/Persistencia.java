package com.example.preparcial.utils;

/*import co.edu.uniquindio.banco.bancouq.exceptions.UsuarioExcepcion;
import co.edu.uniquindio.banco.bancouq.model.*;*/

import com.example.preparcial.model.*;
import com.example.preparcial.model.Profesor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Persistencia {



//--------------------------------------RUTAS----------------------------------------
    public static final String RUTA_ARCHIVO_ESTUDIANTES = "C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\profesoresEstudiantesMaterias\\src\\main\\resources\\com\\example\\preparcial\\archivos\\estudiantes";

    public static final String RUTA_ARCHIVO_LOG ="C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\profesoresEstudiantesMaterias\\src\\main\\resources\\com\\example\\preparcial\\archivos\\log";

    public static final String RUTA_ARCHICO_MATERIAS ="C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\profesoresEstudiantesMaterias\\src\\main\\resources\\com\\example\\preparcial\\archivos\\materias";

    public static final String RUTA_ARCHIVO_PROFESORES="C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\profesoresEstudiantesMaterias\\src\\main\\resources\\com\\example\\preparcial\\archivos\\profesores";

    public  static final String RUTA_ARCHIVO_ASIGNACION="C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\profesoresEstudiantesMaterias\\src\\main\\resources\\com\\example\\preparcial\\archivos\\asignacion";
    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
//-------------------------------------------GUARDAR ARCHIVOS------------------------------
    public static void guardarProdesores(ArrayList<Profesor> listaProfesores) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Profesor profesor :listaProfesores)
        {
            contenido+=profesor.getNombre()+";"+profesor.getApellido()+";"+profesor.getCodigo()+";"+profesor.getSexo()+";"+profesor.getCorreoElectronico()+";"+profesor.getEdad()+";"+profesor.getTelefono() +";"+profesor.getProfesion()+";"+profesor.getProgama()+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PROFESORES, contenido, false);
    }
    public static void guardarEstudiantes(ArrayList<Estudiante> listaEstudiantes) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Estudiante estudiante : listaEstudiantes)

        {
            contenido+=estudiante.getNombre()+";"+estudiante.getApellido()+";"+estudiante.getCodigo()+";"+estudiante.getSexo()+";"+estudiante.getCorreoElectronico()+";"+estudiante.getEdad()+";"+estudiante.getTelefono()+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
    }
    public static void guardarMaterias(ArrayList<Materia> listaMaterias) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Materia materia : listaMaterias)

        {

                contenido+=materia.getCodigo()+"@@"+materia.getNombre()+"@@"+materia.getIntensidadHoraria()+"@@"+materia.getTipoMateria()+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHICO_MATERIAS, contenido, false);
    }
    public static void guardarAsignacion(ArrayList<String> listaAsignaciones) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(String asignacion : listaAsignaciones)

        {

            contenido+=asignacion+"\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ASIGNACION, contenido, false);
    }




//	----------------------CARGAR ARCHIVOS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<String> archivoPropiedades() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("modalidades", new Locale("", ""));
        ArrayList<String>modalidades=new ArrayList<>();
        modalidades.add(resourceBundle.getString("usuario"));
        modalidades.add(resourceBundle.getString("password"));
        return modalidades;
    }//profesor.getNombre()+";"+profesor.getApellido()+";"+profesor.getCodigo()+","+profesor.getSexo()+";"+profesor.getCorreoElectronico()+";"+profesor.getEdad()+";"+profesor.getTelefono() +";"+profesor.getProfesion()+";"+profesor.getProgama()+"\n";

    public static ArrayList<Profesor> cargarProfesors() throws FileNotFoundException, IOException
    {
        ArrayList<Profesor> listaProfesores =new ArrayList<Profesor>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROFESORES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);
            Profesor profesor = new Profesor();
            profesor.setNombre(linea.split(";")[0]);
            profesor.setApellido(linea.split(";")[1]);
            profesor.setCodigo(linea.split(";")[2]);
            profesor.setSexo(linea.split(";")[3]);
            profesor.setCorreoElectronico(linea.split(";")[4]);
            profesor.setEdad(Integer.parseInt(linea.split(";")[5]));
            profesor.setTelefono(linea.split(";")[6]);
            profesor.setProfesion(linea.split(";")[7]);
            profesor.setProgama(linea.split(";")[8]);

            listaProfesores.add(profesor);
        }
        return listaProfesores;
    }
    public static ArrayList<Estudiante> cargarEstudiante() throws FileNotFoundException, IOException
    {
        ArrayList<Estudiante> estudiantes =new ArrayList<Estudiante>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {

                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454ClienteproducCliente();
            Estudiante estudiante =new Estudiante();
            estudiante.setNombre(linea.split(";")[0]);
            estudiante.setApellido(linea.split(";")[1]);
            estudiante.setCodigo(linea.split(";")[2]);
            estudiante.setSexo(linea.split(";")[3]);
            estudiante.setCorreoElectronico(linea.split(";")[4]);
            estudiante.setEdad(Integer.parseInt(linea.split(";")[5]));
            estudiante.setTelefono(linea.split(";")[6]);

            estudiantes.add(estudiante);
        }
        return estudiantes;
    }
    public static ArrayList<String> cargarAsignacion() throws FileNotFoundException, IOException
    {
        ArrayList<String> asignacion =new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ASIGNACION);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {

            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454ClienteproducCliente();

            asignacion.add(linea);
        }
        return contenido;
    }
    public static ArrayList<Materia> cargarMaterias() throws FileNotFoundException, IOException
    {
        ArrayList<Materia> listaMaterias =new ArrayList<Materia>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHICO_MATERIAS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {


                linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454ClienteproducCliente();
            Materia materia =new Materia();
            materia.setCodigo(linea.split("@@")[0]);
            materia.setNombre(linea.split("@@")[1]);
            materia.setIntensidadHoraria(linea.split("@@")[2]);
            materia.setTipoMateria(TipoMateria.valueOf(linea.split("@@")[3]));
            listaMaterias.add(materia);
        }
        return listaMaterias;
    }

    //------------------------------REGISTRO LOG-----------------------------------------
    public static void guardaRegistroLog(String mensaje, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLog(mensaje, nivel, accion, RUTA_ARCHIVO_LOG);
    }
    //----------------------archivosXml--------------------------
    public static void guardarRecursoBancoXML(ArrayList<Profesor> LISTADEPROGAMAS) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML("C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\pedidos.xml", LISTADEPROGAMAS);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
    public static ArrayList<Profesor> cargarRecursoBancoXML() {
        ArrayList<Profesor> lista = null;

        try {
            lista = (ArrayList)ArchivoUtil.cargarRecursoSerializadoXML("C:\\Users\\juanj\\OneDrive\\Escritorio\\preparcial\\clientesProductos\\src\\main\\resources\\com\\example\\preparcial\\archivos\\pedidos.xml");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return lista;
    }













}
