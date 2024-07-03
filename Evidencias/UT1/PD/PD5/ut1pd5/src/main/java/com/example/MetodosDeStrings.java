package com.example;

public class MetodosDeStrings {
  
  public static void main(String[] args) {

    String initial = "Hola";
    String initial2 = " Hola ";
    String initial3 = "Holaaaaa";

    String sub1 = initial.substring(1,3);
    System.out.println(sub1);
    String sub2 = initial.substring(1);
    System.out.println(sub2);

    String[] split1 = initial.split("");
    for(String s: split1){
      System.out.println(s);
    }
    String[] split2 = initial.split("",2);
    for(String s: split2){
      System.out.println(s);
    }
  
    CharSequence subsec = initial.subSequence(1,2);
    System.out.println(subsec);

    System.out.println(initial2);
    String trimstr = initial2.trim();
    System.out.println(trimstr);

    String lower = initial.toLowerCase();
    System.out.println(lower);
    String upper = initial.toUpperCase();
    System.out.println(upper);

    int index1 = initial.indexOf(0);
    System.out.println(index1);
    int index2 = initial.indexOf(0,1);
    System.out.println(index2);
    int index3 = initial.indexOf("o");
    System.out.println(index3);
    int index4 = initial.indexOf("a",1);
    System.out.println(index4);

    int index5 = initial.lastIndexOf(0);
    System.out.println(index5);
    int index6 = initial.lastIndexOf(0,1);
    System.out.println(index6);
    int index7 = initial.lastIndexOf("o");
    System.out.println(index7);
    int index8 = initial.lastIndexOf("l",3);
    System.out.println(index8);

    boolean contains = initial.contains("a");
    System.out.println(contains);

    String replaced1 = initial.replace("o", "u");
    System.out.println(replaced1);
    String replaced2 = initial.replace("ol", "lo");
    System.out.println(replaced2);

    String allReplaced = initial3.replaceAll("a", "i");
    System.out.println(allReplaced);

    String firstReplaced = initial3.replaceFirst("a", "u");
    System.out.println(firstReplaced);
  }
}
