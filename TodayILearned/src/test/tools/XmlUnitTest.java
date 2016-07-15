package test.tools;

import java.io.IOException;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xmlunit.diff.Difference;

public class XmlUnitTest {
	//http://www.adeveloperdiary.com/java/xml/compare-2-xml-in-java-part-1/
	@Test
	public void test() {
		XMLUnit.setIgnoreAttributeOrder(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setNormalizeWhitespace(true);
		String xmlFirstOne = "<?xml version=\"1.0\" encoding=\"EUC-KR\"?>";
		xmlFirstOne += "<kr><a>first</a></kr>";
		
		String xmlSecondOne = "<?xml version=\"1.0\" encoding=\"EUC-KR\"?>";
		xmlFirstOne += "<kr><b>second</b></kr>";
		
		try {
			Diff dif = new Diff(xmlFirstOne, xmlSecondOne);
			DetailedDiff myDiffd = new DetailedDiff(dif);
			List allDifferences = myDiffd.getAllDifferences();
			
			
			
			//XMLAssert.assertXMLEqual(xmlFirstOne, xmlSecondOne);
		} catch (Exception e) {
		}

	}
}
