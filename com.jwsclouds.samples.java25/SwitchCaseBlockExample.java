public class SwitchCaseBlockExample {

    public enum DAYS {
        SUNDAY,MONDAY, TUESDAY, WEDNESDAY, THURSAY,FRIDAY,SATURDAY;
    }
    public String howIstheDay(DAYS day) {
        String howIsTheDay = switch (day){
            case DAYS.MONDAY -> {
                //yield example
                yield "Lot of Meetings!! Its going to be hectic day!";
            }
            case DAYS.TUESDAY -> "Tuesday went well!"; // using arraow ->
            case DAYS.WEDNESDAY -> "Wednesday went well!"; // using arrow ->

            //pattern match with guard
            //thursday is pattern variable and when equals is a guard
            case DAYS thursday when thursday.equals(DAYS.THURSAY) -> "Thursday went well!";
            case DAYS friday when friday.equals(DAYS.FRIDAY) -> "Friday went well and weekend started!";
            case DAYS saturday when saturday.equals(DAYS.SATURDAY) -> "Oh no!Its a deployment day!";
            case DAYS sunday when sunday.equals(DAYS.SUNDAY) ->  "Yeah! After deployment,Sunday is a peaceful and sleepy day!";

            //exhaustive statement
            default -> throw new IllegalStateException("Your day falls in Alien world calendar! " + day);
        }; //semicolon which is switch expression end syntax
        return howIsTheDay;
    }
    void main(String[] args) {
        System.out.println(howIstheDay(DAYS.MONDAY));
        System.out.println(howIstheDay(DAYS.TUESDAY));
        System.out.println(howIstheDay(DAYS.WEDNESDAY));
        System.out.println(howIstheDay(DAYS.THURSAY));
        System.out.println(howIstheDay(DAYS.FRIDAY));
        System.out.println(howIstheDay(DAYS.SATURDAY));
        System.out.println(howIstheDay(DAYS.SUNDAY));
    }
}
