import hello.HelloParser;
import hello.HelloLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
public class Main{
    public static void run(String expr) throws Exception{
        ANTLRInputStream input = new ANTLRInputStream(expr);
        HelloLexer lexer = new HelloLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        parser.r();
    }
    public static void main(String[] args) throws Exception{
        String[] testStr={
                "Hello world",
                "hello world",
                "hi world"
        };
        for (String s :testStr){
            System.out.println("Input: " + s);
            run(s);
        }
    }
}
