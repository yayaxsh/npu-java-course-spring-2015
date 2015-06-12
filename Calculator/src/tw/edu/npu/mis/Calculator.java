/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends Subject {
    String s = "",a;
    int count,count2;
    
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    
    public void appendDigit(int digit) {
       s += String.valueOf(digit);
        getDisplay();
        // TODO code application logic here
    }
    
    public void appendDot(String dot) {
         s += dot;
         getDisplay();
      
    }
    
    public void performOperation(Operator operator) {
           if(operator == Operator.PLUS)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "+";
        }
        
        if(operator == Operator.MINUS)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "-";
        }
          if(operator == Operator.TIMES)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "*";
        }
         
         if(operator == Operator.OVER)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          a = "/";
        }
         if(operator == Operator.EQUAL)
        {
            if(a =="+")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count+count2);
                getDisplay();
                s= "";
            }
            if(a =="-")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count-count2);
                getDisplay();
                s= "";
            }
                 if(a =="*")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count*count2);
                getDisplay();
                s= "";
            }
              if(a =="/")
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count/count2);
                getDisplay();
                s= "";
            }

        }
    }
    
    public String getDisplay() {
       notifyObserver(s);
       return null;
    }
      public void setOperation(String text)
    {
        if(text == "*") performOperation (Operator.TIMES);
        if(text == "/") performOperation (Operator.OVER);
    }
  
}
