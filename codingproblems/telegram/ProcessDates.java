package codingproblems.telegram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDates {

    public static List<String> preprocessDate(List<String> dates) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        List<String> convertedDates = new ArrayList<>();

        for (String date : dates) {
            String[] parts = date.split(" ");
            String day = parts[0];
            String month = months.get(parts[1]);
            String year = parts[2];

            day = day.replaceAll("[a-zA-Z]", "");
            if (day.length() == 1) {
                day = "0" + day;
            }

            String newDate = year + "-" + month + "-" + day;
            convertedDates.add(newDate);
        }

        return convertedDates;
    }

    public static void main(String[] args) {
        System.out.println(preprocessDate(List.of("1st Mar 1974", "22nd Jan 2013", "7th Apr 1904")));
    }
}
