package com.example.uber;

import java.util.ArrayList;

public interface Observer 
{
    public void update();
    public void attachSubject(Subject j);
}
