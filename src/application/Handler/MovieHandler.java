package application.Handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Handler for the SAX parser
 *
 * @author 	Subodh Kalika (102875446)
 * @author 	Sandesh Dhoju (102840091)
 * @version 2020.10.20
 * @see     org.xml.sax.helpers.DefaultHandler
 */
public class MovieHandler extends DefaultHandler {
				
	boolean bkeyword = false;
	public static ArrayList<String> keywordsList = new ArrayList<String>(); //arraylist
	
	/**
	 * startElement
	 * this method is called every time the parser gets an open tag 
	 *
	 * @param string 		uri
	 * @param string 		localName
	 * @param string 		qName
	 * @param attributes 	attribute
	 */
	public void startElement(String uri, String localName, String qName, Attributes attribute ) throws SAXException {
		if (qName.equalsIgnoreCase("kw")) {
			bkeyword = true;
		}
	}
	
	/**
	 * endElement
	 * this method is called every time the parser gets a closing tag
	 *
	 * @param string 		uri
	 * @param string 		localName
	 * @param string 		qName
	 */
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	
	/**
	 * characters
	 * print data stored between '<' and '>'
	 *
	 * @param char 		ch[]
	 * @param int 		start
	 * @param int 		length
	 */
	public void characters(char ch[], int start, int length) throws SAXException {
		if(bkeyword) {
			String movieKeyword = new String(ch, start, length);
			keywordsList.add(movieKeyword);
			bkeyword = false;
		}
	}
};
