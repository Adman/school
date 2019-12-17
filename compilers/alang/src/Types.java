public class Types {
    public static final String LLVMCISLO = "i32";
    public static final String LLVMBOOL = "i32";
    public static final String LLVMZNAK = "i8";
    public static final String LLVMVOID = "void";

    public static final String LLVMCISLOPOINTER = "i32*";
    public static final String LLVMBOOLPOINTER = "i32*";
    public static final String LLVMZNAKPOINTER = "i8*";

    public static final String CISLO = "CISLO";
    public static final String BOOL = "BOOL";
    public static final String ZNAK = "ZNAK";
    public static final String VOID = "VOID";

    public static String getLLVMDefineVartype(String type) {
        if (type.equals(CISLO))
            return LLVMCISLO;
        else if (type.equals(BOOL))
            return LLVMBOOL;
        else if (type.equals(ZNAK))
            return LLVMZNAK;
        return null;
    }

    public static String pointers(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public static String getLLVMArgtype(String type) {
        if (type.equals(CISLO))
            return LLVMCISLO;
        else if (type.equals(BOOL))
            return LLVMBOOL;
        else if (type.equals(ZNAK))
            return LLVMZNAK;

        if (type.contains("[]")) {
            String type2 = type.replaceAll("\\[\\]", "");
            int count = (type.length() - type2.length()) / 2;
            if (type2.equals(CISLO))
                return LLVMCISLOPOINTER;
            else if (type2.equals(BOOL))
                return LLVMBOOLPOINTER;
            else if (type2.equals(ZNAK))
                return LLVMZNAKPOINTER;
        }
        return null;
    }

    public static String getLLVMReturntype(String type) {
        if (type.equals(CISLO))
            return LLVMCISLO;
        else if (type.equals(BOOL))
            return LLVMBOOL;
        else if (type.equals(ZNAK))
            return LLVMZNAK;
        else if (type.equals(VOID))
            return LLVMVOID;
        return null;
    }
}
