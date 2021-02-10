package cn.com.tanan.boot.actuator;

import cn.com.tanan.boot.common.Constants;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class WeChatHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail(this.getClass().getSimpleName(), Constants.STATUS_RUNNING).build();
    }
}
