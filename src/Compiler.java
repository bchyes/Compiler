import AST.ASTBuilder;
import AST.RootNode;
import FrontEnd.BuiltInitiator;
import FrontEnd.PreProcessor;
import FrontEnd.SemanticChecker;
import Parser.MxLexer;
import Parser.MxParser;
import Utils.GlobalScope;
import Utils.SemanticError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Compiler {

    public static void main(String[] args) throws IOException {
        String name = "test.mx";
        //InputStream input = new FileInputStream(name);
        InputStream input = System.in;
        //PrintStream output = System.out;
        try {
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            /*lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListerner());*/
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            /*parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListerner());*/
            ParseTree parseTreeRoot = parser.program();

            ASTBuilder test = new ASTBuilder();
            RootNode rt = (RootNode) test.visit(parseTreeRoot);
            //System.out.println(rt);

            GlobalScope gScope = new GlobalScope(null);
            BuiltInitiator initiator = new BuiltInitiator();
            gScope = initiator.init(gScope);
            PreProcessor preProcess = new PreProcessor(gScope);
            preProcess.visit(rt);

            SemanticChecker semanticChecker = new SemanticChecker(gScope);
            semanticChecker.visit(rt);

            //System.out.println("Semantic Run Success");
        } catch (SemanticError er) {
            System.err.println(er.getMessage());
            throw new RuntimeException();
        }
    }
}