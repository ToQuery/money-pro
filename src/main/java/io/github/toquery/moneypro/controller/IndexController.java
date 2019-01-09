package io.github.toquery.moneypro.controller;

import io.github.toquery.moneypro.MoneyProData;
import io.github.toquery.moneypro.entity.MoneyPro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@RestController
public class IndexController {

    @Resource
    private MoneyProData moneyProData;


    @RequestMapping("/")
    public List<MoneyPro> index() {
        return moneyProData.getData();
    }
}
