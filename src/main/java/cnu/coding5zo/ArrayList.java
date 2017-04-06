package cnu.coding5zo;
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
	
	public boolean isFull() {
		return (this._top == this._maxSize - 1);
	}

	public int size() {
		return this._top + 1;
	}

	@Override
	public boolean push(T newElement) {
		// TODO Auto-generated method stub
		if (this.isFull()) {
			return false;
		} else {
			this._top++;
			this._elements[this._top] = newElement;
			return true;
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			return null;
		} else {
			return this._elements[this._top--];
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			return null;
		} else {
			return this._elements[this._top];
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this._top == -1);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this._top = -1;
		this._elements = null;
	}
	
	public T findElementByOrder(int order) {
		if (this.isEmpty()) {
			return null;
		} else {
			return this._elements[order];
		}
	}
}
