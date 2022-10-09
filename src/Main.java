import AST.ASTBuilder;
import AST.RootNode;
import Parser.MxLexer;
import Parser.MxParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws Exception {
        String name = "basic-1.mx";
        InputStream input = new FileInputStream(name);
        //InputStream input = System.in;
        PrintStream output = System.out;
        //try {
        MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            /*lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListerner());*/
        MxParser parser = new MxParser(new CommonTokenStream(lexer));
            /*parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListerner());*/
        ParseTree parseTreeRoot = parser.program();

        ASTBuilder test = new ASTBuilder();
        RootNode rt = (RootNode) test.visit(parseTreeRoot);
        System.out.println(rt);
        //}
    }
}