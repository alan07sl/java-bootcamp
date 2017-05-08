package com.globant.notifications;

import java.util.Observable;

public class ObservableProduct extends Observable{

	public synchronized void setChanged() {
		super.setChanged();
	}
}
