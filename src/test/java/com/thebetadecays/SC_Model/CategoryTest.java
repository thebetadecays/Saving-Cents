
package com.thebetadecays;

import com.thebetadecays.SC_Model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class CategoryTest {
    /**
     * tests to see if any errors occur in file creation.
     * @author Moses Howard
     **/
    @Test
    void writeCategory() throws java.io.IOException {
        try{
            Category mainCategory = new Category();
            Category subCategory1 = new Category();
            Category subCategory2 = new Category();
            mainCategory.setName("Food");
            mainCategory.setPercentage(100);
            subCategory1.setName("Fast Food");
            subCategory1.setPercentage(30);
            subCategory2.setName("Groceries");
            subCategory2.setPercentage(70);
            ArrayList<Category> list = new ArrayList<Category>();
            list.add(subCategory1);
            list.add(subCategory2);
            mainCategory.setSubCategories(list);
            mainCategory.writeCategory();
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }
    /**
     * tests to see if any errors occur in reading from the file.
     * @author Moses Howard
     **/
    @Test
    void makeCategories() throws java.io.IOException{
        Category mainCategory = new Category();
        Category subCategory1 = new Category();
        Category subCategory2 = new Category();
        mainCategory.setName("Food");
        mainCategory.setPercentage(100);
        subCategory1.setName("Fast Food");
        subCategory1.setPercentage(30);
        subCategory2.setName("Groceries");
        subCategory2.setPercentage(70);
        ArrayList<Category> list = new ArrayList<Category>();
        list.add(subCategory1);
        list.add(subCategory2);
        mainCategory.setSubCategories(list);
        mainCategory.writeCategory();
        Category newMain = new Category();
        newMain.makeCategories();
        assertEquals(newMain.getName(),"Food");
    }
    /**
     * tests to see if the subcategory is created and instantiated with the proper variables.
     * @author Moses Howard
     **/
    @org.junit.jupiter.api.Test
    void addSubCategory() {
        Category mainCategory = new Category();
        mainCategory.setName("Food");
        mainCategory.setPercentage(100);
        mainCategory.addSubCategory("Fast Food",100);
        String testName = mainCategory.getSubCategories().get(0).getName();
        assertEquals(testName,"Fast Food");
    }
    /**
     * tests to see if any errors occur in generating a Category and it's subcategories.
     * @author Moses Howard
     **/
    @Test
    void generateCategories() throws java.io.IOException{
        try{
            Category mainCategory = new Category();
            Category subCategory1 = new Category();
            Category subCategory2 = new Category();
            mainCategory.setName("Food");
            mainCategory.setPercentage(100);
            subCategory1.setName("Fast Food");
            subCategory1.setPercentage(30);
            subCategory2.setName("Groceries");
            subCategory2.setPercentage(70);
            ArrayList<Category> list = new ArrayList<Category>();
            list.add(subCategory1);
            list.add(subCategory2);
            mainCategory.setSubCategories(list);
        }
        catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }
}