import java.util.List;

public enum SubjectList {
    // 상수로 과목 생성

     JAVA(SubjectType.MANDATORY, "Java"),
     OBJECT_ORIENTED(SubjectType.MANDATORY,"객체지향"),
     SPRING(SubjectType.MANDATORY,"Spring"),
     JPA(SubjectType.MANDATORY,"JPA"),
     MYSQL(SubjectType.MANDATORY,"MYSQL"),

     DESIGN_PATTERN(SubjectType.CHOICE,"디자인 패턴"),
     SPRING_SECURITY(SubjectType.CHOICE,"Spring Security"),
     REDIS(SubjectType.CHOICE,"Redis"),
     MONGODB(SubjectType.CHOICE,"MongoDB")
     ;


    private final String subjectName;
    private final SubjectType subjectType;


    SubjectList(SubjectType subjectType , String subjectName) {
       this.subjectName = subjectName;
       this.subjectType = subjectType;


    }
    // Getter
    public String getSubjectName() {
        return subjectName;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    static String[] mandatorytList= {"Java", "객체지향", "Spring", "JPA","MYSQL"};
    static String[] choiceList = {"디자인패턴", "Spring Security", "Redis", "MongoDB"};

}
