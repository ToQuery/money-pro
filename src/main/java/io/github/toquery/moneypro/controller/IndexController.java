package io.github.toquery.moneypro.controller;

import io.github.toquery.moneypro.MoneyProData;
import io.github.toquery.moneypro.entity.MoneyPro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@Controller
public class IndexController {

    @Resource
    private MoneyProData moneyProData;


    @ResponseBody
    @RequestMapping("/")
    public List<MoneyPro> index() {
        return moneyProData.getData();
    }

    @RequestMapping("/index")
    public String in(){
        return "dist/index.html";
    }
}
