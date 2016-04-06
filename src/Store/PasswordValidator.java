/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AnonymousHacker
 */
public class PasswordValidator {
    public static boolean pass_validation(String pass){
        boolean status;
        String ptn_reg="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        Pattern ptn= Pattern.compile(ptn_reg);
        Matcher mtc=ptn.matcher(pass);
        if(mtc.matches()){
            status=true;
        }else{
            status=false;
        }
        return status;
    }
}
