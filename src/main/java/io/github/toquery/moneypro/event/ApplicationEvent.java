package io.github.toquery.moneypro.event;

import io.github.toquery.moneypro.MoneyProData;
import io.github.toquery.moneypro.MoneyProDataLoader;
import io.github.toquery.moneypro.entity.MoneyPro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@Slf4j
@Component
public class ApplicationEvent {

    @Resource
    private MoneyProData moneyProData;

    @Resource
    private MoneyProDataLoader moneyProDataLoader;

    @EventListener(classes = ContextRefreshedEvent.class)
    public void contextRefreshedEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<MoneyPro> moneyProList = moneyProDataLoader.csvLoader();
        moneyProData.setData(moneyProList);
    }
}
