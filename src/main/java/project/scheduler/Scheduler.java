package project.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class Scheduler {

    @Scheduled(cron = "0 */2 * * * *")
    public void someJob() throws InterruptedException {
        System.out.println("Time now " + LocalDateTime.now());
    }
}
