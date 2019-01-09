package io.github.toquery.moneypro;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import io.github.toquery.moneypro.entity.MoneyPro;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@Component
public class MoneyProDataLoader {

    public List<MoneyPro> csvLoader() {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper
                .schemaFor(MoneyPro.class) //设置 schema pojo对象
                .withHeader() // 取第一行
                .withColumnSeparator(',');
        try (InputStream inputStream = new ClassPathResource("csv/12.csv").getInputStream();) {
            MappingIterator<MoneyPro> values = csvMapper.readerFor(MoneyPro.class).with(schema).readValues(inputStream);
            return values.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
