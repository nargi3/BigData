import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix size");
        int size = in.nextInt();
        int arr[][] = new int[size][size];
        int arr2[][] = new int[size][size];
        int arr3[][] = new int[size][size];
        int arr4[][] = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = random.nextInt(2 * size + 1) - size;
                arr2[j][i] = arr[j][i];
                arr3[j][i] = arr[j][i];
                arr4[j][i] = arr[j][i];
            }
        }
        System.out.println("Matrix:");
        for(int[]x:arr){
            for(int z:x){
                System.out.print(z+"  ");
            }  System.out.println();
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter shift left");
        int step = sc.nextInt();
        if (step > arr.length || step < 1) {
            System.out.println("Shift impossible");
            return;
        }
        int buff, i, j;
        for (int r = 0; r < step; r++) {
            for (i = 0; i < arr.length; i++) {
                buff = arr[i][0];
                for (j = 0; j < arr.length - 1; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][j] = buff;
            }
        }
        System.out.println("Matrix:");
        for(int[]x:arr){
            for(int z:x){
                System.out.print(z+"  ");
            }  System.out.println();
        }


        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter shift right");
        int step2 = sc.nextInt();
        if (step2 > arr2.length || step2 < 1) {
            System.out.println("Shift impossible");
            return;
        }
        int buff2 = 0, i2, j2;
        for (int r = 0; r < step2; r++) {
            for (i2 = 0; i2 < arr2.length; i2++) {
                buff2 = arr2[i2][arr2.length - 1];
                for (j2 = arr2.length - 1; j2 > 0; j2--) {
                    arr2[i2][j2] = arr2[i2][j2 - 1];
                }
                arr2[i2][j2] = buff2;
            }
        }
        System.out.println("Matrix:");
        for(int[]x:arr2){
            for(int z:x){
                System.out.print(z+"  ");
            }  System.out.println();
        }



        Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter shift down");
        int step3 = sc3.nextInt();
        if (step3 > arr3.length || step3 < 1) {
            System.out.println("Shift impossible");
            return;
        }
        int buff3, i3, j3;
        for (int r = 0; r < step; r++) {
            for (i3 = 0; i3 < arr3.length; i3++) {
                buff3 = arr3[arr3.length - 1][i3];
                for (j3 = arr3.length - 1; j3 > 0; j3--) {
                    arr3[j3][i3] = arr3[j3 - 1][i3];
                }
                arr3[j3][i3] = buff3;
            }
        }
        System.out.println("Matrix:");
        for(int[]x:arr3){
            for(int z:x){
                System.out.print(z+"  ");
            }  System.out.println();
        }



        Scanner sc4 = new Scanner(System.in);
        System.out.println("Enter shift up");
        int step4 = sc.nextInt();
        if (step4 > arr4.length || step4 < 1) {
            System.out.println("Shift impossible");
            return;
        }
        int buff4, i4, j4;
        for (int r = 0; r < step4; r++) {
            for (i4 = 0; i4 < arr4.length; i4++) {
                buff4 = arr4[0][i4];
                for (j4 = 0; j4 < arr4.length - 1; j4++) {
                    arr4[j4][i4] = arr4[j4 + 1][i4];
                }
                arr4[j4][i4] = buff4;
            }
        }
        System.out.println("Matrix:");
        for(int[]x:arr4){
            for(int z:x){
                System.out.print(z+"  ");
            }  System.out.println();
        }


    }
}