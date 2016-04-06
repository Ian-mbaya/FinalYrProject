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
public class ValidateName {
    public static boolean name_validation(String email){
            boolean status=false;
        String email_pattern="[A-Z][a-zA-Z]*";
        Pattern pattern=Pattern.compile(email_pattern);
        Matcher matcher=pattern.matcher(email);
        if(matcher.matches()){
            status=true;
        }else{
            status=false;
        }
         return status;
    }
}
