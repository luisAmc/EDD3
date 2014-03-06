
import com.sun.corba.se.impl.orbutil.graph.Graph;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.SparseMultigraph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import javax.lang.model.SourceVersion;
import javax.tools.Tool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lualmaca
 */
public class Main {

    public static void main(String[] args) {

        Grafo grafito = new Grafo();
        Set<String> terminalesDisponibles = new TreeSet<String>();
        terminalesDisponibles = cargarTerminalesDisponibles();
        if (terminalesDisponibles == null)
            System.exit(1);
        /*probar imprimir terminales*/

//        System.out.println("No  Aereolinea    TSalida   TLlegada     (Cost US$)");
//     /*   for (int i = 0; i < grafito.grafito.getEdgeCount(); i++) {//inicio for
//            System.out.println((i + 1));
//
//
//        }//fin for*/
//        
//        Object[] Vertices = grafito.grafito.getVertices().toArray();
//        Object[] Aristas = grafito.grafito.getEdges().toArray();
//      
//        for (int i = 0; i <Vertices.length; i++) {
//           // System.out.println((i+1)+" "+Vertices[i]);
//            
//           // System.out.println(Vertices[0].toString()+" "+grafito.grafito.getIncidentEdges(Vertices[0].toString()));
//            //System.out.println(Vertices[0].toString()+" "+grafito.grafito.getNeighbors(Vertices[0].toString()));
//            for (int j = 1; j <Vertices.length; j++) {
//                
//            
//             System.out.println(Vertices[i].toString()+" "+grafito.grafito.findEdge(Vertices[i].toString(),Vertices[j].toString())+Vertices[j].toString());
//             }
//          }//
//        
//         for (int i = 0; i <Aristas.length; i++) {
//          //  System.out.println((i+1)+" "+Aristas[i]);
//        }
        System.out.println(""
                + "*****************************************************\n"
                + "**     Universidad Tecnologica Centroamericana     **\n"
                + "**                     UNITEC                      **\n"
                + "*****************************************************\n");
        System.out.println("Seleccione una terminal de salida:");
        imprimirTerminales(terminalesDisponibles);
        
        Queue<String> ciudades = new LinkedList<String>();
        ciudades.add("BWI");
        ciudades.add("TGU");
        //Aqui llamar a la funcion validarTerminales, retorna false si uno no coincide
        
        String tSalida = "BWI";//Este va a ser el primero que ingrese
        String tLlegada = "TGU";//Este va a ser el ultimo que ingrese
        ArrayList caminos = grafito.calcularCamino(ciudades);
        
        System.out.println("La forma de hacer el tour, mediante la ruta mas corta,\n"
                + "desde " + tSalida + " hasta " + tLlegada + " es: ");
        System.out.println(caminos.get(0).toString());
        System.out.println("y el costo total suma: " + caminos.get(1).toString());
    }
    
    public static Set<String> cargarTerminalesDisponibles() {
        Set<String> retVal = new TreeSet<String>();
        try {
            File archivo = new File("./src/resources/Terminales de Salida.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String tmp;
            while ((tmp = br.readLine()) != null) {
                retVal.add(tmp);
            }
            return retVal;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retVal;
    }
    
    public static void imprimirTerminales(Set<String> t) {
        Iterator iter = t.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            System.out.println((i + 1) + ")" + iter.next());
        }
        System.out.println("Para terminar de ingresar ciudades, ingrese -1.");
    }
    
    public static boolean validarTerminales(Queue<String> cola, Set<String> t) {
        Queue<String> tmp = cola;
        Iterator iter = cola.iterator();
        while (iter.hasNext()) {
            if (t.contains(iter.next()) == false) {
                return false;
            }
        }
        return true;
    }
}//fin clase main

