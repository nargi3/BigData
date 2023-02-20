import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size");
        int size = in.nextInt();
        int arr[][] = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = random.nextInt(2 * size + 1) - size;
            }
        }

        int[] mas = new int[arr.length * arr.length]; // матрицу в одномерный массив
        int inc=0, max=0, h=0, decr=0, min=0, h1=0, u=0;

        System.out.println("Matrix:");
        for(int[]x:arr){
            for(int z:x){
                System.out.print(z+"  ");
                mas[u++] =z;
            }
            System.out.println();
        }

        for (int j=0; j<mas.length-1; j++){
            if(mas[j] < mas[j+1]){ //если элемент больше предыдущего
                inc+=1; //количество  возрастаний
                if(inc>max) {
                    max=inc;
                    h=j+1;} //индекс последнего возрастающего элемента
            }
            else{inc=0;} //возрастание прервалась
            if(mas[j] > mas[j+1]){ //если элемент меньше предыдущего
                decr+=1; //количество  убываний
                if(decr>min){
                    min=decr;
                    h1=j+1; // индекс последнего убывающего элемента
                }
            } else{decr=0;}// убывание прервалась
        }
        System.out.println("Maximum sequence of increasing numbers:"); //возрастающая последовательность
        int[]m_inc=new int[max+1];
        System.arraycopy(mas,(h-max),m_inc,0,(max+1)); //копирование последовательности в новый массив
        System.out.println(Arrays.toString(m_inc)+" "+(max+1)); // вывод массива возрастающей последовательности
        System.out.println("Maximum sequence of decreasing numbers:"); // убывающая
        int[]m_decr=new int[min+1];
        System.arraycopy(mas,(h1-min),m_decr,0,(min+1)); //копирование последовательности в новый массив
        System.out.println(Arrays.toString(m_decr)+" "+(min+1)); // вывод массива убывающей последовательности
    }
    }