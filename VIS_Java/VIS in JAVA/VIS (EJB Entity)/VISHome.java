package VIS;


/**
 * @author m02amiol
 * @version 1.0
 * @created 19-aug-2016 16:12:15
 */
public interface VISHome extends javax.ejb.EJBHome {

	/**
	 * 
	 * @exception javax.ejb.CreateException,
	 * @exception java.rmi.RemoteException
	 */
	public VIS create()
	  throws javax.ejb.CreateException, java.rmi.RemoteException;

	/**
	 * 
	 * @param key
	 * @exception javax.ejb.FinderException,
	 * @exception java.rmi.RemoteException
	 */
	public VIS findByPrimaryKey(VISPK key)
	  throws javax.ejb.FinderException, java.rmi.RemoteException;

}