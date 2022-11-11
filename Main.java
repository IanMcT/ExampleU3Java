import java.io.FileWriter;
/*
Ian mcTavish
  November 11, 2022
  Save a file - unit 3
  */

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
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate; // import the LocalDate class
class Main {
 public static void main(String[] args){
    Deck deck = new Deck();
   FileHelper fileHelper = new FileHelper();
   fileHelper.saveFile(deck);
   
  }
}