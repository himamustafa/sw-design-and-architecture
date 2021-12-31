package com.example.uber;

import java.util.ArrayList;
import java.util.List;
public interface Subject 
{
	List<Observer> obs = new ArrayList<>();
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate();
}
