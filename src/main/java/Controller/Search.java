/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Named("searchBean")
public class Search implements Serializable{
private static final long serialVersionUID = 2729758432756108274L;
    public String getWord() {
        return word;
    }

    public Search(String word) {
        this.word = word;
    }

    public void setWord(String word) {
        this.word = word;
    }
   private String word;
  public void send(){
      
  }
}
