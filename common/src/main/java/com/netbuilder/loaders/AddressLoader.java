/**
 * @author abutcher
 * @date 27/10/2015
 */

package com.netbuilder.loaders;

import java.util.ArrayList;

import com.netbuilder.connections.MongoPull;
import com.netbuilder.entities.Address;

public class AddressLoader {
	private MongoPull mp;
	private ArrayList<Address> addresses = new ArrayList<Address>();
	
	public AddressLoader() {
		mp = new MongoPull();
	}
	
	public ArrayList<Address> loadAddressByID(int addressID)
	{
		addresses.add(mp.getAddress(addressID));
		return addresses;
	}
}
