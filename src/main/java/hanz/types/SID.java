

/* First created by JCasGen Tue Oct 07 22:42:08 EDT 2014 */
package hanz.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Tue Oct 07 22:42:08 EDT 2014
 * XML source: /Users/hanz/Desktop/Dropbox/Workspace/hw2-hanz/src/main/resources/descriptors/typeSystemDescriptor.xml
 * @generated */
public class SID extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SID.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected SID() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SID(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SID(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (SID_Type.featOkTst && ((SID_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "hanz.types.SID");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SID_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (SID_Type.featOkTst && ((SID_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "hanz.types.SID");
    jcasType.ll_cas.ll_setStringValue(addr, ((SID_Type)jcasType).casFeatCode_id, v);}    
  }

    