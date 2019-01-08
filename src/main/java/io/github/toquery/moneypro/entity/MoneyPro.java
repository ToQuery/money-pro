package io.github.toquery.moneypro.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.toquery.moneypro.deserializer.ChineseCurrencyJsonDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 日期,款额,账户,总额,转账到,结余,类别,说明,交易类型,代理人
 *
 * @author toquery
 * @version 1
 */
@Getter
@Setter
@ToString
@JsonPropertyOrder(value = {"日期", "款额", "账户", "总额", "转账到", "结余", "类别", "说明", "交易类型", "代理人"},alphabetic = true)
public class MoneyPro {

    @JsonProperty("日期")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private Date date;
    @JsonProperty("款额")
    @JsonDeserialize(using = ChineseCurrencyJsonDeserializer.class)
    private Double amount;
    @JsonProperty("账户")
    private String account;
    @JsonProperty("总额")
    @JsonDeserialize(using = ChineseCurrencyJsonDeserializer.class)
    private Double totalAmount;
    @JsonProperty("转账到")
    private String transferAccount;
    @JsonProperty("结余")
    @JsonDeserialize(using = ChineseCurrencyJsonDeserializer.class)
    private Double surplus;
    @JsonProperty("类别")
    private String type;
    @JsonProperty("说明")
    private String remark;
    @JsonProperty("交易类型")
    private String transactionType;
    @JsonProperty("代理人")
    private String agent;

}
