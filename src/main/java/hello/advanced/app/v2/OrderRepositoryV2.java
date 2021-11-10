package hello.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    public void save(String itemId) {

        if (itemId.equals("ex")) {
            throw new IllegalStateException("얘외 발생");
        }
        this.sleep(1000);
    }

    private void sleep(int mills) {

        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
