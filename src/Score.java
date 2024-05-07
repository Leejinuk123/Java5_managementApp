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
      if ( score >= 95) {
          mandatorySubjectGrade = 'A';
      } else if ( score >= 90 ){
          mandatorySubjectGrade = 'B';
      } else if ( score >= 80){
          mandatorySubjectGrade = 'C';
      } else if ( score >= 70 ){
          mandatorySubjectGrade = 'D';
      } else if ( score >= 60){
          mandatorySubjectGrade = 'F';
      } else {
          mandatorySubjectGrade = 'N';
      }
      return mandatorySubjectGrade;
   }

   //선택과목 점수별 등급
   public char chioceSubjectGrade(int score){
      char chioceSubjectGrade;
      if ( score >= 90 ) {
         chioceSubjectGrade = 'A';
      } else if ( score >= 80 ){
         chioceSubjectGrade = 'B';
      } else if ( score >= 70 ){
         chioceSubjectGrade = 'C';
      } else if ( score >= 60 ){
         chioceSubjectGrade = 'D';
      } else if ( score >= 50){
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
