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

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (this.canInsert) {
					if (initialList.contains(newElement)) {					
						this.list.add(newElement);
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
		};
	}

}
