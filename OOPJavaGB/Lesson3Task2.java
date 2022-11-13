package OOPJavaGB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lesson3Task2 implements Iterable<Integer>{
	List<Integer> nums;

	public Lesson3Task2(){
		this.nums = new ArrayList<>();
	}

	public void Add(int num){
		nums.add(num);
	}

	public int Get(int num){
		for(int num1 : nums){
			if(num1 == num) return num;
		}
		return -1;
	}


	@Override
	public Iterator<Integer> iterator() {
		return new MyIterator();
	}

	public class MyIterator implements Iterator{

		int index;

		@Override
		public boolean hasNext() {
			return index < nums.size();
		}

		@Override
		public Integer next() {
			return nums.get(index++);
		}
	}
}
