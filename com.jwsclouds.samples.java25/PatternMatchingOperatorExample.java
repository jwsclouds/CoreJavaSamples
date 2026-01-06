public class PatternMatchingOperatorExample {

    void patternMatch(Number number){
        if (number instanceof Integer data && data.intValue()==5) {
            data = 10;
            System.out.println("Given number is Integer Type and its value is = "+data) ;
        }if (number instanceof final Integer data && data.intValue()==3) {
            System.out.println("Given number is Integer Type with final and its value is = "+data) ;
        } else if (number instanceof Float data && data.floatValue()==10.10f) {
            System.out.println("Given number is Float Type and its value is = "+data) ;
        }else if (number instanceof Float data &&  data.floatValue()>15f) {
            System.out.println("Given number is Float Type and its value is greater than 10.01 = "+data) ;
        }else if(number instanceof Number data){
            System.out.println("Given number is Number Type = "+data) ;
        }
        String s=null;
        if(s instanceof  String s2){
            System.out.println("null excuted");
        }else{
            System.out.println("null can't be checked using pattern matching operator");
        }
    }

    public void main(String[] args) {
    Number number = 10;
    Float floatNumber = 10.10f;
    patternMatch(number);
    patternMatch(floatNumber);
    patternMatch(20.01f);
    patternMatch(5);
    patternMatch(3);
    }
}
