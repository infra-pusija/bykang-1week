package infra_pusija.infra_1week;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestControllerTest {
    @Mock
    private TestRepo testRepo;

    @InjectMocks
    private TestController testController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMethodName() {
        // given
        List<Tests> mockTests = Arrays.asList(
                new Tests("Test1"),
                new Tests("Test2")
        );
        when(testRepo.findAll()).thenReturn(mockTests);

        // when
        List<Tests> result = testController.getMethodName();

        // then
        assertEquals(2, result.size());
        verify(testRepo, times(1)).findAll();
    }

    @Test
    public void testGetGo() {
        // given
        Tests test = new Tests("goo");
        when(testRepo.save(any(Tests.class))).thenReturn(test);

        // when
        ResponseEntity<Void> response = testController.getGo();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(testRepo, times(1)).save(any(Tests.class));
    }

    @Test
    public void testTestName() {
        // when
        String result = testController.testName();

        // then
        assertEquals("gg", result);
    }
}
