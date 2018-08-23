import java.util.*;
class ClockHands{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine().trim();
        int hour = Integer.valueOf(time.split(":")[0]);
        int minute = Integer.valueOf(time.split(":")[1]);
        int angle = calculateAngle(hour, minute);
        System.out.println(angle);
    }
    public static int calculateAngle(int hour, int minute){
        int hourAngle = (hour % 12) * 30 + (minute % 60)/2;
        int minuteAngle = (minute % 60) * 6;
        return absolute(hourAngle, minuteAngle);
    }
    public static int absolute(int hourAngle, int minuteAngle){
        int angle = 0;
        if(hourAngle > minuteAngle){
            angle = hourAngle - minuteAngle;
        } else {
  angle = minuteAngle - hourAngle;
        }
        return angle;
    }
}
