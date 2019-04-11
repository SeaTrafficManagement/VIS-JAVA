package VIS;


/**
 * @author m02amiol
 * @version 1.0
 * @created 19-aug-2016 16:09:23
 */
public interface VISHome extends javax.ejb.EJBHome {

	/**
	 * 
	 * @exception javax.ejb.CreateException,
	 * @exception java.rmi.RemoteException
	 */
	public VIS create()
	  throws javax.ejb.CreateException, java.rmi.RemoteException;

}