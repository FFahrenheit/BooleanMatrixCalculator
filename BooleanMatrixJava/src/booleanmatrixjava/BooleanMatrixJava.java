/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanmatrixjava;

import java.util.Scanner;

/**
 *
 * @author Johann
 */
public class BooleanMatrixJava
{ 
    public static Scanner input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        input = new Scanner(System.in);
        int menu;
        do
        {
            System.out.println("Ingrese la opción a probar");
            System.out.println("1:Union\n2:Conjuncion\n3:Complemento\n4:Inversa");
            System.out.println("5:Composicion:\n6:Salir");
            System.out.print("Tu elección: ");
            menu = input.nextInt();
            switch(menu)
            {
                case 1:
                    union();
                    break;
                case 2:
                    conjuncion();
                    break;
                case 3:
                    complemento();
                    break;
                case 4:
                    inversa();
                    break;
                case 5:
                    composicion();
                    break;
                case 6:
                    System.out.println("¡Gracias!");
                    break;
                default:
                    System.out.println("Pruebe de nuevo");
                    break;
            }
            if(menu!=7)
            {
                System.out.print("Presione una tecla y emter para continuar");
                input.next();
            }
        }while(menu!=7);    
    }
        
    
    private static boolean[][] askMatrix(int _rows , int _cols)
    {
        boolean[][] matrix = new boolean[_rows][_cols];
        System.out.println("Ingrese 1 o 0 segun corresponda");
        for(int i=0; i<_rows; i++)
        {
            for (int j = 0; j <_cols; j++) 
            {
                boolean condition = false;
                int value;
                do
                {
                    System.out.print("Ingrese el miembro ["+i+"]["+j+"]: ");
                    value = input.nextInt();
                }while(value!=0 && value!=1);
                matrix[i][j] = value == 1;
            }
        }
        return matrix;
    }
    
    private static void union()
    {
        int dim;
        System.out.println("Ingrese las dimensiones de las matrices");
        dim = getDim();
        Matrix m1 = new Matrix(askMatrix(dim,dim));
        Matrix m2 = new Matrix(askMatrix(dim,dim));
        Matrix result = m1.getUnion(m1, m2);
        if(result!=null)
        {
            m1.print();
            System.out.println("   U");
            m2.print();
            System.out.println("    =");
            result.print();
        }
        else
        {
            System.out.println("No es valido");
        }
    }
    
    private static void composicion()
    {
        int dim;
        System.out.println("Ingrese las dimensiones de las matrices");
        dim = getDim();
        Matrix m1 = new Matrix(askMatrix(dim,dim));
        Matrix m2 = new Matrix(askMatrix(dim,dim));
        Matrix result = m1.getComposition(m1, m2);
        if(result!=null)
        {
            m1.print();
            System.out.println("   (+)");
            m2.print();
            System.out.println("    =");
            result.print();
        }
        else
        {
            System.out.println("No es valido");
        }
    }
    
    private static void conjuncion()
    {
        int dim;
        System.out.println("Ingrese las dimensiones de las matrices");
        dim = getDim();
        Matrix m1 = new Matrix(askMatrix(dim,dim));
        Matrix m2 = new Matrix(askMatrix(dim,dim));
        Matrix result = m1.getConjunction(m1, m2);
        if(result!=null)
        {
            m1.print();
            System.out.println("   ^");
            m2.print();
            System.out.println("    =");
            result.print();
        }
        else
        {
            System.out.println("No es valido");
        }
    }
    
    private static void complemento()
    {
        int dim;
        System.out.println("Ingrese las dimensiones de la matriz");
        dim = getDim();
        Matrix m1 = new Matrix(askMatrix(dim,dim));
        Matrix result = m1.getComplement(m1);
        if(result!=null)
        {
            m1.print();
            System.out.println("Complemento = ");
            result.print();
        }
        else
        {
            System.out.println("Invalido");
        }
    }
    
    private static void inversa()
    {
        int dim;
        System.out.println("Ingrese las dimensiones de la matriz");
        dim = getDim();
        Matrix m1 = new Matrix(askMatrix(dim,dim));
        Matrix result = m1.getInverse(m1);
        if(result!=null)
        {
            m1.print();
            System.out.println("Inversa = ");
            result.print();
        }
        else
        {
            System.out.println("Invalido");
        }
    }
    
    private static int getDim()
    {
        int num;
        do
        {
            System.out.print("Dimension: ");
            num = input.nextInt();
        }while(num<=1 || num>=6);
        return num;
    }
}
