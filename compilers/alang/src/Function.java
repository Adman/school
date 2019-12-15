import java.util.*;

public class Function {
    public String name;
    public String returntype;
    public ArrayList<String> args = new ArrayList<String>();

    public Function(String name, String returntype) {
        this.name = name;
        this.returntype = returntype;
    }

    public void addArgumentLLVMType(String argtype) {
        this.args.add(argtype);
    }
}
