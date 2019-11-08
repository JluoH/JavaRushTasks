package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, writer);
        String s = writer.toString();
        s = s.replaceAll("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
        s = s.replaceAll("<" + tagName + "/>", "<!--" + comment + "-->\n" + "<" + tagName + "/>");
        return s;
    }

    public static void main(String[] args) {
    }
}
