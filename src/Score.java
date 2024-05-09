import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Score {
    private String studentId;
    private String scoreId;
    private int score;
    private char grade;

    private int[] subjectScore = new int[10];
    private ArrayList<int[]> scoreArray = new ArrayList<int[]>(); //과목별 10회차 점수가 담긴 2차원 배열

    public Score(String seq) {
        this.scoreId = seq;
    }

    //필수과목 점수별 등급
    public static char grade(int score, String type) {
        char grade = 'Z';
        switch (type) {
            case "mandatory":
                if (score >= 95) {
                    grade = 'A';
                } else if (score >= 90) {
                    grade = 'B';
                } else if (score >= 80) {
                    grade = 'C';
                } else if (score >= 70) {
                    grade = 'D';
                } else if (score >= 60) {
                    grade = 'F';
                } else {
                    grade = 'N';
                }
                break;

            case "choice":
                if (score >= 90) {
                    grade = 'A';
                } else if (score >= 80) {
                    grade = 'B';
                } else if (score >= 70) {
                    grade = 'C';
                } else if (score >= 60) {
                    grade = 'D';
                } else if (score >= 50) {
                    grade = 'F';
                } else {
                    grade = 'N';
                }
                break;
        }
        return grade;
    }
}