package fpi;

import java.util.ArrayList;

/* This class with generic <E> provides the fixed-point iteration method
 * which deals with a function from the field of <E> to itself
 * which is defined in setFunction(). */ 
public abstract class FixedPointIteration<E> {
	private int max_iteration; // 0 is for infinite.
	private int max_repetition; // 0 is for infinite.
	private ArrayList<E> last_success_log;

	public FixedPointIteration(int max_iteration, int max_repetition) {
		this.max_iteration = max_iteration;
		this.max_repetition = max_repetition;
		this.last_success_log = null;
	}

	public FixedPointIteration() {
		this(0, 0);
	}

	// compare(E, E) defines an equality between two objects.
	public abstract boolean compare(E obj1, E obj2);

	// setFunction(E) defines a function of the fixed-point iteration. 
	public abstract E setFunction(E param);

	// generateRandomValue() generates a random initial value.
	public E generateRandomValue() throws NotImplementedException {
		throw new NotImplementedException("generateRandomValue()");
	}

	// getStringForm(E) returns a representation of <E>.
	public String getStringForm(E obj) {
		return obj.toString();
	}

	// findRoot(E) gives a fixed point with the given initial value.
	// This only runs max_iteration times.
	public E findRoot(E init) throws Exception {
		if (init == null)
			return null;

		ArrayList<E> log = new ArrayList<E>();
		log.add(init);

		E res = null;
		for (int i = 0; i < max_iteration || max_iteration == 0; i++) {
			res = setFunction(init);
			if (res == null || isRepeated(log, res))
				break;
			if (compare(log.get(log.size() - 1), res)) {
				last_success_log = log;
				return res;
			}
			log.add(res);
			init = res;
		}
		throw new RootFindingException(max_iteration);
	}

	// findRoot() runs findRoot(E) max_repetition times with random initial values.
	public E findRoot() throws Exception {
		for (int i = 0; i < max_repetition || max_repetition == 0; i++) {
			System.out.println(i);
			try {
				return findRoot(generateRandomValue());
			} catch (RootFindingException e) {
			}
		}
		throw new RootFindingException(max_iteration, max_repetition);
	}

	public String findRootInStringForm(E init) throws Exception {
		return getStringForm(findRoot(init));
	}

	public String findRootInStringForm() throws Exception {
		return getStringForm(findRoot());
	}

	private boolean isRepeated(ArrayList<E> log, E res) {
		for (int i = log.size() - 2; i >= 0; i--)
			if (compare(log.get(i), res))
				return true;
		return false;
	}

	public int getMaxIteration() {
		return max_iteration;
	}

	public void setMaxIteration(int max_iteration) {
		this.max_iteration = max_iteration;
	}

	public int getMaxRepetition() {
		return max_repetition;
	}

	public void setMaxRepetition(int max_repetition) {
		this.max_repetition = max_repetition;
	}

	public ArrayList<E> getLog() {
		return this.last_success_log;
	}

	public void printLog() {
		if (last_success_log == null) {
			System.out.println("Fixed-point iteration has not succeeded.");
			return;
		}

		System.out.println("Last success iteration:");
		for (int i = 0; i < last_success_log.size(); i++) {
			System.out.println("(" + i + ")\t"
					+ getStringForm(last_success_log.get(i)));
		}
		System.out.println("End.");
	}
}
