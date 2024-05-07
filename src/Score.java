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

   char mandatorySubjectGrade;
   char choiceSubjectGrade;

    //필수과목 점수별 등급
   public char mandatorySubjectGrade(int score) {
      if (95 <= score ) {
          mandatorySubjectGrade = 'A';
      } else if (90 <= score ){
          mandatorySubjectGrade = 'B';
      } else if (80 <= score ){
          mandatorySubjectGrade = 'C';
      } else if (70 <= score ){
          mandatorySubjectGrade = 'D';
      } else if (60 <= score ){
          mandatorySubjectGrade = 'F';
      } else {
          mandatorySubjectGrade = 'N';
      }
      return mandatorySubjectGrade;
   }

   //선택과목 점수별 등급
   public char chioceSubjectGrade(int score){
      char chioceSubjectGrade;
      if (90 <= score ) {
         chioceSubjectGrade = 'A';
      } else if (80 <= score ){
         chioceSubjectGrade = 'B';
      } else if (70 <= score ){
         chioceSubjectGrade = 'C';
      } else if (60 <= score ){
         chioceSubjectGrade = 'D';
      } else if (50 <= score ){
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
