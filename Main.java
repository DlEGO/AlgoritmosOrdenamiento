import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.io.FileNotFoundException;

class Main {

    private int arr[];
    private int cont;
    private int sortType = 0;

    public void classicBubbleSort(){
        sortType = 1;
        
        int aux=0;
    
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    aux = arr[j]; 
                    arr[j] = arr[j+1];
                    arr[j+1]=aux;
                }
            cont++;
            }
        }   
    }

    public void bubbleSortImproved(){
        sortType = 2;
        
        int aux=0;
        boolean isSorted = false;
    
        for(int i=0;i<arr.length && isSorted == false;i++){
            isSorted = true;
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    isSorted = false;
                    aux = arr[j]; 
                    arr[j] = arr[j+1];
                    arr[j+1]=aux;
                }
            cont++;
            }
        }
    }

    public void selectionSort(){
        sortType = 3;
        
        for(int i = 0; i<arr.length-1;i++){
            int min_idx = i;
            for (int j = i+1; j < arr.length; j++){  
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            cont++;
        }
    }

   public void leerArreglo(String nom, int tam){
    arr = new int [tam];
    try{
      int i=0;
      Scanner s = new Scanner(new File(nom));
      while(s.hasNextInt()){
        arr[i++] = s.nextInt();
      }
    }catch(Exception e){
        System.out.println(e);
        System.exit(0);
    }
  } 

    public String printArray(){
        String print = "";
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            print += arr[i]+" ";
        }
        return print;
    }

    public void createFile(int tam,long time){
            FileWriter w;
            BufferedWriter bw;
            PrintWriter wr;
        try{
            File f;
            switch(sortType){
                case 1:
                    f = new File("archivos/ClassicBubbleSort"+tam+".txt");
                    if(f.createNewFile()){
                        System.out.println("se ha creado el archivo");
                    }
                    w = new FileWriter(f);
                    bw = new BufferedWriter(w);
                    wr = new PrintWriter(bw);

                    wr.append("\nLista de numeros ordenados ascendentemente:");
                    wr.append("\n"+printArray());
                    wr.append("\nCantidad teorica: "+((tam*tam)-tam)/2);
                    wr.append("\nTiempo: "+time);
                    wr.append("\nOperaciones: "+(cont));
                    
                    wr.close();
                    bw.close();
                    
                    break;
                case 2: 
                    f =new File("archivos/BubbleSortImproved"+tam+".txt");
                    if(f.createNewFile()){
                        System.out.println("se ha creado el archivo");
                    }
                    w = new FileWriter(f);
                    bw = new BufferedWriter(w);
                    wr = new PrintWriter(bw);

                    wr.append("\nLista de numeros ordenados ascendentemente:");
                    wr.append("\n"+printArray());
                    wr.append("\nCantidad teorica: "+((tam*tam)-tam)/2);
                    wr.append("\nTiempo: "+time);
                    wr.append("\nOperaciones: "+(cont));
                    
                    wr.close();
                    bw.close();
                    break;
                case 3:
                    f =new File("archivos/SelectionSort"+tam+".txt");
                    if(f.createNewFile()){
                        System.out.println("se ha creado el archivo");
                    }
                    w = new FileWriter(f);
                    bw = new BufferedWriter(w);
                    wr = new PrintWriter(bw);

                    wr.append("\nLista de numeros ordenados ascendentemente:");
                    wr.append("\n"+printArray());
                    wr.append("\nCantidad teorica: "+((tam*tam)-tam)/2);
                    wr.append("\nTiempo: "+time);
                    wr.append("\nOperaciones: "+(cont));
                    
                    wr.close();
                    bw.close();
                    break;                
            }
        }catch(IOException e){
            System.err.println("no se ha podido crear el archivo");
        }

    
        
        
    }
    
    public Main(){
        int tam = 100;
        leerArreglo("T"+tam+".txt", tam);
        long ti = System.currentTimeMillis();
        // classicBubbleSort();
        bubbleSortImproved();
        // selectionSort();
        long tf = System.currentTimeMillis();
    
        printArray();
        createFile(tam,tf-ti);
        
        System.out.println("\nCantidad teorica: "+((tam*tam)-tam)/2);
        // System.out.println("\nCantidad teorica: "+((tam)*(tam-1))/2);
        System.out.println("Tiempo: "+(tf-ti));
        System.out.println("Operaciones: "+(cont));
    }

    
  public static void main(String[] args) {
    new Main();
  }
}