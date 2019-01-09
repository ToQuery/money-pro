package io.github.toquery.moneypro;

import com.google.common.collect.Lists;
import io.github.toquery.moneypro.entity.MoneyPro;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@Getter
@Setter
@Configuration
public class MoneyProData {

    private List<MoneyPro> data = Lists.newArrayList();
}
