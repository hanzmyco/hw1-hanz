import java.io.File;
import java.net.URLDecoder;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.util.AbstractExternalizable;

import edu.stanford.nlp.dcoref.CoNLL2011DocumentReader.NamedEntityAnnotation;


public class JCSub extends JCasAnnotator_ImplBase {
  Chunker chunker;
  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    // TODO Auto-generated method stub
    
    try
    {
        chunker = (Chunker) AbstractExternalizable.readObject(new File(URLDecoder.decode(getClass().getResource((String) aContext.getConfigParameterValue("InpuString")).getFile(), "UTF-8")));
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    super.initialize(aContext);
  }
  private static int Spaces(String s,int u)
  {
    return StringUtils.countMatches(s.substring(0, u), " ");
  }

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    
    String doc = aJCas.getDocumentText();
    for (Chunk chunk : chunker.chunk(doc).chunkSet())
    {
        NE ne = new NE(aJCas);
        ne.setBegin(chunk.start() - Spaces(doc, chunk.start()));
        ne.setEnd(chunk.end() - Spaces(doc, chunk.end()) - 1);
        ne.setNEString(doc.substring(chunk.start(), chunk.end()));
        ne.addToIndexes();
    }

  }

}
