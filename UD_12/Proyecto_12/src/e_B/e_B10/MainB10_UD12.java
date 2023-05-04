package e_B.e_B10;

/*
Supongamos que necesitas desarrollar una aplicación que permita a los usuarios
configurar ciertos parámetros, como por ejemplo el nombre de la empresa, el número
máximo de intentos de inicio de sesión, el tiempo de expiración de sesión, etc.
Para ello, podrías utilizar un archivo de properties donde se almacenen estas
configuraciones y que la aplicación pueda leer en tiempo de ejecución.

El ejercicio consiste en:
1. Crear un archivo config.properties con las siguientes propiedades y sus
respectivos valores:
empresa.nombre=Mi empresa
login.max_intentos=3
sesion.timeout=1800
2. Crear una clase ConfigManager que tenga un método loadConfig() que lea el
archivo de properties y cargue sus valores en un objeto Properties. Este método
deberá lanzar una excepción si el archivo no existe o no se puede leer.
3. Agregar los siguientes métodos a la clase ConfigManager:
• getNombreEmpresa(): Devuelve el nombre de la empresa.
• getMaxIntentos(): Devuelve el número máximo de intentos de inicio de sesión.
Es un entero
• getSesionTimeout(): Devuelve el tiempo de expiración de sesión en segundos.
Es un entero
4. Crear una clase EjercicioB10 que utilice la clase ConfigManager para imprimir
por pantalla los valores de configuración.
*/

import java.io.IOException;

public class MainB10_UD12 {
    public static void main(String[] args) {

        try {
            ConfigManager.loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Nombre"+ConfigManager.getNombreEmpresa());
        System.out.println(ConfigManager.getMaxIntentos());
        System.out.println(ConfigManager.getSesionTimeout());

    }
}
