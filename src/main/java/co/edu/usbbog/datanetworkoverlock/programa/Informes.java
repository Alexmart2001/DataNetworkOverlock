package co.edu.usbbog.datanetworkoverlock.programa;

import co.edu.usbbog.datanetworkoverlock.programa.Usuario;

import java.util.Calendar;

@FunctionalInterface
public interface Informes {

    void generar(String descripcionInforme, Calendar fechaInforme, Usuario usuario);

}
