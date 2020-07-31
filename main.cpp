#include <iostream>
#include "Matrix.h"

using namespace std;

void calculateUnion();
int getDimension();

int main()
{
    char opc;
    do
    {
        system("cls");
        cout << "Bienvenido a la calculadora de Matrices booleanas\nSelecciona la opcion deseada\n";
        cout << "[1]: Union\n[2]: Conjuncion\n[n]: Salir\nOpcion: ";
        cin >> opc;
        switch(opc)
        {
            case '1':
                calculateUnion();
                break;
            default:
                 cout << "Ingrese una opcion valida\n";
                 system("pause");
                 break;
        }
    }while(opc != 'n');
    return 0;
}

void calculateUnion()
{
    int n = getDimension();
    Matrix m1 = Matrix(n,n);
    Matrix m2 = Matrix(n,n);
    Matrix m3 = Matrix(n,n);
    m3.getUnion(m1,m2);
    if(m3.cols != 0)
    {
        m1.print();
        cout << "      U\n";
        m2.print();
        cout << "      =\n";
        m3.print();
        system("pause");
    }
    else
    {
        cout << "No se pudo ejecutar la operacion\n";
    }
    system("pause");
}

int getDimension()
{
    system("cls");
    int n;
    cout << "Ingrese la dimension de las matrices.";
    do
    {
        cout << "La dimension debe ser entre 2 y 6. Dimension: ";
        cin >>n;
    }while(n<=1 || n>6);
    return n;
}
