package co.edu.usbbog.datanetworkoverlock.programa;

import java.util.Calendar;

public class Backup {

    private int idBackup;
    private String nombreBackup;
    private Calendar fecha;

    public Backup(int idBackup, String nombreBackup) {
        this.idBackup = idBackup;
        this.nombreBackup = nombreBackup;
        this.fecha = Calendar.getInstance();
    }

    public void crear() {
        //Aqui se genera el backup
    }

    public boolean eliminar(int idBackup) {
        //Proceso para eliminar el backup seleccionado
        return false;
    }

    public void listar() {
        //Imprimir los backups existentes
    }

}
