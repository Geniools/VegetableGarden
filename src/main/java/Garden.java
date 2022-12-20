import java.util.HashSet;

public class Garden {
	private HashSet<Vegetable> vegetables;

	public Garden() {
		this.vegetables = new HashSet<>();
	}

	public HashSet<Vegetable> getVegetables() {
		return this.vegetables;
	}

	public void  addVegetable(Vegetable vegetable){
		this.vegetables.add(vegetable);
	}
}
