import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

public class XMLDom {
  public static void main(String[] argv) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder loader = factory.newDocumentBuilder();
    Document document = loader.parse("chess.xml");

    DocumentTraversal traversal = (DocumentTraversal) document;
    NodeIterator iterator = traversal.createNodeIterator(document.getDocumentElement(),
        NodeFilter.SHOW_ELEMENT, null, true);

    for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {
      System.out.println("Element: " + ((Element) n).getTagName());
    }
  }
}

