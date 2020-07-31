#include <iostream>
#include "Matrix.h"

using namespace std;

void calculateUnion();
void calculateConjunction();
void calculateComplement();
int getDimension();

int main()
{
    char opc;
    do
    {
        system("cls");
        cout << "Bienvenido a la calculadora de Matrices booleanas\nSelecciona la opcion deseada\n";
        cout << "[1]: Union\n[2]: Conjuncion\n[3]: Complemento\n[n]: Salir\nOpcion: ";
        cin >> opc;
        switch(opc)
        {
            case '1':
                calculateUnion();
                break;
            case '2':
                calculateConjunction();
                break;
            case '3':
                calculateComplement();
                break;
            default:
                 cout << "Ingrese una opcion valida\n";
                 system("pause");
                 break;
        }
    }while(opc != 'n');
    return 0;
}

void calculateConjunction()
{
    int n = getDimension();
    Matrix m1 = Matrix(n,n);
    Matrix m2 = Matrix(n,n);
    Matrix m3 = Matrix();
    m3.getConjunction(m1,m2);
    if(m3.cols != 0)
    {
        system("cls");
        m1.print();
        cout << "      ^\n";
        m2.print();
        cout << "      =\n";
        m3.print();
    }
    else
    {
        cout << "No se pudo ejecutar la operacion\n";
    }
    system("pause");
}

void calculateUnion()
{
    int n = getDimension();
    Matrix m1 = Matrix(n,n);
    Matrix m2 = Matrix(n,n);
    Matrix m3 = Matrix();
    m3.getUnion(m1,m2);
    if(m3.cols != 0)
    {
        system("cls");
        m1.print();
        cout << "      U\n";
        m2.print();
        cout << "      =\n";
        m3.print();
    }
    else
    {
        cout << "No se pudo ejecutar la operacion\n";
    }
    system("pause");
}

void calculateComplement()
{
    int n = getDimension();
    Matrix m = Matrix(n,n);
    Matrix res;
    res.getComplement(m);
    if(res.cols !=0)
    {
        system("cls");
        m.print();
        cout << "Complemento =\n";
        res.print();
    }
    else
    {
        cout << "No se pudo calcular el complemento\n";
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
