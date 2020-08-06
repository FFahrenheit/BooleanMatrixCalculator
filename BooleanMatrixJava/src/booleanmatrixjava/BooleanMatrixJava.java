/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanmatrixjava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Johann
 */
public class BooleanMatrixJava
{ 
    public static Scanner input;
    public static ArrayList<Matrix> matrices;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        input = new Scanner(System.in);
        matrices = new ArrayList<>();
        String menu;
        int choice;
        do
        {
            System.out.println("Ingrese la opción a probar");
            System.out.println("0:Agregar matriz\n1:Union\n2:Conjuncion\n3:Complemento\n4:Inversa");
            System.out.println("5:Composicion:\n6:Ver matrices\n7:Salir");
            System.out.print("Tu elección: ");
            menu = input.next();
            choice = validNumber(menu)? Integer.parseInt(menu) : -1;
            switch(choice)
            {
                case 0:
                    agregar();
                    break;
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
                    mostrar();
                    break;
                case 7:
                    System.out.println("¡Gracias!");
                    break;
                default:
                    System.out.println("Pruebe de nuevo");
                    break;
            }
            if(choice!=7)
            {
                System.out.print("Presione una tecla y enter para continuar");
                input.next();
            }
        }while(choice!=7);    
    }
    
    private static void mostrar()
    {
        if(matrices.isEmpty())
        {
            System.out.println("No hay matrices");
        }
        else
        {
            String choice;
            System.out.println("Elija la matriz de su preferencia: ");
            for (int i = 0; i < matrices.size(); i++) 
            {
                System.out.println("["+(i+1)+"]: Matriz "+(i+1)+" ("+matrices.get(i).rowCount+"x"+matrices.get(i).columnCount+")");
            }
            do
            {
                System.out.print("Eleccion: ");
                choice = input.next();
            }while(!validNumber(choice) || Integer.parseInt(choice)<=0 || Integer.parseInt(choice)>matrices.size());
            matrices.get(Integer.parseInt(choice) - 1).print();
        }
    }
    
    private static void agregar()
    {
        System.out.println("Ingrese el tamaño de la matriz: ");
        int num = getDim();
        matrices.add(new Matrix(askMatrix(num, num)));
    }
        
    
    private static boolean[][] askMatrix(int _rows , int _cols)
    {
        boolean[][] matrix = new boolean[_rows][_cols];
        System.out.println("Ingrese 1 o 0 segun corresponda");
        for(int i=0; i<_rows; i++)
        {
            for (int j = 0; j <_cols; j++) 
            {
                String value;
                do
                {
                    System.out.print("Ingrese el miembro ["+i+"]["+j+"]: ");
                    value = input.next();
                }while(!validNumber(value) || (Integer.parseInt(value) != 0 && Integer.parseInt(value) !=1));
                matrix[i][j] = Integer.parseInt(value) == 1;
            }
        }
        return matrix;
    }
    
    private static Matrix getMatrix()
    {
        if(matrices.isEmpty())
        {
            return null;
        }
        String choice;
        System.out.println("Elija la matriz de su preferencia: ");
        for (int i = 0; i < matrices.size(); i++) 
        {
            System.out.println("["+(i+1)+"]: Matriz "+(i+1)+" ("+matrices.get(i).rowCount+"x"+matrices.get(i).columnCount+")");
        }
        do
        {
            System.out.print("Eleccion: ");
            choice = input.next();
        }while(!validNumber(choice) || Integer.parseInt(choice)<=0 || Integer.parseInt(choice)>matrices.size());
        return matrices.get(Integer.parseInt(choice) - 1);
    }
    
    private static void union()
    {
        if(matrices.isEmpty())
        {
            System.out.println("Ingrese primero matrices");
            return;
        }
        Matrix m1 = getMatrix();
        Matrix m2 = getMatrix();
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
        if(matrices.isEmpty())
        {
            System.out.println("Ingrese primero matrices");
            return;
        }
        Matrix m1 = getMatrix();
        Matrix m2 = getMatrix();
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
        if(matrices.isEmpty())
        {
            System.out.println("Ingrese primero matrices");
            return;
        }
        Matrix m1 = getMatrix();
        Matrix m2 = getMatrix();
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
        if(matrices.isEmpty())
        {
            System.out.println("Ingrese primero una matriz");
            return;
        }
        Matrix m1 = getMatrix();
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
        if(matrices.isEmpty())
        {
            System.out.println("Ingrese primero una matriz");
            return;
        }
        Matrix m1 = getMatrix();
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
        String num;
        do
        {
            System.out.print("Dimension: ");
            num = input.next();
        }while(!validNumber(num) || Integer.parseInt(num)>6 || Integer.parseInt(num)<=1);
        return Integer.parseInt(num);
    }
    
    private static boolean validNumber(String num)
    {
        try
        {
            Integer.parseInt(num);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
