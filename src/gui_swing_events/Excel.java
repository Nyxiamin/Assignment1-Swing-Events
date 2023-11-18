package gui_swing_events;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
    private ArrayList<Double> numbers;
    public Excel(ArrayList<Double> numbers) {
        this.numbers = numbers;
    }

    public Excel(String input) {
        List<String> strNumList = Arrays.asList(input.split("\\s* \\s*"));
        ArrayList<Double> numbers = new ArrayList<>();
        strNumList.forEach(strNum -> {
            numbers.add(Double.parseDouble(strNum));
        });
        this.numbers = numbers;
    }

    public double findTotal() {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }
    public double findAvg() {
        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
    public double findMax() {
        return numbers.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }
    public double findMin() {
        return numbers.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }
}
