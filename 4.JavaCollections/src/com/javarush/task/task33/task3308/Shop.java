package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop {
    public Goods goods;
    public String[] secretData;
    public double profit;
    public int count;

    public static class Goods {
        public List<String> names;
    }
}
