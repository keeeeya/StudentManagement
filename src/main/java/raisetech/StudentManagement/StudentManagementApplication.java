package raisetech.StudentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

  private String name = "Nanashino Gonbe";
  private String age = "30";

  private Map<String, String> students = new HashMap<>() {{
    put("Seiya", "10");
    put("Soshina", "20");
    put("Wakabayashi", "30");
    put("Kasuga", "40");
  }};

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }

  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    return name + " " + age + "歳";
  }

  @PostMapping("/studentInfo")
  public void setStudentInfo(String name, String age) {
    this.name = name;
    this.age = age;
  }

  @PostMapping("/studentName")
  public void updateStudentName(String name) {
    this.name = name;
  }

  @GetMapping("/studentMap")
  public Map<String, String> getStudent() {
    return students;
  }

  @PostMapping("/updateStudentMap")
  public String updateStudentMap(String name, String age) {
    if (students.containsKey(name)) {
      students.put(name, age);
      return "年齢を更新しました";
    } else {
      return "生徒情報がありません";
    }
  }

}
