package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterate over all the elements in the collection without knowing the structure
 * of the collection.
 * 
 * @author Kanchanok Kannee
 *
 * @param <T> the type of thing in the ArrayIterator.
 */

public class ArrayIterator<T> implements Iterator<T> {
	/** If legal was true, continue the process. */
	private boolean can;
	/** remember its position in the collection */
	private int cursor;
	/** attribute for the array we want to iterate over */
	private T[] array;

	/**
	 * Initialize a new array iterator with the array to process.
	 * 
	 * @param array is the array to iterate over
	 */
	public ArrayIterator(T[] array) {
		this.array = array;
		this.can = false;

	}

	/**
	 * Return the next non-null element from array, if any.
	 * 
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException
	 *             if there are no more elements to return.
	 */
	@Override
	public T next() {
		if (this.hasNext() == true) {
			this.cursor++;
			this.can = true;
			return array[cursor - 1];
		} else {
			throw new NoSuchElementException();
		}

	}

	/**
	 * Return true if next() can return another non-null array element
	 * 
	 * @return true if next() can return another non-null array element, false
	 *         if no more elements.
	 */
	@Override
	public boolean hasNext() {
		for (int i = this.cursor; i < this.array.length; i++) {
			if (this.array[i] != null) {
				this.cursor = i;
				return true;
			}
		}
		return false;

	}

	/**
	 * Remove most recent element returned by next() from the array by setting
	 * it to null. This method may only be called once after a call to next().
	 * If this method is called without calling next(). or called more than once
	 * after calling next(), it throws IllegalStateException.
	 * 
	 * @throws IllegalStateException
	 *             if the next method has not yet been called, or the remove
	 *             method has already been called after the last call to the
	 *             next method
	 */
	public void remove() {
		if (can == true) {
			array[cursor - 1] = null;
			can = false;
		} else {
			throw new IllegalStateException();
		}

	}

}
