package code2019;

public class day4 {
    public static void main(String[] args) {
        
        int sum = 0;
        
        for(int i = 256310; i <= 732736; i++){
            
            boolean consecutive = false;
            boolean decreasing = true;
            
            String number = Integer.toString(i);
            if(number.contains("00") || number.contains("11") || number.contains("22") || number.contains("33") ||
               number.contains("44") || number.contains("55") || number.contains("66") || number.contains("77") ||
                number.contains("88") || number.contains("99")){
                
                consecutive = true;
            }
            
            for(int j = 0; j < 6-1; j++){
                int num1 = Character.getNumericValue(number.charAt(j));
                int num2 = Character.getNumericValue(number.charAt(j+1));
                if(num1>num2)
                    decreasing = false;
            }
            
            if(consecutive&&decreasing)
                sum++;
        }
        
        System.out.println(sum);
    }
    
    
}
