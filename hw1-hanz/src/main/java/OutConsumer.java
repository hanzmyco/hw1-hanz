import java.io.FileWriter;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;


public class OutConsumer extends CasConsumer_ImplBase {
  FileWriter fw;
  
  @Override
  public void initialize() throws ResourceInitializationException {
    try {
      fw = new FileWriter((String) getConfigParameterValue("out"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    super.initialize();
  }

  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {
    try {
      JCas jc = aCAS.getJCas();
      String sentenceID = ((SID) jc.getJFSIndexRepository().getAllIndexedFS(SID.type).get()).getId();
      
      FSIterator<TOP> namedIt = jc.getJFSIndexRepository().getAllIndexedFS(NE.type);
      while(namedIt.hasNext()) {
        NE ne = (NE)namedIt.get();
        fw.write(sentenceID + "|" + ne.getBegin() + " " + ne.getEnd() + "|" + ne.getNEString() + "\n");
        namedIt.next();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

  @Override
  public void destroy() {
    try {
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    super.destroy();
  }
}
