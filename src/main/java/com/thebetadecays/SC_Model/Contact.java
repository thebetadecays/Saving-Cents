package com.thebetadecays.SC_Model;

/**
* Class which holds a contact
* @author Jason Gurtz-Cayla
*/
public class Contact {
    private String name = new String("");
    private String address = new String("");
    private String phone = new String("");
    private String email = new String("");
    private String category = new String("");
    private String subCategory = new String("");

    /**
    * Contructor one: use 2nd constructor to set name, everything else blank
    * @author Jason Gurtz-Cayla
    */
    public Contact(String n) {
        this(n, "", "", "", "", "");
    }

    /**
    * Contructor two: set all fields explicitly
    * @author Jason Gurtz-Cayla
    */
    public Contact(String n, String a, String p, String e, String c, String sc) {
        this.name = n;
        this.address = a;
        this.phone = p;
        this.email = e;
        this.category = c;
        this.subCategory = sc;
    }

    /**
    * Helper method used to generate tab-seperated values for persisting to disk
    * @author Jason Gurtz-Cayla
    * @return Fields in tsv format
    */
    public String toTSV() {
        // Line format: name\taddress\tphone\temail\tcategory\tsubCategory [newline not included]
        return String.format("%s\t%s\t%s\t%s\t%s\t%s",
            this.getName(),
            this.getAddress(),
            this.getPhone(),
            this.getEmail(),
            this.getCategory(),
            this.getSubCategory() );
    }

    /**
    * Getter for name
    * @author Jason Gurtz-Cayla
    * @return Name of contact as a String object
    */
    public String getName() {
        return this.name;
    }

    /**
    * Getter for address
    * @author Jason Gurtz-Cayla
    * @return Street address of contact as a String object
    */
    public String getAddress() {
        return this.address;
    }

    /**
    * Getter for phone
    * @author Jason Gurtz-Cayla
    * @return Phone number of contact as a String object
    */
    public String getPhone() {
        return this.phone;
    }

    /**
    * Getter for email
    * @author Jason Gurtz-Cayla
    * @return Email address of contact as a String object
    */
    public String getEmail() {
        return this.email;
    }

    /**
    * Getter for category
    * @author Jason Gurtz-Cayla
    * @return Category assigned to contact as a String object
    */
    public String getCategory() {
        return this.category;
    }

    /**
    * Getter for subCategory
    * @author Jason Gurtz-Cayla
    * @return Sub-category assigned to contact as a String object
    */
    public String getSubCategory() {
        return this.subCategory;
    }

    /**
    * Setter for name
    * @author Jason Gurtz-Cayla
    * @param n Name of contact
    */
    public void setName(String n) {
        this.name = n;
    }

    /**
    * Setter for address
    * @author Jason Gurtz-Cayla
    * @param a Street address of contact
    */
    public void setAddress(String a) {
        this.address = a;
    }

    /**
    * Setter for phone
    * @author Jason Gurtz-Cayla
    * @param p Phone number of contact
    */
    public void setPhone(String p) {
        this.phone = p;
    }

    /**
    * Setter for email
    * @author Jason Gurtz-Cayla
    * @param e Contact's email address
    */
    public void setEmail(String e) {
        this.email = e;
    }

    /**
    * Setter for Category
    * @author Jason Gurtz-Cayla
    * @param c Default Category assigned to contact
    */
    public void setCategory(String c) {
        this.category = c;
    }

    /**
    * Setter for subCategory
    * @author Jason Gurtz-Cayla
    * @param sc Sub-Category name
    */
    public void setSubCategory(String sc) {
        this.subCategory = sc;
    }
}
