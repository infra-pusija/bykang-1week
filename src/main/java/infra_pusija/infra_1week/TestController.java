package infra_pusija.infra_1week;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    private TestRepo testRepo;

    @GetMapping("/aa")
    public String testName() {
        return "gg";
    }

    @GetMapping("/test")
    public List<Test> getMethodName() {
        List<Test> tests = testRepo.findAll();
        for (Test t : tests) {
            t.toString();
        }
        return tests;
    }

    @GetMapping("/go")
    public ResponseEntity<Void> getGo() {
        Test test = new Test("goo");
        testRepo.save(test);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
