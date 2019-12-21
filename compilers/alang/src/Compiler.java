import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class Compiler {

     public static void main(String[] args) throws Exception {
         /* Taken from exercise example */
         String inputFile = null;
         String outputFile = null;
         int i = 0;
         while (i < args.length) {
             if (args[i].equals("-o")) {
                 if (i < args.length - 1) {
                     outputFile = new String(args[i+1]);
                     i += 2;
                 }
                 else {
                     throw new IllegalArgumentException();
                 }
             }
             else {
                 inputFile = new String(args[i]);
                 i++;
             }
         }
         InputStream is = System.in;
         if (inputFile != null) {
             is = new FileInputStream(inputFile);
         }
         PrintStream ps = System.out;
         if (outputFile != null) {
             ps = new PrintStream(new FileOutputStream(outputFile));
         }

         CharStream in = CharStreams.fromStream(is);
         AlangLexer lexer = new AlangLexer(in);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         AlangParser parser = new AlangParser(tokens);

         ParseTree tree = parser.init();

         AlangMyVisitor visitor = new AlangMyVisitor();

         try {
             CodeFragment code = visitor.visit(tree);
             if (visitor.errorCount > 0) {
                 System.err.print(visitor.errors);
                 System.err.println(String.format("Compiling the program failed with %d errors", visitor.errorCount));
             } else {
                 ps.print(code.toString());
             }
         } catch (Exception e) {
              System.err.print(e.getMessage());
         }
     }
}
