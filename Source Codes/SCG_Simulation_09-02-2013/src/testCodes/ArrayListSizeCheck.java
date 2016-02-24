/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCodes;

import java.util.ArrayList;

/**
 *
 * @author Sukrit
 */
public class ArrayListSizeCheck {

    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(Integer i = 1 ;i <=1000 ;i ++){
            System.out.println(a.size());
            a.add(i);
            
        }
    }
    
}
