package tr.com.huseyinaydin;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android, WebServis, RESTful.
 *
 */

public class XMLParser {

    //YAPILANDIRICI METOT
    public XMLParser() {
    }

    //URL'DEKI XML'DEN HTTP request ISTEGI YAPIYOR
    public String getXmlFromUrl(String url) {
        String xmlResult = null;
        try {
            //VARSAYILAN ISTMECI
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            xmlResult = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlResult;
    }

    //XML DOM element ELEMANLARI ALINIYOR
    public Document getDomElement(String xmlResult) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlResult));

            doc = db.parse(is);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    //XML node KOK ELEMANI GIGER COCUK ELEMANLARI ALINIYOR
    public String getElementValue(Node node) {
        Node child;
        if (node != null)
            if (node.hasChildNodes())
                for (child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                    if (child.getNodeType() == Node.TEXT_NODE)
                        return child.getNodeValue();
                }
        return "";
    }

    //NODE'DAKI BIR ELEMANIN SIRASI VE DEGERI
    public String getValue(Element element, String str) {
        NodeList nl = element.getElementsByTagName(str);
        return this.getElementValue(nl.item(0));
    }
}