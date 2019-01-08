package io.github.toquery.moneypro;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import io.github.toquery.moneypro.entity.MoneyPro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoneyProApplicationTests {

    @Test
    public void contextLoads() {
        CsvMapper csvMapper = new CsvMapper();

        CsvSchema schema = csvMapper
                .schemaFor(MoneyPro.class) //设置 schema pojo对象
                .withHeader() // 取第一行
                .withColumnSeparator(',');
        try (InputStream inputStream = new ClassPathResource("12.csv").getInputStream();) {
            MappingIterator<MoneyPro> values = csvMapper.readerFor(MoneyPro.class).with(schema).readValues(inputStream);
            values.forEachRemaining(System.out::println);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        csvMapper.setDateFormat(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
    }

}

