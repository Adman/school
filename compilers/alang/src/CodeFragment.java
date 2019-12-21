public class CodeFragment {

     private String code;
     private String register;
     private boolean isCharRegister = false;

     public CodeFragment() {
         this.code = "";
         this.register = null;
     }

     public CodeFragment(String code) {
         this();
         addCode(code);
     }

     public CodeFragment(String code, String register) {
         this();
         addCode(code);
         setRegister(register);
     }

     public String toString() {
         return this.code;
     }

     public void addCode(String code) {
         this.code += code;
     }

     public void addCode(CodeFragment fragment) {
         this.code += fragment.toString();
     }

     public void setRegister(String register) {
         this.register = register;
     }

     public String getRegister() {
         return this.register;
     }

     public void setCharRegister() {
         this.isCharRegister = true;
     }

     public boolean getIsCharRegister() {
         return this.isCharRegister;
     }
}
