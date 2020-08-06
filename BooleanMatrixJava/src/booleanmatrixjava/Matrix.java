/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanmatrixjava;

/**
 *
 * @author Johann
 */
public class Matrix 
{
    public boolean[][] matrix;
    public int rowCount;
    public int columnCount;
    
    Matrix(int rows, int cols)
    {
        rowCount = rows;
        columnCount = cols;
        matrix = new boolean[rows][cols];
    }
    
    Matrix(boolean[][] data)
    {
        this.matrix = data; 
        this.rowCount = data.length;
        this.columnCount = data[0].length;
    }
    
    private boolean validOperation(Matrix m)
    {
        return m.rowCount == this.rowCount && m.columnCount == this.columnCount;
    }
    
    public Matrix getUnion(Matrix m1, Matrix m2)
    {
        if(m1.validOperation(m2))
        {
            Matrix result = new Matrix(m1.rowCount, m1.columnCount);
            for (int i = 0; i < m1.rowCount; i++) 
            {
                for (int j = 0; j < m1.columnCount; j++) 
                {
                    result.matrix[i][j] = m1.matrix[i][j] || m2.matrix[i][j];
                }
            }
            return result;
        }
        else
        {
            return null;
        }
    }
    
    public Matrix getConjunction(Matrix m1, Matrix m2)
    {
        if(m1.validOperation(m2))
        {
            Matrix result = new Matrix(m1.rowCount, m1.columnCount);
            for (int i = 0; i < m1.rowCount; i++) 
            {
                for (int j = 0; j < m1.columnCount; j++) 
                {
                    result.matrix[i][j] = m1.matrix[i][j] && m2.matrix[i][j];
                }
            }
            return result;
        }
        else
        {
            return null;
        }
    }
    
    public Matrix getInverse(Matrix m)
    {
        Matrix result = new Matrix(m.rowCount,m.columnCount);
        for (int i = 0; i < m.rowCount; i++) 
        {
            for (int j = 0; j < m.columnCount; j++) 
            {
                result.matrix[i][j] = !m.matrix[i][j];
            }
        }
        return result;
    }
    
    public Matrix getComplement(Matrix m)
    {
        Matrix result = new Matrix(m.rowCount,m.columnCount);
        for (int i = 0; i < m.rowCount; i++) 
        {
            for (int j = 0; j < m.columnCount; j++) 
            {
                result.matrix[i][j] = !m.matrix[i][j];
            }
        }
        return result;
    }
    
    public Matrix getComposition(Matrix m1, Matrix m2)
    {
        if(m1.columnCount == m2.rowCount)
        {
            Matrix result = new Matrix(m1.rowCount, m2.columnCount);
            for (int i = 0; i < m1.rowCount; i++) 
            {
                for (int j = 0; j < m2.columnCount; j++) 
                {
                    boolean eq = false;
                    for (int k = 0; k < m1.columnCount; k++) 
                    {
                        eq = eq || (m1.matrix[i][k] && m2.matrix[k][j]);
                    }
                    result.matrix[i][j] = eq;
                }
                
            }
            return result;
        }
        else
        {
            return null;
        }
    }
    
    public void print()
    {
        for(int i=0; i<this.rowCount;i++)
        {
            System.out.print("| ");
            for(int j=0; j<this.columnCount;j++)
            {
                String data = this.matrix[i][j] ? "1" : "0";
                System.out.print(data+" ");
            }
            System.out.println("|");
        }
    }
}
