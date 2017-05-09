/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Store;

/**
 *
 * @author AnonymousHacker
 */
/* Make sure the downloaded jar file is in the classpath or has been added to 
       referenced libraries if you are using an SDK like eclipse or netbeans*/
    import org.json.*;
    import java.util.HashMap;
public class SMS_Sending {
        
        public static void main(String[] args_)
        {
             // Specify your login credentials
             String username = "sheldon";
             String apiKey   = "a96461493f41f452edb727ae33e8fca45fc983a331ce2ea452451f2c3e68976c";
        
             // Specify the numbers that you want to send to in a comma-separated list
             // Please ensure you include the country code (+254 for Kenya in this case)
             String recipients = "+254707217070";
        
             // And of course we want our recipients to know what we really do
             String message = "beb,inawork";
        
            // Create a new instance of our awesome gateway class
             AfricasTalkingGateway gateway  = new AfricasTalkingGateway(username, apiKey);
        
             // Thats it, hit send and we'll take care of the rest. Any errors will
             // be captured in the Exception class below
            try {
                JSONArray results = gateway.sendMessage(recipients, message);
                
                for( int i = 0; i < results.length(); ++i ) {
                      JSONObject result = results.getJSONObject(i);
                      System.out.print(result.getString("status") + ","); // status is either "Success" or "error message"
                      System.out.print(result.getString("number") + ",");
                      System.out.print(result.getString("messageId") + ",");
                      System.out.println(result.getString("cost"));
            }
           }
           
           catch (Exception e) {
            System.out.println("Encountered an error while sending " + e.getMessage());
            }
        
       }
    }
