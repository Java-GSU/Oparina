package gsu.pms.by;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaX_Parser {

    public static void main(String[] args) throws IOException {
        String fileName = "src/courses.xml";
        List<Rate> rateList = parseXML(fileName);

        System.out.println("StAX Completed");
        
        try (FileWriter files = new FileWriter("src/gsu/pms/by/StAX.txt")) {
            files.write(String.valueOf(rateList));
        }
    }

    private static List<Rate> parseXML(String fileName) {
        List<Rate> rateList = new ArrayList<>();
        Rate rate = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

            while(xmlEventReader.hasNext()){
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();

                    if(startElement.getName().getLocalPart().equals("rate")){
                        rate = new Rate();

                        Attribute currency = startElement.getAttributeByName(new QName("currency"));
                        Attribute unit = startElement.getAttributeByName(new QName("Units"));

                        if(currency != null && unit != null){
                            rate.setCurrency((currency.getValue()));
                            rate.setUnits((unit.getValue()));
                            rate.setName("Головной банк");
                        }
                    }

                    else if(startElement.getName().getLocalPart().equals("buy")){

                        xmlEvent = xmlEventReader.nextEvent();
                        rate.setBuy(xmlEvent.asCharacters().getData());

                    }else if(startElement.getName().getLocalPart().equals("sell")){

                        xmlEvent = xmlEventReader.nextEvent();
                        rate.setSell(xmlEvent.asCharacters().getData());

                    }
                }

                if(xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if(endElement.getName().getLocalPart().equals("rate")) {
                        if (rate.getBuy() != null) {
                            rateList.add(rate);
                        }
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return rateList;
    }

}