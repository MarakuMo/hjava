package org.huys.xml;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

public class ChessboardSAXPrinter {
 private SAXParser parser;

 public ChessboardSAXPrinter(boolean validating)
   throws Exception {
  SAXParserFactory factory 
    = SAXParserFactory.newInstance();
  factory.setValidating(validating);
  parser = factory.newSAXParser();
  //...
  return;
 }
/*
 public void print(String fileName, PrintStream out)
   throws SAXException, IOException {
  //...
  //parser.parse(fileName, ...);
  return;
 }
  
 public static void main(String[] args) {
  //...   
  for (int k = 0; k < r; k++) {
    // r: number of runs
   ChessboardSAXPrinter saxPrinter
     = new ChessboardSAXPrinter(validating);
   long time = System.currentTimeMillis();
   for (int i = 0; i < n; i++) {
     // n: number of document processed per run
    saxPrinter.print(args[0], out);
   }
   // print out the average time (s) 
   // to process a document during the current run
   System.err.print((((double) (System.currentTimeMillis()- time)) / 1000 / n) + "\t");
  }
  //...
 }
*/
}
