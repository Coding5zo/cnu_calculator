public class ArrayList<T> implements Stack<T> {
	private static final int DEFAULT_MAX_STACK_SIZE = 5;
	private int _maxSize;
	private int _top;
	private T[] _elements;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		this._maxSize = DEFAULT_MAX_STACK_SIZE;
		this._top = -1;
		this._elements = (T[]) new Object[DEFAULT_MAX_STACK_SIZE];
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int maxSize) {
		this._maxSize = maxSize;
		this._top = -1;
		this._elements = (T[]) new Object[maxSize];
	}

	@Override
	public boolean push(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
