package gsu.pms.by;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOM_Parser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File file = new File("src/courses.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);


        Element branchElement = (Element) document.getElementsByTagName("branch").item(0);
        String name = branchElement.getAttribute("name");

        NodeList rateNodeList = document.getElementsByTagName("rate");

        List<Rate> rateList = new ArrayList<>();
        List<RateWithCurrency> rateListCurrency = new ArrayList<>();

        for (int i = 0; i < rateNodeList.getLength(); i++){
            if (rateNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element rateElement = (Element) rateNodeList.item(i);

                Rate rate = new Rate();
                RateWithCurrency ratesCurrency = new RateWithCurrency();

                rate.setName(name);

                rate.setCurrency(String.valueOf(rateElement.getAttribute("currency")));
                rate.setUnits(String.valueOf(rateElement.getAttribute("Units")));

                ratesCurrency.getRates().setCurrency((String.valueOf(rateElement.getAttribute("currency"))));
                ratesCurrency.getRates().setValue(String.valueOf(rateElement.getTextContent()));


                NodeList childNodes = rateElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);

                        switch (childElement.getNodeName()) {
                            case "buy": {
                                rate.setBuy(String.valueOf(childElement.getTextContent()));
                            }
                            break;
                            case "sell": {
                                rate.setSell(String.valueOf(childElement.getTextContent()));
                            }
                        }
                    }
                }


                if (rate.getBuy() != null) {
                    rateList.add(rate);
                }
                if (rate.getBuy() == null) {
                    rateListCurrency.add(ratesCurrency);
                }
            }
        }

        try (FileWriter files = new FileWriter("src/gsu/pms/by/DOM.txt")) {

            files.write(String.valueOf(rateList));
            files.write(String.valueOf(rateListCurrency));

        }

        System.out.println("DOM is completed");

    }
}


