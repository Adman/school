/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on October 20, 2015, 5:44 PM
 */

#include <iostream>
#include <cmath>
#include "../SVGdraw.h"

using namespace std;

double sum[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

struct col {
    int r, g, b;
};

/* Draw a rectangle around x and y with size of d */
void rect(SVGdraw &drawing, double x, double y, double d, col &f, bool paralel)
{
    drawing.setFillColor(f.r, f.g, f.b);
    if (paralel) {
        drawing.drawRectangle(x - d / 2, y - d / 2, d, d);
    } else {
        double offset = d / sqrt(2);
        drawing.startPolygon(x - offset, y);
        drawing.addPolygonPoint(x, y - offset);
        drawing.addPolygonPoint(x + offset, y);
        drawing.addPolygonPoint(x, y + offset);
        drawing.drawPolygon();
    }
}

/* Recursive function which goes through all the levels of fractal
 * and draws them. It also sums up the area of each rect and saves to global*/
void fractal(SVGdraw &drawing, int level, double width, double ratio,
        col colors[], double x, double y, bool paralel)
{
    double diag;
    double diff = 0;
    double back = 0;
    
    if (level < 1)
        return;
    
    sum[level-1] += width*width;
    
    rect(drawing, x, y, width, colors[level-1], paralel);
    
    /* If the rect is not paralel, we have to modify some of the positions.
       Otherwise, diff and back stay zero and will not affect the pos of rects*/
    if (!paralel) {
        diag = sqrt(2*((width/2)*(width/2)));
        diff = diag-(width/2);
        back = width/2;
    }

    /* TopLeft corner */
    fractal(drawing, level-1, width*ratio, ratio, colors,
            x-(width/2)+back, y-(width/2)-diff, !paralel);

    /* TopRight corner */
    fractal(drawing, level-1, width*ratio, ratio, colors,
            x+(width/2)+diff, y-(width/2)+back, !paralel);

    /* BottomLeft corner */
    fractal(drawing, level-1, width*ratio, ratio, colors,
            x-(width/2)-diff, y+(width/2)-back, !paralel);

    /* BottomRight corner */
    fractal(drawing, level-1, width*ratio, ratio, colors,
            x+(width/2)-back, y+(width/2)+diff, !paralel);
}

int main(void)
{
    int level;
    double width;
    double ratio;
    col colors[6];

    /* Read the level, max width and ratio of fractal */
    cin >> level >> width >> ratio;
    
    /* Read color for each level of fractal */
    for (int i = 0; i < level; i++) {
        cin >> colors[i].r >> colors[i].g >> colors[i].b;
    }
    
    SVGdraw drawing(3*width, 3*width, "fraktal.svg");

    /* Draw Fractal recursively */
    fractal(drawing, level, width, ratio, colors,
            (3*width)/2, (3*width)/2, true);
    
    /* Print the sum of rect areas on different levels */
    for (int j = 0; j < level; j++)
        cout << sum[j] << endl;
    
    drawing.finish();

    return 0;
}