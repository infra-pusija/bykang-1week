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
    public List<Tests> getMethodName() {
        List<Tests> tests = testRepo.findAll();
        for (Tests t : tests) {
            t.toString();
        }
        return tests;
    }

    @GetMapping("/go")
    public ResponseEntity<Void> getGo() {
        Tests test = new Tests("goo");
        testRepo.save(test);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
