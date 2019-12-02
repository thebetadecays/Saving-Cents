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
     * This should ONLY be used for the King Category!!!
     * @author Moses Howard
     * @exception java.io.IOException
     **/
    public void writeCategory() throws IOException {
        FileWriter fileWriter = new FileWriter("categories.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s:%d{ ", name, percentage);
        for (Category cat: subCategories){
            cat.writeCategoryHelper();
        }
        printWriter.print("}");
        printWriter.close();
    }

    /**
     * WriteCategory opens a file and recursively writes the contents of the category to the category file.
     * This should ONLY be initiated from the root of the King Category
     * @author Moses Howard
     * @exception java.io.IOException
     **/
    public void writeCategoryHelper() throws IOException {
        FileWriter fileWriter = new FileWriter("categories.txt",true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s:%d{ ", name, percentage);
        for (Category cat: subCategories){
            cat.writeCategoryHelper();
        }
        printWriter.print("}");
        printWriter.close();
    }
    /**
     * WriteCategory opens a file and recursively writes the contents of the category file to the category.
     * This should ONLY be initiated from the King Category
     * @author Moses Howard
     * @exception fileNotFoundException
     **/
    public static void makeCategories()throws FileNotFoundException {

        //creating File instance to reference text file in Java
        File text = new File("categories.txt");
        String categoryText = text.toString();
        Category king = new Category();
        king.readCategory(categoryText);
    }
    /**
     * WriteCategory opens a file and recursively writes the contents of the category file to the category.
     * This should ONLY be initiated from the root of the King Category
     * @author Moses Howard
     * @param txt - a string that contains the information for the category and all subcategories
     **/
    public void readCategory(String txt){
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
                        cat.readCategory(subCategoryString);
                        subCategories.add(cat);
                    }
                }
            }
            x+=1;
        }
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
