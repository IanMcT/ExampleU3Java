
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
class FileHelper{
  public FileHelper(){
    
  }
  public void saveFile(Deck deck) {
    String root = "Cards";
        DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder  documentBuilder;
    Document document;
    Element rootElement;

    try{
     documentBuilderFactory = DocumentBuilderFactory.newInstance();
      documentBuilder = documentBuilderFactory.newDocumentBuilder();
     document = documentBuilder.newDocument();
     rootElement = document.createElement(root);
    document.appendChild(rootElement);
      for(int i = 0; i < deck.cards.length; i++){
        Element cardElement = document.createElement("Card");
        Element face = document.createElement("Face");
        face.appendChild(document.createTextNode(deck.cards[i].Suit()));
     cardElement.appendChild(face);
        rootElement.appendChild(cardElement);
      }
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
   Transformer transformer = transformerFactory.newTransformer();
   DOMSource source = new DOMSource(document);

      StreamResult result =  new StreamResult(new StringWriter());
   transformer.setOutputProperty(OutputKeys.INDENT, "yes");
   transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
   transformer.transform(source, result);
    System.out.println("Save file");

      //writing to file
   FileOutputStream fileOutputStream = null;
   File file;
       try {
         file = new File("cards.txt");
     fileOutputStream = new FileOutputStream(file);
         // if file doesnt exists, then create it
     if (!file.exists()) {
       file.createNewFile();
       }
         // get the content in bytes
     String xmlString = result.getWriter().toString();
     System.out.println(xmlString);
     byte[] contentInBytes = xmlString.getBytes();
     
     fileOutputStream.write(contentInBytes);
     fileOutputStream.flush();
     fileOutputStream.close();
       }catch(Exception e){
         System.out.println("McT " + e.getMessage());   
       }
    }catch(Exception e){
      System.out.println("McT " + e.getMessage());
    }
  }
}