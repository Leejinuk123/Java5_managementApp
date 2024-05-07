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

   char mandatorySbjectGrade;
   char choiceSubjectGrade;

    //필수과목 점수별 등급
   public char mandatorySbjectGrade(int score) {
      if (95 <= score &&  score<= 100) {
          mandatorySbjectGrade = 'A';
      } else if (90 <= score &&  score < 95){
          mandatorySbjectGrade = 'B';
      } else if (80 <= score &&  score < 90){
          mandatorySbjectGrade = 'C';
      } else if (70 <= score &&  score < 80){
          mandatorySbjectGrade = 'D';
      } else if (60 <= score &&  score < 70){
          mandatorySbjectGrade = 'F';
      } else {
          mandatorySbjectGrade = 'N';
      }
      return mandatorySbjectGrade;
   }

   //선택과목 점수별 등급
   public char chioceSubjectGrade(int score){
      char chioceSubjectGrade;
      if (90 <= score &&  score<= 100) {
         chioceSubjectGrade = 'A';
      } else if (80 <= score &&  score < 90){
         chioceSubjectGrade = 'B';
      } else if (70 <= score &&  score < 80){
         chioceSubjectGrade = 'C';
      } else if (60 <= score &&  score < 70){
         chioceSubjectGrade = 'D';
      } else if (50 <= score &&  score < 60){
         chioceSubjectGrade = 'F';
      } else {
         chioceSubjectGrade = 'N';
      }
      return chioceSubjectGrade;
   }

   public String getStudentId(){
       return studentId;
   }

   // Getter
   public String getScoreId(String studentId) {
      return scoreId;
   }
   public int[] getSubjectScore() {
       return subjectScore;
   }
   public ArrayList<int[]> getScoreArray() {
       return scoreArray;
   }
}
