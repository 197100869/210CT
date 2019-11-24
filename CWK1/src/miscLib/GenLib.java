package miscLib;

/**
 * Title:   	GenLib
 * Description:	Provides class methods to generate different values
 *				such as int (integer).
 * Company:		ICT IVE(TY)
 * @author      Patrick Tong
 */

public abstract class GenLib {

	/**
	 *	randomly generate an integer between start and end inclusively.
	 */
	public static int genInt(int start, int end) {
		if (start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		return ( (int)(Math.random() * (end - start + 1)) + start );
	}


} // class GenLib