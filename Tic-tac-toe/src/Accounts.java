/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LapStore
 */
class Accounts {
     private  int ID;
   private  String Pname;
   private String Pemail;
    private String Pip;

    public Accounts(int ID, String Pname, String Pemail, String Pip) {
        this.ID = ID;
        this.Pname = Pname;
        this.Pemail = Pemail;
        this.Pip = Pip;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public String getPemail() {
        return Pemail;
    }

    public void setPemail(String Pemail) {
        this.Pemail = Pemail;
    }

    public String getPip() {
        return Pip;
    }

    public void setPip(String Pip) {
        this.Pip = Pip;
    }
    
    
}
