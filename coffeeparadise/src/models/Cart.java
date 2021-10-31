package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private HashMap<Integer, Item> cartItem;

	public Cart() {
		super();
		cartItem = new HashMap<Integer, Item>();
	}

	public Cart(HashMap<Integer, Item> cartItem) {
		super();
		this.cartItem = cartItem;
	}

	public HashMap<Integer, Item> getCartItem() {
		return cartItem;
	}

	public void setCartItem(HashMap<Integer, Item> cartItem) {
		this.cartItem = cartItem;
	}
	public void add(Integer idProduct,Item item) {
		boolean checkId= cartItem.containsKey(idProduct);
		if(checkId) {
			item.setAmount(item.getAmount());
			cartItem.put(item.getProduct().getProduct_id(), item);
		}else {
			cartItem.put(item.getProduct().getProduct_id(), item);
		}
	}
	public void del(Integer idProduct) {
		cartItem.remove(idProduct);
	}
	public int totalProduct() {
		int total = cartItem.size();
		return total;
	}
	public double totalMoney() {
		double total = 0;
		for(Map.Entry<Integer, Item> productItem : cartItem.entrySet()) {
			total += productItem.getValue().getMoney() * productItem.getValue().getAmount() * (100 - productItem.getValue().getProduct().getPromotion()) /100;
		}System.out.println(total);
		return total;
	}
}
