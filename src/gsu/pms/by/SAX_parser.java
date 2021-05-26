package gsu.pms.by;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAX_parser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        MyHandler handler = new MyHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse("src/courses.xml");

        Branches branches = handler.getBranches();
  //      System.out.println("\nBranches number: " + branches.number);
    //    branches.rateList.forEach(System.out::println);
        //branches.rateListCurrency.forEach(System.out::println);

        try (FileWriter files = new FileWriter("src/gsu/pms/by/SAX.txt")) {

            files.write("Branches number: " + branches.number + "\n" + String.valueOf(branches.rateList));
           // files.write(String.valueOf(rateListCurrency));

        }

    }

    private static class MyHandler extends DefaultHandler{
        static final String BRANCHES_TAG = "branches";
        static final String BRANCH_TAG = "branch";
        static final String RATE_TAG = "rate";
        static final String BUY_TAG = "buy";
        static final String SELL_TAG = "sell";
    //    static final String RATE_TAG = "rate"; rate только с currency

        static final String BRANCHES_NUMBER_ATTRIBUTE = "number";
        static final String BRANCH_NAME_ATTRIBUTE = "name";
        static final String RATE_CURRENCY_ATTRIBUTE = "currency";
        static final String RATE_UNITS_ATTRIBUTE = "Units";

        private Branches branches;
        private Rate currentRate;
        private RateWithCurrency rateWithCurrency;
        private String branchName;
        private String currencyElement;

        Branches getBranches(){
            return branches;
        }

        public void startDocument() throws SAXException {
           // System.out.println("");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currencyElement = qName;

            switch (currencyElement) {
                case BRANCHES_TAG: {
                    branches = new Branches();
                    branches.number = Integer.valueOf(attributes.getValue(BRANCHES_NUMBER_ATTRIBUTE));
                } break;

                case BRANCH_TAG: {
                    branches.rateList = new ArrayList<>();

                    if (branchName == null) {
                        branchName = attributes.getValue(BRANCH_NAME_ATTRIBUTE);
                    }
                } break;

                case RATE_TAG: {
                    currentRate = new Rate();
                    //rateWithCurrency = new RateWithCurrency();

                    currentRate.setCurrency(String.valueOf(attributes.getValue(RATE_CURRENCY_ATTRIBUTE)));
                    currentRate.setUnits(String.valueOf(attributes.getValue(RATE_UNITS_ATTRIBUTE)));
                    currentRate.setName(branchName);
                   // rateWithCurrency.getRates().setCurrency(String.valueOf(attributes.getValue(RATE_CURRENCYTEXT_ATTRIBUTE)));
                    //rateWithCurrency.getRates().setValue(String.valueOf(attributes.getValue(RATE_CURRENCY_ATTRIBUTE).getTextContent()));

                } break;

                default: {}
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String text = new String(ch, start, length);

            if (text.contains("<") || currencyElement == null){
                return;
            }

            switch (currencyElement) {
                case BUY_TAG: {
                    currentRate.setBuy(text);
                } break;

                case SELL_TAG: {
                    currentRate.setSell(text);
                } break;

//                case RATE_TAG: {
//                    rateWithCurrency.getRates().setValue(text);
//                } break;

                default: {

                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException{
            switch (qName) {
                case RATE_TAG: {
                    if (currentRate.getBuy() != null){
                        branches.rateList.add(currentRate);
                        currentRate = null;
                    }

                } break;

                default: {

                }
            }
            currencyElement = null;
        }

        public void endDocument() throws SAXException {
            System.out.println("SAX parsing is completed...");
        }
    }
}

class Branches {
    int number;
    List<Rate> rateList;
   //List<RateWithCurrency> rateListCurrency;
}