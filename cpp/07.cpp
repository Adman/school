/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on November 5, 2015, 9:23 PM
 */

#include <iostream>

using namespace std;

/* Print column by column from grid */
void print_grid(int rows, int cols, char **grid)
{
    for (int col = 0; col < cols; col++) {
        for (int row = 0; row < rows; row++) {
            if (grid[row][col] != '#')
                cout << grid[row][col];
        }
    }
}

/* Frees memory of dynamic 2D char array */
void free_memory(int rows, char **grid)
{
    for (int i = 0; i < rows; i++) {
        delete[] grid[i];
    }
    delete[] grid;
}

/* Encrypts password using secret algorithm :-) */
void encrypt(int rows, int cols, char **grid, char password[])
{
    int i = 0;
    int row = 0;
    int col = 0;
    while (password[i] != 0) {
        if (row == rows && col == 0 && password[i] != 0) {
            print_grid(rows, cols, grid);
            row = 0;
            col = 0;
            continue;
        }

        if (grid[row][col] != '#')
            grid[row][col] = password[i++];

        col++;
        if (col == cols) {
            col = 0;
            row++;
        }
    }
    
    /* If there is an unfilled space in grid, fill it with spaces */
    if (row < rows || col < cols) {
        for ( ; row < rows; row++) {
            for ( ; col < cols; col++) {
                if (grid[row][col] != '#')
                    grid[row][col] = ' ';
            }
            col = 0;
        }
    }

    print_grid(rows, cols, grid);
    cout << endl;
}

int main(void)
{
    int rows;
    int cols;
    char character;
    
    char password[5001];
    char *trash = new char;
    
    /* Read number of rows and columns of the grid
     * And also read end of the line to not mess the grid */
    cin >> rows >> cols;
    cin >> noskipws >> *trash;
    delete trash;
    
    /* Read input and save save it to 2D dynamic array */
    char **grid = new char*[rows];
    for (int i = 0; i < rows; i++) {
        grid[i] = new char[cols];
        
        for (int j = 0; j < cols+1; j++) {
            cin >> character;
            if (character != '\n')
                grid[i][j] = character;
        }
    }

    /* Read text that will be encrypted */
    cin.getline(password, 5000);
    
    encrypt(rows, cols, grid, password);

    /* Deallocate 2D array */
    free_memory(rows, grid);

    return 0;
}
