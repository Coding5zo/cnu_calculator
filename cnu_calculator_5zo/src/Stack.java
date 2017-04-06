public interface Stack<T> {
	public boolean push(T anEntry);
	
	public T pop();
	
	public T peek();
	
	public boolean isEmpty();
	
	public void clear();
}
