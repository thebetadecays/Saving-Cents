package com.thebetadecays.SavingCents_Model;

import com.thebetadecays.SavingCents.Contact;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
* - finish saveContacts
* - write individual save/read methods for Expense, Category, Model
*/
    /**
    * Constructor, private to simulating a static class (no instances)
    * @author Jason Gurtz-Cayla
    */
    private DB() {}
    /**
    * Saves contacts from ArrayList, overwriting ContactDB.txt
    * @param ct Reference to a ArrayList<Contact> object
    * @param pw PrintWriter object, typically gained from overwriteFile(file)
    * @author Jason Gurtz-Cayla
    */
    public static void saveContacts(ArrayList<Contact> ct, PrintWriter pw) {
        //TODO: generate and write the lines
        // Line format: name\taddress\tphone\temail\tcategory\tsubCategory\n
        /*
        if (ct.getFirst() != null) {
            Node cur = ct.getFirst();
            do {
                pw.print( cur.getName() + '\n' + cur.getNumber() + '\n' );
                cur = cur.getNext();
            }
            while ( cur != null );
        }
        */
        pw.close();
    }

    /**
    * Loads contacts from ContactDB.txt file into Contact object
    * @param ct Reference to an ArrayList<Contact> object
    * @param s Scanner object, generally obtained via readFile()
    * @author Jason Gurtz-Cayla
    */
    public static void loadContacts(ArrayList<Contact> ct, Scanner s) {
        // Line format: name\taddress\tphone\temail\tcategory\tsubCategory\n
        while ( s.hasNextLine() ) {
            String[] line = s.nextLine().split("\t");
            ct.add( new Contact(line[0], line[1], line[2], line[3], line[4], line[5]) );
        }
        s.close();
    }

    public static void saveExpenses(ArrayList<Expense> exp, PrintWriter pw) {
        Iterator<Expense> itr_expense = exp.iterator();

        while(itr_expense.hasNext())
        {
            pw.println( itr_expense.next().toTSV() );
        }
        pw.close();
    }

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
    * @throws IOException Some issue with reading from contacts.txt file
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
    * @throws IOException Some issue with writing to contacts.txt file
    * @return PrintWriter object attached to the given file
    */
    private static PrintWriter overwriteFile(String fn) throws IOException {
        FileWriter fw = new FileWriter(fn, false);
        return new PrintWriter(fw);
    }
}
