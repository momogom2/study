package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FiledService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FiledService filedService = new FiledService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> {
            filedService.logic("userA");
        };

        Runnable userB = () -> {
            filedService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); 동시성 발생x
        sleep(100); // 동시성 문제 발생
        threadB.start();
        sleep(3000);

        log.info("main exit");
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
