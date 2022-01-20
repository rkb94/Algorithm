package NTS2022;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 날짜 {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat holidayDateFormat = new SimpleDateFormat("mm/dd");

    public int solution(String join_date, String resign_date, String[] holidays) {
        int answer = 0;
        Calendar getToday = Calendar.getInstance();
        try {
            Date joinDate = dateFormat.parse(join_date.substring(0, 10));
            Date resignDate = dateFormat.parse(resign_date);
            long diffSec = (resignDate.getTime() - joinDate.getTime()) / 1000;
            long diffDays = diffSec / (24*60*60);
            System.out.println(joinDate);
            System.out.println(resignDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return answer;
    }
}
