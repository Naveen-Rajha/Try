package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Json {
    public static void main (String[] args)
    {
        List<String> list =
                Collections.synchronizedList(new ArrayList<String>());

        list.add("practice");
        list.add("code");
        list.add("quiz");
        list.add("try");
        list.add("hi");
        list.add("hello");
            // must be in synchronized block
            Iterator it = list.iterator();

            while (it.hasNext())
                System.out.println(it.next());

    }
}
