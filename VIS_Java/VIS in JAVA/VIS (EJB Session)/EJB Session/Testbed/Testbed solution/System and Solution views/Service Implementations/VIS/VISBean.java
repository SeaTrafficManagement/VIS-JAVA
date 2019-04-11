package VIS;


/**
 * @author m02amiol
 * @version 1.0
 * @created 19-aug-2016 16:09:23
 */
public class VISBean implements javax.ejb.SessionBean {

	private javax.ejb.SessionContext ctx;

	public VISBean(){

	}

	public void finalize() throws Throwable {

	}
	public void ejbActivate(){

	}

	public void ejbCreate(){

	}

	public void ejbPassivate(){

	}

	public void ejbRemove(){

	}

	/**
	 * 
	 * @param ctx
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx){
		this.ctx = ctx;
	}
}//end VISBean