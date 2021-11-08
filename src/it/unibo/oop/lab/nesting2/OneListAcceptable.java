package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	final private List<T> initialList;
	
	public OneListAcceptable(List<T> list) {
		super();
		this.initialList = list;
	}



	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {
			
			private List<T> list = new ArrayList<>();
			private boolean canInsert = true;
			private int lastPosition = 0;

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (this.canInsert) {
					if (initialList.get(lastPosition).equals(newElement)) {					
						this.list.add(newElement);
						this.lastPosition++;
						this.correctBound();
					} else {
						throw new Acceptor.ElementNotAcceptedException(newElement);
					}
				}
			}

			@Override
			public void end() throws EndNotAcceptedException {
				this.canInsert = false;
				if(initialList.size() > this.list.size()) {
					throw new EndNotAcceptedException();
				}
			}
			
			private void correctBound() {
				if (this.lastPosition >= initialList.size()) {
					this.lastPosition = initialList.size() - 1;
				}
			}
		};
	}

}
