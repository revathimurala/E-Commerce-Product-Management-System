package com.example.app;

import com.example.mypack.Greeting;

/**
 * Main that uses the user-defined package com.example.mypack
 */
public class Main {
    public static void main(String[] args) {
        String msg = Greeting.sayHello("Student");
        System.out.println(msg);
    }
}
