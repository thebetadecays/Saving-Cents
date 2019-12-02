package com.thebetadecays.SC_Model;

import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
* Instance-free class of static methods for loading and persisting data to files
* @author Jason Gurtz-Cayla
*/
final class DB {
/*
*TODO:
* - write individual save/read methods for Category, Model
*/
    /**
    * Constructor, private to simulating a static class (no instances)
    * @author Jason Gurtz-Cayla
    */
    private DB() {}
    /**
    * Saves contacts from ArrayList, overwriting ContactDB.txt
    * Line format: name\taddress\tphone\temail\tcategory\tsubCategory\n
    * @param ct Reference to a ArrayList<Contact> object
    * @author Jason Gurtz-Cayla
    */
    public static void saveContacts(ArrayList<Contact> ct) throws java.io.IOException {
        PrintWriter pw = DB.overwriteFile("ContactDB.txt");

        Iterator<Contact> itr_contact = ct.iterator();

        while(itr_contact.hasNext())
        {
            pw.println( itr_contact.next().toTSV() );
        }
        pw.close();
    }

    /**
    * Loads contacts from ContactDB.txt file into Contact object
    * Line format: name\taddress\tphone\temail\tcategory\tsubCategory\n
    * @param ct Reference to an ArrayList<Contact> object
    * @author Jason Gurtz-Cayla
    */
    public static void loadContacts(ArrayList<Contact> ct) throws java.io.IOException {
        Scanner s = DB.readFile("ContacDB.txt");

        while ( s.hasNextLine() ) {
            String[] line = s.nextLine().split("\t");
            ct.add( new Contact(line[0], line[1], line[2], line[3], line[4], line[5]) );
        }
        s.close();
    }

    /**
     * Saves expenses from ArrayList<Expense>, writes to file
     * @param exp ArrayList of Expense objects
     * @param pw Printwriter object for file writing
     * @author Skyler Novak
     */
    public static void saveExpenses(ArrayList<Expense> exp, PrintWriter pw) {

        // Iterator object to traverse ArrayList
        Iterator<Expense> itr_expense = exp.iterator();

        // Traverse ArrayList and print each record to the file
        while(itr_expense.hasNext())
        {
            pw.println( itr_expense.next().toTSV() );
        }

        // close print writer
        pw.close();

    } // saveExpenses()

    /**
     * Loads expenses from expense.txt file into Expense objects
     * @param e reference to an ArrayList<Expense> object
     * @param s Scanner object, generally obtained from readFile()
     * @author Skyler Novak
     */
    public static void loadExpenses(ArrayList<Expense> e, Scanner s) {
        // Will another method call loadExpense(e, readFile("Expense.txt"));    ???

        // Line format: dollar\tcent\tZonedatetime\tcontact\tcategory\tsubCategory\tmemo\n
        while (s.hasNextLine()) {

            // Get line from file
            String inputLine = s.nextLine();

            // Create tokenizer, set deliminator to '\t'
            StringTokenizer st = new StringTokenizer(inputLine, "\t");

            // Parse string, use each token as a parameter for new Expense object constructor
            e.add(new Expense(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
                    st.nextToken(), st.nextToken(), st.nextToken()));

        } // while (s.hasNextLine())

        // close input file
        s.close();

    } // loadExpenses()

    /**
    * Utility function for reading from a txt file, creating file if needed
    * @author Jason Gurtz-Cayla
    * @param fn File name to read from
    * @throws java.io.IOException Some issue with reading from contacts.txt file
    * @return Scanner object attached to the given file
    */
    private static Scanner readFile(String fn) throws IOException {
        File f = new File(fn);

        if ( ! f.exists() ) {
            f.createNewFile();
        }
        return new Scanner(f);
    }

    /**
    * Utility function for writing out (overwriting) the specific file
    * @author Jason Gurtz-Cayla
    * @param fn File name to overwrite
    * @throws java.io.IOException Some issue with writing to contacts.txt file
    * @return PrintWriter object attached to the given file
    */
    private static PrintWriter overwriteFile(String fn) throws IOException {
        FileWriter fw = new FileWriter(fn, false);
        return new PrintWriter(fw);
    }
}
