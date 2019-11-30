/**
* Instance-free class of static methods for loading and persisting data to files
* @author Jason Gurtz-Cayla
*/
private final class DB {
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
        if (cLst.getFirst() != null) {
            Node cur = cLst.getFirst();
            do {
                pw.print( cur.getName() + '\n' + cur.getNumber() + '\n' );
                cur = cur.getNext();
            }
            while ( cur != null );
        }
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
            ct.add( new Contact(line[0], line[1], line[2], line[3], line[4], line[5]) )
        }
        s.close();
    }

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
