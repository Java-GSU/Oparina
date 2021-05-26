import javax.xml.parsers.ParserConfigurationException;

import gsu.pms.by.DOM_Parser;
import gsu.pms.by.SAX_parser;
import gsu.pms.by.StaX_Parser;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws ParserConfigurationException {


        try {
            DOM_Parser.main (args);
            SAX_parser.main (args);
            StaX_Parser.main (args);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        System.exit(0);

   }
}
