/*
 * Ejercicio 1.
 * Crea un método con un array que almacene 5 elementos enteros leídos desde teclado mediante la clase ES y 
 * muestre por pantalla su contenido. A continuación, debes de desplazar el contenido de cada elemento a la siguiente 
 * posición y el del último deberá guardarse en la primera. Por último, vuelve a mostrar los datos almacenados.
 * 
 * Ejercicio 2.
 * Crea un método que devuelva una frase aleatoria a partir de cuatro arrays. Cada uno de ellos debe de contener las 
 * frases de una columna de las que se muestran a continuación: (ver documento).
 * Crea otro método que reciba por parámetro el tamaño que ha de tener un array. Dicho array (o vector) almacenará 
 * frases mediante la llamada al método anterior.
 * 
 * Una vez completo el array muestraslas todas, indica el número de frases que contienen la palabra “que” y cual es la 
 * la frase que tiene el mayor número de “las”.
 */
package Principal;

import Utilidades.ES;

/**
 *
 * @author Antonio Ramos
 */
public class CPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        do{
            opcion = ES.leerEntero(0, 2, "\nTarea presencial 4\n"
                    + "------------------\n"
                    + "1. Desplazamiento de un array.\n"
                    + "2. Frases aleatorias.\n"
                    + "0. Salir.\n"
                    + "Elija una opción: ");
            switch(opcion){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    desplazarContenidoArray();
                    break;
                case 2:
                    int tam;
                    do{
                        tam = ES.leerEntero("Introduzca el tamaño que quiere para el array de"
                                + "cadenas de caracteres: ");
                        if(tam <= 0)
                            System.err.println("Error. El tamaño de un array debe ser mayor que 0.");
                    }while(tam <= 0);
                    trabajarConArrayDeString(tam);
                    break;
            }
        }while(opcion != 0);
    }
    
    
    // MÉTODO DEL EJERCICIO 1
    // -----------------------
    
    /**
     * Método que permite el desplazacimiento del contenido de un array de 5 enteros introducidos por teclado.
     */
    private static void desplazarContenidoArray() {
        int vUltimo;
        int[] numeros = new int[5];
        
        // Lectura de los datos 
        for(int i = 0; i < numeros.length; i++)
            numeros[i] = ES.leerEntero("L " + (i+1) + ". Introduzca un número entero: ");

        // Mostramos el contenido del array
        System.out.println("El array está compuesto por los siguientes números: ");
        for(int i = 0; i < numeros.length; i++)
            System.out.format("Posicion %d: %d\n", i, numeros[i]);
        
        // Desplazamos el contenido del array
        vUltimo = numeros[numeros.length - 1];
        
        for (int i = numeros.length - 1; i > 0; i--) {
            numeros[i] = numeros[i - 1];
        }
        numeros[0] = vUltimo;
        
        // Mostramos nuevamente el array
        System.out.println("Una vez realizado el desplazamiento el array es el siguiente: ");
        for(int i = 0; i < numeros.length; i++)
            System.out.format("Posicion %d: %d\n", i, numeros[i]);

    }

    // MÉTODOs DEL EJERCICIO 2
    //
    
    /**
     * Método que crea un array de String definido por el usuario y que busca la cantidad
     * de palabras "que" y "las" que hay en los distintos textos que almacena.
     * @param tamanioArray tamaño del array de cadenas de caracteres.
     */
    private static void trabajarConArrayDeString(int tamanioArray){
        String[] frases = new String[tamanioArray];
        
        // Rellenamos el array con las frases generadas de forma aleatoria
        for(int i = 0; i < frases.length; i++)
            frases[i] = fraseAleatoria();
        
        // Mostramos el contenido del array
        System.out.println("El contenido del array es: ");
        for(int i = 0; i < frases.length; i++)
            System.out.format("Frase %d: %s\n", i+1, frases[i]);
        
        // Realizamos la búsqueda de "que" y "las"
        int contadorQue = 0;
        int posicionFraseMasLas = -1, maxLas = 0, index, numLas;
                
        for(int i = 0; i < frases.length; i++){
            if(frases[i].contains(" que"))
                contadorQue++;
            numLas = 0;
            index = 0;
            do{
                index = frases[i].indexOf(" las", index);
                if(index != -1){
                    numLas++;
                    index++;
                }
            }while(index != -1);
            
            if(numLas > maxLas){
                maxLas = numLas;
                posicionFraseMasLas = i;
            }
        }
        
        // Mostramos el resultado obtenido.
        System.out.format("En el array hay %d frases que contienen la palabra 'que' (en minúscula)\n", contadorQue);
        
        if(posicionFraseMasLas == -1)
            System.out.println("No hay ninguna frase con la palabra 'las' (en minúscula");
        else
            System.out.format("La frase que tiene más 'las' es : %s \ncon un total de %d palabra(s).\n", frases[posicionFraseMasLas],maxLas);
    }
    
    /**
     * Método que genera una frase aleatoria y la devuelve.
     * @return frase aleatoria generada.
     */
    private static String fraseAleatoria(){
        String[] primeraParteFrase = {" Queridos compañeros ", 
            " Por otra parte,y dados los condicionamientos actuales ",
            " Asimismo,",
            " Sin embargo no hemos de olvidar que ",
            " De igual manera, ",
            " La práctica de la vida cotidiana prueba que, ",
            " No es indispensable argumentar el peso y la significación de estos problemas ya que, ",
            " Las experiencias ricas y diversas muestran que, ",
            " El afán de organización, pero sobre todo ",
            " Los superiores principios ideológicos, condicionan que ",
            " Incluso, bien pudieramos atrevernos a sugerir que ",
            " Es obvio señalar que, ",
            " Pero pecaríamos de insinceros si soslayasemos que, ",
            " Y ademas, quedaríamos inmersos en la más abyecta de las estulticias si no fueramos consacientes de que, ",
            " Por último, y como definitivo elemento esclarecedor, cabe añadir que, "};
        String[] segundaParteFrase = {"la realización de las premisas del programa ",
            "la complejidad de los estudios de los dirigentes ",
            "el aumento constante, en cantidad y en extensión, de nuestra actividad ",
            "la estructura actual de la organización ",
            "el nuevo modelo de actividad de la organización, ",
            "el desarrollo continuo de distintas formas de actividad ",
            "nuestra actividad de información y propaganda ",
            "el reforzamiento y desarrollo de las estructuras ",
            "la consulta con los numerosos militantes ",
            "el inicio de la acción general de formación de las actitudes ",
            "un relanzamiento específico de todos los sectores implicados ",
            "la superación de experiencias periclitadas ",
            "una aplicación indiscriminada de los factores confluyentes ",
            "la condición sine qua non rectora del proceso ",
            "el proceso consensuado de unas y otras aplicaciones concurrentes "};
        String[] terceraParteFrase = {"nos obliga a un exhaustivo análisis ",
            "cumple un rol escencial en la formación ",
            "exige la precisión y la determinación ",
            "ayuda a la preparación y a la realización ",
            "garantiza la participación de un grupo importante en la formación ",
            "cumple deberes importantes en la determinación",
            "facilita la creación ",
            "obstaculiza la apreciación de la importancia ",
            "ofrece un ensayo interesante de verificación ",
            "implica el proceso de reestructuración y modernización ",
            "habrá de significar un auténtico y eficaz punto de partida ",
            "permite en todo caso explicitar las razones fundamentales ",
            "asegura, en todo caso, un proceso muy sensible de inversión ",
            "radica en una elaboración cuidadosa y sistemática de las estrategias adecuadas ",
            "deriva de una indirecta incidencia superadora "};
        String[] cuartaParteFrase = {"de las condiciones financieras y administrativas existentes. ",
            "de las directivas de desarrollo para el futuro. ",
            "del sistema de participación general. ",
            "de las actitudes de los miembros hacia sus deberes ineludibles. ",
            "de las nuevas proposiciones. ",
            "de las direcciones educativas en el sentido del progreso. ",
            "del sistema de formación de cuadros que corresponda a las necesidades. ",
            "de las condiciones de las actividades apropiadas. ",
            "del modelo de desarrollo. ",
            "de las formas de acción. ",
            "de las básicas premisas adoptadas. ",
            "de toda una casuística de amplio espectro. ",
            "de los elementos generadores. ",
            "para configurar una interface amigable y coadyuvante a la reingeniería del sistema. ",
            "de toda una serie de criterios ideologicamente sistematizados en un frente común de actuación regeneradora. "};

        return primeraParteFrase[(int)(Math.random()*primeraParteFrase.length)] 
                + segundaParteFrase[(int)(Math.random()*segundaParteFrase.length)]
                + terceraParteFrase[(int)(Math.random()*terceraParteFrase.length)]
                + cuartaParteFrase[(int)(Math.random()*cuartaParteFrase.length)];
    }
    
    
}
