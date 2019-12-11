
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Rogelio Rivera Lujan  - 18550725
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] datos = new int[20];
        /*llenar(datos);
        
        imprimir(datos);
        long ini, fin;
        ini = System.nanoTime();
        
        selectionSort(datos);
        fin = System.nanoTime();
        imprimir(datos);
        System.out.println("Tiempo: " + (fin - ini));
        
        
        
        llenar(datos);
        imprimir(datos);
        ini = System.nanoTime();
        insertionSort(datos);
        fin = System.nanoTime();
        imprimir(datos);
        System.out.println("Tiempo: " + (fin - ini));
        
        llenar(datos);
        imprimir(datos);
        ini = System.nanoTime();
        bubbleSort(datos);
        imprimir(datos);
        fin = System.nanoTime();
        System.out.println("Tiempo: " + (fin - ini));*/
        
        llenar(datos);
        imprimir(datos);
        selectionSort(datos);
        imprimir(datos);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar: ");
        int iVal = input.nextInt();
        System.out.println("Posicion: " + busquedaBin(datos, iVal));
        

        
    }
    
    public static void llenar(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random()*100);
        }
    }
    public static void imprimir(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    //CUADRATICOS
    public static void selectionSort(int[] arreglo){ //HACE MAS COMPARACIONES Y MENOS INTERCAMBIOS
        for (int i = 0; i < arreglo.length; i++) {
            int iMin = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[iMin]) 
                    iMin = j;
                
                    /*int iTemp = arreglo[j];
                    arreglo[j] = arreglo[i];
                    arreglo[i] = iTemp;*/
                
            
        }
            //SWAP
            int iTemp = arreglo[i];
            arreglo[i] = arreglo[iMin];
            arreglo[iMin] = iTemp;
    }
    
    }
    
    public static void insertionSort(int[] arreglo){ //HACE MAS INTERCAMBIOS Y MENOS COMPARACIONES
        for (int i = 1; i < arreglo.length; i++) {
            int iTemp = arreglo[i];
            int insP;
            for (insP = i; insP > 0; insP--) {
                int iPrev = insP - 1;
                if (arreglo[iPrev] > iTemp) {
                    //SWAP
                    arreglo[insP] = arreglo[iPrev];
                }else{
                    break;
                }
            }
            arreglo[insP] = iTemp;
        }
    }

    public static void bubbleSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int iTemp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = iTemp;
                }
            }
        }
    }
    
    public static void quickSort(int[] arreglo){
        quickSortrec(arreglo, 0, arreglo.length -1);
    }
    
    private static void quickSortrec(int [] arreglo, int ini, int fin){
        //DETENERNOS
        if((ini < fin) &&(ini >= 0) && (fin < arreglo.length)){
            int iPiv = ini;
            int too_big = ini + 1;
            int too_small = fin;
            int iTemp;


            while(too_big < too_small){
                while((too_big < fin) && (arreglo[too_big] < arreglo[iPiv]))
                    too_big++;
                

                while((too_small > (ini + 1)) && (arreglo[too_small] > arreglo[iPiv]))
                    too_small--;
                
                if (too_big < too_small) { //NO SE HAN CRUZADO
                    iTemp = arreglo[too_big];
                    arreglo[too_big] = arreglo[too_small];
                    arreglo[too_small] = iTemp;
                }
            }
            //SWAP EL PIVOTE
            iTemp = arreglo[iPiv];
            arreglo[iPiv] = arreglo[too_small];
            arreglo[too_small] = iTemp;

            quickSortrec(arreglo, ini, too_small -1);//IZQUIERDA
            quickSortrec(arreglo, too_small + 1, fin);//DERECHA
        }
    }
    
        public static int busquedaBin(int[] arreglo, int val){
            return busquedaBinRec(arreglo, val, 0, arreglo.length - 1);
        }
    
        private static int busquedaBinRec(int[] arreglo, int val, int ini, int fin){
            if(ini <= fin){
                int mid = ini + ((fin - ini) / 2);
                if (val == arreglo[mid]) {
                    return mid;
                }else{
                    if (val > arreglo[mid]) {//MAYOR
                        return busquedaBinRec(arreglo, val, mid + 1, fin);
                    }else{//MENOR
                        return busquedaBinRec(arreglo, val, ini, mid - 1);
                    }
                }
            }else{
                return -1;
            }
        }
}
