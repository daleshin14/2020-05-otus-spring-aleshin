package ru.daleshin.spring.service;


public interface InputOutputService {
	
    String nextLine();
    boolean hasNextLine();
    
    void print(String data);
    void println(String data);
    
    String nextLineConsole();
}
