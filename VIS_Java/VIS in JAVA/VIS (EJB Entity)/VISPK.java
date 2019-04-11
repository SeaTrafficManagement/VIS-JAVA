package VIS;


/**
 * @author m02amiol
 * @version 1.0
 * @created 19-aug-2016 16:12:24
 */
public class VISPK implements java.io.Serializable {

	public int vISID;

	public VISPK(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param id
	 */
	public VISPK(int id){
		this.vISID = id;
	}

	/**
	 * 
	 * @param obj
	 */
	public boolean equals(Object obj){
		return false;
	}

	public int hashCode(){
		return 0;
	}
}//end VISPK