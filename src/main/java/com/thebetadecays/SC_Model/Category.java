package com.thebetadecays.SC_Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Category {
    private String name;
    private int percentage;
    private ArrayList<Category> subCategories;

    /**
     * WriteCategory opens a file and recursively writes the contents of the category to the category file.
     * The difference between writeCategory and writeCategory helper is that the helper only appends to file.
     * This should ONLY be used by the King Category!!!
     * @author Moses Howard
     * @exception java.io.IOException
     **/
    public void writeCategory() throws IOException {
        FileWriter fileWriter = new FileWriter("categories.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s:%d{ ", name, percentage);
        printWriter.close();
        for (Category cat: subCategories){
            cat.writeCategoryHelper();
        }
        FileWriter fW = new FileWriter("categories.txt",true);
        PrintWriter pW = new PrintWriter(fileWriter);
        printWriter.print("}");
        printWriter.close();
    }

    /**
     * WriteCategory opens a file and recursively writes the contents of the category to the category file.
     * This should ONLY be initiated by writeCategory!!!
     * @author Moses Howard
     * @throws  java.io.IOException
     **/
    private void writeCategoryHelper() throws IOException {
        FileWriter fileWriter = new FileWriter("categories.txt",true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s:%d{ ", name, percentage);
        printWriter.close();
        for (Category cat: subCategories){
            cat.writeCategoryHelper();
        }
        FileWriter fW = new FileWriter("categories.txt",true);
        PrintWriter pW = new PrintWriter(fileWriter);
        printWriter.print("}");
        printWriter.close();
    }
    /**
     * makeCategories opens a file and  reads the contents of the file into a single string.
     * The string contains all information for all categories and will be passed to makeCategoryHelper.
     * This should ONLY be initiated from the King Category!!!
     * @author Moses Howard
     * @throws FileNotFoundException
     **/
    public static void makeCategories() throws FileNotFoundException {

        //creating File instance to reference text file in Java
        File text = new File("categories.txt");
        String categoryText = text.toString();
        Category king = new Category();
        king.makeCategoryHelper(categoryText);
    }
    /**
     * makeCategoryHelper uses a string and recursively parses the contents of the string to the category and all
     * subsequent subcategories.
     * This should ONLY be initiated from makeCategories!!!
     * @author Moses Howard
     * @param txt - a string that contains the information for the category and all subcategories
     **/
    private void makeCategoryHelper(String txt){
        String percentageString;
        int pointer = 0;
        int x = 0;
        int stack = 0;
        boolean nameFlag = false;
        boolean percentageFlag = false;
        while (txt.charAt(x) < txt.length()){
            if (txt.charAt(x) == ':'){
                if (nameFlag == false){
                    name = txt.substring(pointer, x);
                    nameFlag = true;
                    pointer = x+1;
                }
            }
            if (txt.charAt(x) == '{'){
                stack+=1;
                if(percentageFlag == false){
                    percentageString = txt.substring(pointer, x);
                    percentage = Integer.parseInt(percentageString);
                    percentageFlag = true;
                    pointer = x+1;
                }
            }
            if (txt.charAt(x) == '}'){
                stack -=1;
                if (stack == 1){
                    if (txt.charAt(x-1) != '{') {
                        String subCategoryString = txt.substring(pointer, x+1);
                        pointer = x+1;
                        Category cat = new Category();
                        cat.makeCategoryHelper(subCategoryString);
                        subCategories.add(cat);
                    }
                }
            }
            x+=1;
        }
    }

    /**
     * addSubCategory makes it simple to add a new subcategory to an existing category.
     * @author Moses Howard
     * @param name - a string that will be the name of the new subCategory
     * @param percentage - an int that will be the  of the new subCategory
     **/
    public void addSubCategory(String name,int percentage){
        Category cat = new Category();
        cat.setName(name);
        cat.setPercentage(percentage);
        this.getSubCategories().add(cat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public ArrayList<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<Category> subCategories) {
        this.subCategories = subCategories;
    }
}


