package org.example.gympro.DateController;

import java.sql.Date;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class DateController {
    private Date fecha;

    public DateController(){

    }
    public DateController(Date fecha){
        setFecha(fecha);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public static Date getFechaActual(){
        long milisegundosActuales = System.currentTimeMillis();

        Date fechaActual=new Date(milisegundosActuales);
        return fechaActual;
    }

    public static Date suscripcionUnMes(Date fecha){
        long milisegundosEnUnMes = 30L * 24 * 60 * 60 * 1000;
        long fechamilisegundos=fecha.getTime();

        Date fechaMesMas=new Date(fechamilisegundos+milisegundosEnUnMes);
        return fechaMesMas;
    }

    public static Date suscripcionTresMes(Date fecha){
        long milisegundosEnUnMes = (30L * 24 * 60 * 60 * 1000)*3;
        long fechamilisegundos=fecha.getTime();

        Date fechaMesMas=new Date(fechamilisegundos+milisegundosEnUnMes);
        return fechaMesMas;
    }

    public  Time getHoraActual(){
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);

        Time horaActual = new Time(hora, minuto, segundo);
        return horaActual;
    }

    public static Date suscripcionUnAño(Date fecha){
        long milisegundosEnUnMes = (30L * 24 * 60 * 60 * 1000)*12;
        long fechamilisegundos=fecha.getTime();

        Date fechaMesMas=new Date(fechamilisegundos+milisegundosEnUnMes);
        return fechaMesMas;
    }

    public  int getDayOfWeekNumber() {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        return dayOfWeekNumber;
    }

    public static void main(String[] args){
        /*System.out.println(getFechaActual());
        System.out.println(suscripcionUnMes(getFechaActual()));
        System.out.println(suscripcionTresMes(getFechaActual()));
        System.out.println(suscripcionUnAño(getFechaActual()));*/

    }
}
