package com.sda.client.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class Currency {

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public Currency() {
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public BigDecimal getMin(){

        List<Rate> listRate = this.getRates();
        BigDecimal min = listRate.get(0).getMid();
        for (Rate rate : listRate) {
            min = rate.getMid().compareTo(min)<0? rate.getMid(): min;

            }
        return min;
        }

    public BigDecimal getMax(){

        List<Rate> listRate = this.getRates();
        BigDecimal max = listRate.get(0).getMid();
        for (Rate rate : listRate) {
            max  = rate.getMid().compareTo(max)>0? rate.getMid(): max;

        }
        return max;
    }

    public BigDecimal getAverage(){
        BigDecimal sum = new BigDecimal(0);
        List<Rate> listRate = this.getRates();
        int count = (int) listRate.stream().map(rate -> rate.getMid())
                .count();
        for (Rate rate: listRate ) {
            sum = sum.add(rate.getMid());
        }
        return sum.divide(new BigDecimal(count),new MathContext(3));
    }
    @Override
    public String toString() {
        return "Currency{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
