import java.util.List;
import java.util.ArrayList;
public class PriorityQueue {
	private List<Integer> queue;
	public PriorityQueue() {
		queue=new ArrayList<>();
	}
	public void add(int num) {
		queue.add(num);
		int rear=queue.size()-1;
		while(rear>0) {
			int index=(rear-1)/2;
			if(queue.get(rear)<=queue.get(index)) {
				break;
			}
			swap(rear,index);
			rear=index;
		}
	}
	public int remove() {
		if(queue.isEmpty()) {
			System.out.println("Queue is empty");
			System.exit(-1);
		}
		int root=queue.get(0);
		int rear=queue.size()-1;
		queue.set(0, queue.get(rear));
		queue.remove(rear);
		rear--;
		//
		int currentIndex = 0; 
		while (true) { 
		int leftChild= 2 * currentIndex + 1; 
		int rightChild= 2 * currentIndex + 2; 
		int maxIndex = currentIndex; 

		if (leftChild <= rear && queue.get(leftChild) > queue.get(maxIndex)) { 
		maxIndex = leftChild; 
		} 

		if (rightChild <= rear && queue.get(rightChild) > queue.get(maxIndex)) { 
		maxIndex = rightChild; 
		} 

		if (maxIndex == currentIndex) { 
		break; 
		} 

		swap(currentIndex, maxIndex); 
		currentIndex = maxIndex; 
		} 

		return root; 
		
	}
	private void swap(int i, int j) { 
		int temp = queue.get(i); 
		queue.set(i, queue.get(j)); 
		queue.set(j, temp); 
}
}