package csi.test;

import csi.src.Price;
import csi.src.PriceJoiner;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class PriceJoinerTest6 {

    private PriceJoiner priceJoiner;

    private Date beginDate1;
    private Date beginDate2;
    private Date beginDate3;
    private Date endDate1;
    private Date endDate2;
    private Date endDate3;

    private LinkedList<Price> result;

    @Before
    public void init() {
        priceJoiner = new PriceJoiner();

        String bd1 = "01.01.2013 00:00:00";
        String ed1 = "31.01.2013 23:59:59";
        String bd2 = "18.02.2013 00:00:00";
        String ed2 = "20.02.2013 23:59:59";
        String bd3 = "15.01.2013 00:00:00";
        String ed3 = "15.02.2013 00:00:00";

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        try {
            beginDate1 = dateFormat.parse(bd1);
            beginDate2 = dateFormat.parse(bd2);
            beginDate3 = dateFormat.parse(bd3);
            endDate1 = dateFormat.parse(ed1);
            endDate2 = dateFormat.parse(ed2);
            endDate3 = dateFormat.parse(ed3);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        result = new LinkedList<>(Arrays.asList(
                Price.builder()
                        .id(new Random().nextInt())
                        .product_code("122856")
                        .number(1)
                        .depart(1)
                        .begin(beginDate1)
                        .end(beginDate3)
                        .value(11000)
                        .build(),
                Price.builder()
                        .id(new Random().nextInt())
                        .product_code("122856")
                        .number(1)
                        .depart(1)
                        .begin(beginDate3)
                        .end(endDate3)
                        .value(12000)
                        .build(),
                Price.builder()
                        .id(new Random().nextInt())
                        .product_code("122856")
                        .number(1)
                        .depart(1)
                        .begin(beginDate2)
                        .end(endDate2)
                        .value(99000)
                        .build()
                ));
    }

    @Test
    public void test1() throws CloneNotSupportedException {

        List<Price> oldPriceList = new LinkedList<>(Arrays.asList(
                Price.builder()
                        .id(new Random().nextInt())
                        .product_code("122856")
                        .number(1)
                        .depart(1)
                        .begin(beginDate1)
                        .end(endDate1)
                        .value(11000)
                        .build(),
                Price.builder()
                        .id(new Random().nextInt())
                        .product_code("122856")
                        .number(1)
                        .depart(1)
                        .begin(beginDate2)
                        .end(endDate2)
                        .value(99000)
                        .build()
        ));

        List<Price> newPriceList = new LinkedList<>(Arrays.asList(
                Price.builder()
                        .id(new Random().nextInt())
                        .product_code("122856")
                        .number(1)
                        .depart(1)
                        .begin(beginDate3)
                        .end(endDate3)
                        .value(12000)
                        .build()
        ));

        assertEquals(print(priceJoiner.join(oldPriceList, newPriceList)), print(result));
    }

    private String print(List<Price> linkedList) {
        StringBuilder builder = new StringBuilder();
        for (Price p : linkedList) {
            builder.append(p.getProduct_code());
            builder.append(p.getDepart());
            builder.append(p.getNumber());
            builder.append(p.getBegin());
            builder.append(p.getEnd());
            builder.append(p.getValue());
        }
        return builder.toString();
    }
}