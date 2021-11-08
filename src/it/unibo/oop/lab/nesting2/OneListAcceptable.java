package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	
	public OneListAcceptable(List<T> list) {
		super();
		this.list = list;
	}



	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void end() throws EndNotAcceptedException {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
