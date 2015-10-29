/**
 * @author dwoodward
 * @date 29/10/2015
 * 
 * Class to convert between the item type the website uses and the item type the IMS uses.
 */

package converter;

public class ItemConverter {
	
	private com.netbuilder.test.Item webItem;
	private entities.Item entItem;
	
	public ItemConverter() {
	
	}
	
	public com.netbuilder.test.Item convertToWebItem(entities.Item i) {
		
		entItem = i;
		String so = "" + i.getIdItem();
		
		
		
		
		
		
		return webItem;
	}
	
	
	
	
	
	
	

}
