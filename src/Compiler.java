import AST.ASTBuilder;
import AST.RootNode;
import BackEnd.BuiltinPrinter;
import BackEnd.Infrastructure.ASMBuilder;
import BackEnd.Infrastructure.ASMModule;
import BackEnd.RegAllocation.GraphColor;
import FrontEnd.BuiltInitiator;
import FrontEnd.PreProcessor;
import FrontEnd.SemanticChecker;
//import MiddleEnd.IRBuilder;
//import MiddleEnd.IRModule;
import MiddleEnd.IRBuilder;
import MiddleEnd.IRModule;
import Optimization.Mem2Reg;
import Parser.MxLexer;
import Parser.MxParser;
import Utils.GlobalScope;
import Utils.MxErrorListener;
import Utils.SemanticError;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class Compiler {

    public static void main(String[] args) throws IOException {
        String name = "test.mx";
        //InputStream input = new FileInputStream(name);
        InputStream input = System.in;
        //PrintStream output = System.out;
        PrintStream os = new PrintStream("output.s");
        try {
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();

            ASTBuilder test = new ASTBuilder();
            RootNode rt = (RootNode) test.visit(parseTreeRoot);
            System.out.println(rt);

            GlobalScope gScope = new GlobalScope(null);
            BuiltInitiator initiator = new BuiltInitiator();
            gScope = initiator.init(gScope);
            PreProcessor preProcess = new PreProcessor(gScope);
            preProcess.visit(rt);

            SemanticChecker semanticChecker = new SemanticChecker(gScope);
            semanticChecker.visit(rt);

            //System.out.println("Semantic Run Success");
            IRModule module = new IRModule();
            IRBuilder irb = new IRBuilder(module, gScope);
            irb.visit(rt);
            irb.processGlobalInit();
            //System.out.println(module);
            Mem2Reg opt1 = new Mem2Reg(module);

            ASMBuilder asmB = new ASMBuilder();
            asmB.visit(module);
            System.out.println(asmB.output.printASM());
            GraphColor regAlloc = new GraphColor(asmB.output);
            os.println(asmB.output.printASM());
            new BuiltinPrinter().printBuiltin();

        } catch (SemanticError er) {
            System.err.println(er.getMessage());
            throw new RuntimeException();
        }
    }
}