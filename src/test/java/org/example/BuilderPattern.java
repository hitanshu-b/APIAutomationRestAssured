package org.example;

public class BuilderPattern {
    //Change return type of each method as Class Type
    // this always points to current/calling object, Returning the same to have same reference

    public BuilderPattern Stage1(){
        System.out.println("Stage 1");
        return this;
    }

    public BuilderPattern Stage2(String str){
        System.out.println("Stage 2 string is: "+str);
        return this;
    }

    public BuilderPattern Stage3(){
        System.out.println("Stage 3");
        return this;
    }

    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern();
        bp.Stage1().Stage2("Test").Stage3();
    }
}
