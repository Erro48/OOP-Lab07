package it.unibo.oop.lab.nesting2;

import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	
	public OneListAcceptable(List<T> list) {
		super();
		this.list = list;
	}



	@Override
	public Acceptor<T> acceptor() {
		// TODO Auto-generated method stub
		return null;
	}

}
