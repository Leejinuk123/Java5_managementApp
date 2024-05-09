import java.util.*;
// dev로 가자

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class ManagementMain {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;


    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static final Scanner sc = new Scanner(System.in);


    // 실행부분
    public static void main(String[] args) {
        setInitData(); //데이터 생성.
        for (String string : SubjectList.mandatorytList) {
            System.out.println(string);
        }


        while (true) {
            try {
                displayMainView();
            } catch (Exception e) {
                System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
            }
        }
    }


    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>(); // 학생 배열 초기화
        // 과목 배열 초기화 , Enum을 활용하여 리펙토링
        subjectStore = List.of(
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.JAVA),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.OBJECT_ORIENTED),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.SPRING),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.JPA),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.MYSQL),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.DESIGN_PATTERN),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.SPRING_SECURITY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.REDIS),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.MONGODB)
        );
        scoreStore = new ArrayList<>(); // 점수 배열 초기화
    }


    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        StudentMethod studentMethod = new StudentMethod();
        // 기능구현 - by 정근
        // inItMethod 로 INDEX_TYPE_STUDENT 만 넘겨주면 Student 인스턴스를 리턴받음
        Student student = studentMethod.inItMethod(sequence(INDEX_TYPE_STUDENT));
        studentStore.add(student);
        // 기능 구현 (필수 과목, 선택 과목)
        //필수과목 입력받고 저장하기
        studentMethod.mandatoryMethod(student, subjectStore);

        //선택과목 입력받고 저장하기
        studentMethod.choiceMethod(student, subjectStore);


        // 리스트 확인
        System.out.println(student.getStudentId() + "   " + student.getStudentName()); // 수강생 인스턴스 생성확인
        ArrayList<String> studentSubjectList = student.getStudentSubjectList();
        for (Object o : studentSubjectList) {
            System.out.println(o);
        }
        System.out.println("수강생 등록 성공!\n");


    }


    // 수강생 목록 조회
    private static void inquireStudent() {
        StudentMethod studentMethod = new StudentMethod();
        studentMethod.lookUp(studentStore);
        // made by 정근
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 ID를 입력하시오...");
        return sc.next();
    }

    //code by Leejinuk.
    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {

                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 점수를 등록합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    String subject = student.getStudentSubjectList().get(i);
                    System.out.println(i + 1 + ". " + subject);
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("점수를 등록할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                        String subject = student.getStudentSubjectList().get(i);
                        if (subject.equals(selectSubject)) flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 존재하지 않는 과목입니다. 다시 입력해주세요.");
                } while (flag);

                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                System.out.println(selectSubject + "의 점수 등록을 시작합니다...");
                int score;
                int[] scoreArr = new int[10];
                for (int i = 0; i < 10; i++) {
                    flag = true;
                    do {
                        System.out.print(i + 1 + "회차 점수 : ");
                        score = sc.nextInt();
                        if (0 <= score && score <= 100) {
                            scoreArr[i] = score;
                            //점수를 기반으로 등급을 매겨 저장해준다.
                            flag = false;
                        } else {
                            System.out.println("0 ~ 100 사이의 점수로 입력해주세요.");
                        }
                    } while (flag);
                }
                scoreMap.put(selectSubject, scoreArr);
                System.out.println(selectSubject + "\n" + Arrays.toString(scoreMap.get(selectSubject)));
                System.out.println("\n점수 등록 성공!");
                return;
            }
        }
        System.out.println("입력한 학생 ID는 잘못 입력됐거나, 존재하지 않습니다.");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호(ID)
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                Set<String> subject = scoreMap.keySet();
                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 점수를 수정합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    System.out.println(i + 1 + ". " + student.getStudentSubjectList().get(i));
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("점수를 수정할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (String key : subject) {
                        if (key.equals(selectSubject)) {
                            flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                        }
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 점수가 미등록된 과목은 수정할 수 없습니다. 다시 입력해주세요.");
                } while (flag);

                System.out.println(selectSubject + "의 점수 수정을 원하는 회차를 입력해주세요: ");
                int round = sc.nextInt();
                if (1 <= round && round <= 10) {
                    int[] scoreArray = scoreMap.get(selectSubject);
                    System.out.println(selectSubject + " 과목, " + round + " 회차의 수정할 점수를 입력해주세요: ");
                    flag = true; //반복 체크
                    do {
                        int updateScore = sc.nextInt();
                        if (0 <= updateScore && updateScore <= 100) {
                            scoreArray[round - 1] = updateScore; //입력받은 회차에 -1을 해야 원하는 index에 접근가능.
                            flag = false;
                        } else {
                            System.out.println("0 ~ 100 사이의 점수로 입력해주세요.");
                        }
                    } while (flag);
                    System.out.println("점수 수정 성공!");
                    return;
                } else {
                    System.out.println("올바른 회차가 아닙니다.");
                    return;
                }
            }
        }
        System.out.println("입력한 학생 번호는 잘못 입력됐거나, 존재하지 않습니다.");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호(ID)
        if ("exit".equals(studentId)) return;

        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                Set<String> subject = scoreMap.keySet();
                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 점수를 조회합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    System.out.println(i + 1 + ". " + student.getStudentSubjectList().get(i));
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("점수를 조회할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (String key : subject) {
                        if (key.equals(selectSubject)) {
                            flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                        }
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 점수가 미등록된 과목은 조회할 수 없습니다. 다시 입력해주세요.");
                } while (flag);

                System.out.print("조회를 원하는" + selectSubject + "의 시험회차를 입력해주세요: ");
                int round = sc.nextInt();
                sc.nextLine(); //개행문자 비워주기.

                //해당 과목 의 점수 목록 받아와서 원하는 회차의 점수 추출
                int[] scores = scoreMap.get(selectSubject);
                int score = scores[round - 1];

                //추출한 점수에 맞는 등급 조회하기
                String s = selectSubject; //사용자가 선택한 과목
                String[] belongMan = SubjectList.mandatorytList; //SubjectList 클래스에서 가져온 필수과목 리스트
                String[] belongCh = SubjectList.choiceList; //SubjectList 클래스에서 가져온 선택과목 리스트
                for (String string : SubjectList.mandatorytList) {
                    System.out.println(string);
                }

                //조회를 원하는 과목이 필수과목 소속인지, 선택과목 소속인지 확인하여 등급 리턴 & 출력
                for (int i = 0; i < belongMan.length; i++) {
                    if (SubjectList.mandatorytList[i].equals(s)) {
                        s = "mandatory";
                        break;
                    }
                }
                for (int j = 0; j < belongCh.length; j++) {
                    if (SubjectList.choiceList[j].equals(s)) {
                        s = "choice";
                        break;
                    }
                }
                System.out.println(s);

                char finalGrade = Score.grade(score, s);
                System.out.println(studentId + "님의 " + selectSubject + " " + round + "회차 시험은" + score + "점(" + finalGrade + ") 입니다");
            }
        }
    }
}
