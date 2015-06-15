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
    int count,count2; double b;
    
    
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
        MEM_RECALL,   // MR
        BACK
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
        if(operator ==Operator.PERCENT)
        {
              switch(s)
            {
                case "":
                    break;
                default:
                      if(operator ==Operator.PERCENT)
                 {
                     b = Double.parseDouble(s);
                     b = b/100;
                     s = String.valueOf(b);
                     getDisplay();
                 }
                    break;
            }
        }
           if(operator == Operator.PLUS_MINUS)
        {
            switch(s)
            {
                case "":
                    break;
                default:
                 if(Double.parseDouble(s)>0)
                  {          
                       s = "-"+ s;
                       getDisplay();
                  }else{
                       s =  String.valueOf(Math.abs(Double.parseDouble(s))) ;
                        if(s.indexOf(".0")==s.length()-2)
                        {
                            s =  String.valueOf((int)Math.abs(Double.parseDouble(s))) ;
                            getDisplay();
                        } 
                 }
                    break;
            }  
        }
           if(operator == Operator.CLEAR)
        {
            switch(s)
            {
                case "":
                    break;
                default:
                s = "0";
                getDisplay();
                s ="";
                    break;
            }
        }
        if(operator == Operator.BACK)
        {
            switch(s)
            {
                case "":
                    break;
                default:
               if(s.length()>0) {
                    s = s.substring(0,s.length()-1);
                    if(s.length()==0)
                   {
                        s= "0"; 
                        getDisplay();
                         s = "";
                   }
                    else
                    {
                        getDisplay();
                    }
               }
                    break;
            }
        }
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
