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

/**
 * 
 * @author Han Zhang
 * get results and write it into output file
 */
public class OutConsumer extends CasConsumer_ImplBase {
  /**
   * the file writer
   */
  FileWriter fw;
  /**
   * initilize the outputfile which means opens it
   */
  @Override
  public void initialize() throws ResourceInitializationException {
    try {
      fw = new FileWriter((String) getConfigParameterValue("out"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    super.initialize();
  }
 /**
  * get genes in each CAS and write it in outputfile
  * @param aCAS the CAS that contains the genes
  */
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
 /**
  * close the output file
  */
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
