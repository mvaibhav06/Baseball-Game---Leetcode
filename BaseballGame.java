import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class BaseballGame {
    public static int calScore(String[] operations){
        List<Integer> score = new ArrayList<>();

        for (int i=0; i<operations.length; i++){
            char[] charArray = operations[i].toCharArray();
            char ch = charArray[0];
            if (Character.isDigit(ch)){
                score.add(Integer.parseInt(operations[i]));
            } else if (Character.isLetter(ch)) {
                if (ch == 'D'){
                    score.add(2*score.get(score.size()-1));
                }else {
                    score.remove(score.get(score.size()-1));
                }
            }else if (ch == '+'){
                score.add(score.get(score.size()-1) + score.get(score.size()-2));
            }else {
                score.add(Integer.parseInt(operations[i]));
            }
        }

        IntSummaryStatistics statistics = score.stream().mapToInt(x -> x).summaryStatistics();
        return (int) statistics.getSum();
    }
    public static void main(String[] args) {
        String[] a = {"1","C"};
        calScore(a);
    }
}
