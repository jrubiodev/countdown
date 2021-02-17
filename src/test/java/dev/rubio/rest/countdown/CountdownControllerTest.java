package dev.rubio.rest.countdown;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountdownControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPerformance() throws Exception {
        //Testing 100 times
        for (int i = 0; i < 101; i++) {
            assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/countdown",
                    String.class)).isNotNull();
        }
    }
}
