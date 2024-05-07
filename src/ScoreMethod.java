//Score Method 구현 Class

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreMethod {
    public Scanner sc = new Scanner(System.in);

    boolean flag = true;
    while(flag){
        System.out.println("==================================");
        System.out.println("1. 수강생" + /*학생이름 + */ "의 과목별 시험 회차 및 점수 등록");
        System.out.println("2. 수강생" + /*학생이름 + */ "의 과목별 회차 점수 수정");
        System.out.println("3. 수강생" + /*학생이름 + */ "의 특정 과목 회차별 등급 조회");
        System.out.println("4. 메인 화면 이동");
        System.out.print("관리 항목을 선택하세요...");
        int input = sc.nextInt();

        switch (input) {
            case 1 -> enterScore(); // 수강생의 과목별 시험 회차 및 점수 등록
            case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
            case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
            case 4 -> flag = false; // 메인 화면 이동
            default -> {
                System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                flag = false;
            }
        }
    }
        //등록되어 있는 수강생의 과목별 시험점수 등록을 위한 메서드
    public static void enterScore(String studentId, String getSubjectName, int subjectSequence, int score){
        System.out.println("수강생" + StudentName + "의 점수를 등록합니다");
        System.out.println("등록할 과목을 입력해 주세요");
        String enrolledSubject = sc.nextLine();

        System.out.println("등록할 시험 회차를 입력해 주세요(숫자만)");
        int enrolledSubjectSequence = sc.nextInt();

        System.out.println("해당 시험회차의 점수를 입력해 주세요");
        int enrolledSubjectScore = sc.nextInt();

        System.out.println("시험 점수를 등록합니다...");
        Score.getscoreArray<int[enrolledSubjectSequence]> = enrolledSubjectScore

        System.out.println("\n점수 등록 성공!");
        System.out.println("더 등록하시겠습니까?");
        //구현시 주의사항. 시험 점수가 이미 등록되어 있다면 등록 불가 - 수정기능으로는 가능
    }
        // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject () {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        //수정: 과목이름 / 회차 / 점수 / 등급 입력 하면 한 번에 수정되어 저장

        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }
    //과목별 시험회차의 등급 조회 메서드
    public static inquireRoundGradeBySubject(String StudentId, String getSubjectName, int subjectSequence ){
        if (getSubjectName.equals(SubjectList.)) {
            char grade = Score.mandatorySbjectGrade();
            System.out.println(getSubjectName + "의 " + subjectSequence + "회차 등급은 " + ~ + "입니다.");
        } else if (getSubjectName.equals()) {
            char grade = Score.choiceSubjectGrade();
                    System.out.println(getSubjectName + "의 " + subjectSequence + "회차 등급은 " + ~ + "입니다.");
        } else {
            System.out.println("등록된 점수가 없습니다");
        }
        return grade;
    }
}