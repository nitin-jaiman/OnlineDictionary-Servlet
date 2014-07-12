package org.nitin.jaiman;




import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class OnlineDictionary {
    private String query1;
	





private DefaultHttpClient httpclient;
OnlineDictionary(){

httpclient = new DefaultHttpClient();
}




public String executeQuery(String query1) throws IOException {
    String Full_Querry = "http://www.vocabulary.com/dictionary/"+query1;
HttpGet httpGet = new HttpGet(Full_Querry);
HttpResponse response;
response = this.httpclient.execute(httpGet);
HttpEntity entity = response.getEntity();
String getresult=slurp(entity.getContent(), 10000000);
if (entity != null) {
//System.out
//.println("entity " + slurp(entity.getContent(), 10000000));
System.out.println("entity "
+ response.getStatusLine().getStatusCode());

}
return getresult;
}

public static String slurp(final InputStream is, final int bufferSize)
{
 final char[] buffer = new char[bufferSize];
 final StringBuilder out = new StringBuilder();
 try {
   final Reader in = new InputStreamReader(is, "UTF-8");
   try {
     for (;;) {
       int rsz = in.read(buffer, 0, buffer.length);
       if (rsz < 0)
         break;
       out.append(buffer, 0, rsz);
     }
   }
   finally {
     in.close();
   }
 }
 catch (UnsupportedEncodingException ex) {
   /* ... */
 }
 catch (IOException ex) {
     /* ... */
 }
 return out.toString();
}

/**
* @param args
*/
}

