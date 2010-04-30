/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author Frendhi Dan Meta
 */
public class LoveLove extends MIDlet implements CommandListener {

    private Display display;

    //form
    private Form home;
    private Form pria;
    private Form wanita;
    private Form hasil;

    //textfield
    private TextField namapria;
    private TextField namawanita;
    private TextField kalimatpria;
    private TextField kalimatwanita;

    //command
    private Command masuk;
    private Command next1;
    private Command ramal;
    private Command back1;
    private Command exit;
    private Command finish;

    //kalkulasi
    
    private String namacowo="";
    private String namacewe="";
    private String kalimat1="";
    private String kalimat2="";

    

    public boolean containsAny(String str, String str2) {
        char[] searchChars = str2.toCharArray();
      if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
          return false;
      }
      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          for (int j = 0; j < searchChars.length; j++) {
              if (searchChars[j] == ch) {
                  return true;
              }
          }
      }
      return false;
    }

    public String hrfygsama(String str, String str2) {
      String ygsama = "";
      String tmp = "";
      char [] searchChars = str2.toCharArray();
      boolean beda = true;
        if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
          return ygsama;
      }
      for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
          for (int j = 0; j < searchChars.length; j++) {
              if (searchChars[j] == ch) {
                  tmp= tmp + ch;
                  if(!this.containsAny(ygsama, tmp)){
                      ygsama = ygsama + searchChars[j];
                  }
                  tmp = "";
              }
          }
      }
      return ygsama;
     }


    public LoveLove() {
        home = new Form ("Salam Cinta");
        pria = new Form ("Hei Pria");
        wanita = new Form ("Hei Wanita");
        hasil = new Form ("Kata Dewa Dewi Cinta");

        namapria = new TextField("Masukkan Nama Pria",null,20, TextField.ANY);
        namawanita = new TextField("Masukkan Nama Wanita",null, 20, TextField.ANY);
        kalimatpria = new TextField("Kalimat Pria",null, 30, TextField.ANY);
        kalimatwanita = new TextField("Kalimat wanita",null, 30, TextField.ANY);

        masuk = new Command("masuk",Command.SCREEN,1);
        next1 = new Command("Lanjut",Command.SCREEN,1);
        back1 = new Command("Kembali",Command.SCREEN,1);
        ramal = new Command("Ramal",Command.OK,1);
        finish = new Command("Selesai",Command.SCREEN,1);
        exit = new Command("Keluar",Command.EXIT, 1);

        home.append("love love love");
        pria.append(namapria);
        pria.append(kalimatpria);
        wanita.append(namawanita);
        wanita.append(kalimatwanita);
       


        home.addCommand(masuk);
        home.addCommand(exit);
        pria.addCommand(next1);
        pria.addCommand(back1);
        wanita.addCommand(ramal);
        hasil.addCommand(finish);
        hasil.addCommand(exit);

        home.setCommandListener(this);
        pria.setCommandListener(this);
        wanita.setCommandListener(this);
        hasil.setCommandListener(this);

   }


    public void startApp() {
        if(display == null) {
            display = Display.getDisplay(this);
            display.setCurrent(home);
           }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c==exit) {
         destroyApp(true);
         notifyDestroyed();
     }
     else if (c==masuk) {
         display.setCurrent(pria);
     }
     else if (c==back1) {
         display.setCurrent(home);
     }
     else if (c==next1) {
         display.setCurrent(wanita);
     }
     else if (c==ramal) {
         namacowo="";
         namacewe="";
         namacowo=namapria.getString();
         namacewe=namawanita.getString();
         kalimat1=kalimatpria.getString();
         kalimat2=kalimatwanita.getString();
         hasil.append("Nama Cowonya: "+namacowo);
         hasil.append("Nama Cewenya: "+namacewe);
         hasil.append("Huruf yang ditemukan sama: ");
         hasil.append(this.hrfygsama(kalimat1, kalimat2));
         int sama = this.hrfygsama(kalimat1, kalimat2).length();
         int persen = (sama*100)/(kalimat1.length()+kalimat2.length());
         hasil.append("Persentase Jodoh: "+persen+" %");
         display.setCurrent(hasil);
     }
     else if (c==finish) {
         display.setCurrent(pria);
     }
}
}
