package application.Handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MovieHandler extends DefaultHandler {
				
				boolean bkeyword = false;
				public static ArrayList<String> keywordsList = new ArrayList<String>(); //arraylist
				
				//this method is called every time the parser gets an open tag 
				public void startElement(String uri, String localName, String qName, Attributes attribute ) throws SAXException {
					if (qName.equalsIgnoreCase("kw")) {
						bkeyword = true;
					}
				}
				
				//this method is called every time the parser gets a closing tag
				public void endElement(String uri, String localName, String qName) throws SAXException {
					
				}
				
				//print data stored between '<' and '>'
				public void characters(char ch[], int start, int length) throws SAXException {
					if(bkeyword) {
						String movieKeyword = new String(ch, start, length);
						keywordsList.add(movieKeyword);
						bkeyword = false;
					}
				}
			};
