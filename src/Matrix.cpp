#include "Matrix.h"
#include <iostream>

using namespace std;

Matrix::Matrix(int c, int r)
{
    this->rows = r;
    this->cols = c;
    system("cls");
    cout << "Ingrese 1 o 0 segun corresponda en la posicion\n";
    for(int i=0; i<rows;i++)
    {
        for(int j=0;j<rows;j++)
        {
            int data;
            do
            {
                cout << "Ingrese el valor en la fila" << i << ", columna "<<j<<": ";
                cin >> data;
                if(data!=1 && data!=0)
                {
                    cout << "Solo ingrese 1 o 0\n";
                }
            }while(data!= 1 && data!= 0);
            matrix[i][j] = (bool)data;
        }
    }
}

void Matrix::print()
{
    for(int i=0; i<rows;i++)
    {
        cout << "| ";
        for(int j=0; j<cols;j++)
        {
            cout << matrix[i][j]<< " ";
        }
        cout << "|" << endl;
    }
}

bool Matrix::isValid(Matrix m1)
{
    return m1.cols == this->cols && m1.rows == this->rows;
}

void Matrix::getUnion(Matrix &m1, Matrix &m2)
{
    if(m1.isValid(m2))
    {
        this->rows = m1.cols;
        this->cols = m1.rows;
        for(int i=0; i<this->rows;i++)
        {
            for(int j=0; j<this->cols;j++)
            {
                this->matrix[i][j] = (bool) m1.matrix[i][j] || m2.matrix[i][j];
            }
        }
    }
}

Matrix::~Matrix()
{
}

Matrix::Matrix()
{
    this->rows = 0;
    this->cols = 0;
}
