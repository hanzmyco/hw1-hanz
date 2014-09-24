import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;


public class CR extends CollectionReader_ImplBase {
  private Scanner sc;
  @Override
  public void initialize() throws ResourceInitializationException {
    // TODO Auto-generated method stub
    try{
     sc = new Scanner(new BufferedReader(new FileReader(URLDecoder.decode(getClass().getResource((String) getConfigParameterValue("InputString")).getFile(),"UTF-8"))));
    }catch(Exception e){
      
    }
    super.initialize();
  }

  @Override
  
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
    String line=sc.nextLine();
    String [] thing=line.split(" ",2);
    try{
      JCas jc=aCAS.getJCas();
      jc.setDocumentText(thing[1]);
      SID ssid=new SID(jc);
      ssid.setId(thing[0]);
      ssid.addToIndexes();
    }
    catch(Exception e)
    {
      
    }

  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return sc.hasNext();
    
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
    sc.close();

  }

}
