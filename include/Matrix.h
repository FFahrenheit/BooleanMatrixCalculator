#ifndef MATRIX_H
#define MATRIX_H

class Matrix
{
    public:
        int cols, rows;
        bool matrix[6][6];
        Matrix();
        Matrix(int,int);
        ~Matrix();
        void getUnion(Matrix &,Matrix &);
        bool isValid(Matrix);
        void print();
    protected:
    private:
};

#endif // MATRIX_H
