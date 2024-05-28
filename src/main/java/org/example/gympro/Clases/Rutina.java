package org.example.gympro.Clases;

import org.example.gympro.Database.DataBaseController;
import org.example.gympro.DateController.DateController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private int id;
    private String nombre;
    private String descripcion;
    private List<String> listaEjercicios;

    public Rutina(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Rutina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getListaEjercicios() {
        return listaEjercicios;
    }

    public void setListaEjercicios(List<String> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    public void llenarListaEjercicios() {
        String semanaEjercicios = getDescripcion();

        List<String> nombresDeEjercicios = new ArrayList<>();

        String[] partes = semanaEjercicios.split("\\s+");

        String[] diasSemana = {"L:", "M:", "X:", "J:", "V:", "S:", "D:"};

        for (int i = 0; i < partes.length; i++) {
            for (String dia : diasSemana) {
                if (partes[i].startsWith(dia)) {
                    String nombreEjercicio = partes[i].substring(dia.length());
                    nombresDeEjercicios.add(nombreEjercicio);
                    break;
                }
            }
        }

        setListaEjercicios(nombresDeEjercicios);
    }


    public void leerlista(){
        List<String> nombresDeEjercicios = getListaEjercicios();
        for (int i = 0; i < nombresDeEjercicios.size(); i++) {
            System.out.println((i+1)+". "+nombresDeEjercicios.get(i));
        }
    }

    public String sacarParteCuerpoPorDiaHoy() {
        DateController dateController=new DateController();
        int diahoy=dateController.getDayOfWeekNumber();

        List<String> nombresDeEjercicios = getListaEjercicios();

        if (diahoy <= nombresDeEjercicios.size()) {
            String ejercicio = nombresDeEjercicios.get(diahoy-1);
            return ejercicio;
        } else {
            return "mal";
        }
    }


    public String devolverParteCuerpoDDBBController(String username){
        DataBaseController dbc=new DataBaseController();
        Rutina rutina=dbc.obtenerRutinasUsuario(username);
        rutina.llenarListaEjercicios();
        String pcuerpo= rutina.sacarParteCuerpoPorDiaHoy();
        if (pcuerpo.equals("mal")|pcuerpo.equals(null)|pcuerpo.equals("")){
            return null;
        }else {
            return pcuerpo;
        }
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public static void main(String[] args){
        /*DataBaseController dbc=new DataBaseController();
        Rutina rutina=dbc.obtenerRutinasUsuario("sergio");

        System.out.println(rutina.toString());
        rutina.llenarListaEjercicios();
        rutina.leerlista();

        rutina.sacarParteCuerpoPorDiaHoy();*/


        DataBaseController dbc=new DataBaseController();
        Rutina rutina=dbc.obtenerRutinasUsuario("sergio");
        rutina.llenarListaEjercicios();
        System.out.println(rutina.sacarParteCuerpoPorDiaHoy());

    }
}

