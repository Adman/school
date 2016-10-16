#include <iostream>
#include "../SVGdraw.h"
using namespace std;

/* Funkcia do obrazku zadaneho parametrom drawing vykresli
 * stvorec so stredom v bode (x,y), s dlzkou strany size
 * a s farbou danou hodnotami (r,g,b). Funkcia tiez vypise
 * spravu o tomto stvorci vo formate specifikovanom v zadani. */
void square(SVGdraw &drawing, double x, double y, double size,
            int r, int g, int b) {
    double topleftx = x - (size/2);
    double toplefty = y - (size/2);
    
    cout << "suradnice " << topleftx << " " << toplefty << " velkost "
            << size << " farba " << r << " " << g << " " << b << endl;

    drawing.setFillColor(r, g, b);
    drawing.drawRectangle(topleftx, toplefty, size, size);
}

/* Funkcia spocita hodnotu farby, ktora ma ist od hodnoty start
 * po hodnotu end rovnomerne rozdelena medzi count krokov a
 * v sucasnosti sme na kroku i (i ma hodnotu od 0 po count-1).
 * Ak count je 1, vrati priemer pociatocnej a koncovej hodnoty.
 * Vo vypoctoch necelociselne hodnoty zaokruhli nadol. */
int color(int i, int count, int start, int end) {
    if(count>1) {
        return start + i * (end-start) / (count-1);
    } else {
        return (start+end)/2;
    }
}

/* Funkcia spocita pocet stvorcov v pyramide, ktorej najvacsi
 * stvorec ma velkost maxSize a kazdy dalsi je o step mensi. */
int numberOfSquares(int maxSize, int step) {
    return (maxSize + step-1) / step;
}

/* Nakresli pyramidu so stredom v bode (x,y), pricom najvacsi stvorec
 * ma velkost maxSize a kazdy dalsi je o step mensi. Najvacsi stvorec
 * ma farbu danu hodnotami (startR, startG, startB) a najmensi hodnotami
 * (endR, endG, endB). */
void pyramid(SVGdraw &drawing, int x, int y, int maxSize, int step,
             int startR, int startG, int startB, int endR, int endG, int endB) {
    int r, g, b;
    int squares = numberOfSquares(maxSize, step);
    
    for (int i = 0; i < squares; i++) {
        r = color(i, squares, startR, endR);
        g = color(i, squares, startG, endG);
        b = color(i, squares, startB, endB);
        square(drawing, x, y, maxSize-(i*step), r, g, b);
    }
}

int main(void) {
    int width;
    int height;
    int pyrs;

    int xmid, ymid, size, step, r1, g1, b1, r2, g2, b2;
    
    cin >> width >> height >> pyrs;
    
    SVGdraw drawing(width, height, "pyramidy.svg");
    
    for (int i = 0; i < pyrs; i++) {
        cin >> xmid >> ymid >> size >> step >> r1 >> g1 >> b1 >> r2 >> g2 >> b2;
        cout << "pyramida " << numberOfSquares(size, step) << endl;
        pyramid(drawing, xmid, ymid, size, step, r1, g1, b1, r2, g2, b2);
    }
}