
/* First created by JCasGen Tue Sep 23 19:44:51 EDT 2014 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Tue Sep 23 19:44:51 EDT 2014
 * @generated */
public class NE_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NE_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NE_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NE(addr, NE_Type.this);
  			   NE_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NE(addr, NE_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NE.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("NE");
 
  /** @generated */
  final Feature casFeat_NEString;
  /** @generated */
  final int     casFeatCode_NEString;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getNEString(int addr) {
        if (featOkTst && casFeat_NEString == null)
      jcas.throwFeatMissing("NEString", "NE");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NEString);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNEString(int addr, String v) {
        if (featOkTst && casFeat_NEString == null)
      jcas.throwFeatMissing("NEString", "NE");
    ll_cas.ll_setStringValue(addr, casFeatCode_NEString, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NE_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_NEString = jcas.getRequiredFeatureDE(casType, "NEString", "uima.cas.String", featOkTst);
    casFeatCode_NEString  = (null == casFeat_NEString) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NEString).getCode();

  }
}



    