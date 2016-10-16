/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on November 12, 2015, 9:14 PM
 */

#include <cstdio>
#include <cctype>

#define SUCCESS_CODE 1
#define ERR_LENGTH_CODE 2
#define ERR_LEVEL_CODE 3
#define ERR_BRACE_CODE 4

/* Global variables representing the number of current, next and max level */
int current_level = 0;
int next_level = 0;
int max_level = 0;

/* Sum of the lines of each level */
int levels[11] = {0};

/* Process each line of the input
 * Scan char by char and check for possible errors 
 * In case of error, immediately return specific error code
 *     - Otherwise, indent line by 4*k spaces, where k is current_level
 * Also add +1 to the level[] counter */
int process_line(char c)
{
    char line[101];
    int charsum = 0;
    bool comment = false;

    if (current_level > 9)
        return ERR_LEVEL_CODE;

    /* Remove whitespaces from beginning */
    while (isspace(c) && c != '\n')
        scanf("%c", &c);

    while (c != '\n') {
        /* In case of comment "//", do not increase/decrease level  */
        if (charsum > 0 && c == '/' && line[charsum-1] == '/')
            comment = true;

        line[charsum++] = c;
        if (charsum > 99)
            return ERR_LENGTH_CODE;
        
        if (!comment && c == '{')
            next_level++;
        else if (!comment && c == '}')
            next_level--;

        if (next_level < 0)
            return ERR_BRACE_CODE;

        if (scanf("%c", &c) == EOF)
            break;
    }
    
    /* If there were any non-whitespace characters,print them after 4k spaces */
    if (charsum > 0) {
        while (isspace(line[charsum-1]))
            charsum--;

        for (int i = 0; i < 4*(line[0] == '}' ? current_level-1 : current_level); i++)
            printf(" ");
        
        if (line[0] == '}' && current_level > 0)
            levels[current_level-1]++;
        else
            levels[current_level]++;

        for (int i = 0; i < charsum; i++)
            printf("%c", line[i]);
    }

    printf("\n");
    current_level = next_level;
    max_level = current_level > max_level ? current_level : max_level;
    return SUCCESS_CODE;
}

/* Take care of EOF
 * Break the function if process_line returns error code */
int iterate_lines(void)
{
    char c = ' ';
    int code;
    while (scanf("%c", &c) != EOF) {
        code = process_line(c);
        if (code != SUCCESS_CODE)
            return code;
    }
    if (current_level != 0)
        return ERR_BRACE_CODE;
    
    return SUCCESS_CODE;
}

/* Just call iterate_lines and process code returned by this function
 * On success, print sum of the lines of each level */
int main(void)
{
    int code;
    
    code = iterate_lines();

    switch (code) {
        case ERR_LENGTH_CODE:
            printf("ERR LENGTH\n");
            break;
        case ERR_LEVEL_CODE:
            printf("ERR LEVEL\n");
            break;
        case ERR_BRACE_CODE:
            printf("ERR BRACE\n");
            break;
        default:
            for (int i = 0; i < max_level+1; i++) {
                if (levels[i] > 0)
                    printf("// LEVEL %d LINES %d\n", i, levels[i]);
            }
            break;
    }

    return 0;
}