
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LibExtractor
{
    public static void main(String args[]) throws Exception
    {
        if(args.length <= 0)
        {
            System.err.println("apk file path not provided.\n USAGE : libextractor apkfile1  apkfile2 ...");
            return;
        }
        
        for(int i=0;i< args.length;i++){
        	
        System.out.println("\nParsing file : " + args[i]);

        	
        // create a buffer to improve copy performance later.
        byte[] buffer = new byte[2048];

        // open the .apk file stream
        InputStream theFile = new FileInputStream(args[i]);
        ZipInputStream stream = new ZipInputStream(theFile);

        try
        {

            // now iterate through each item in the stream. The get next
            // entry call will return a ZipEntry for each file in the
            // stream
            ZipEntry entry;
            int count = 0;
            
            while((entry = stream.getNextEntry())!=null)
            {
            	String filename = entry.getName();
                String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
 
                // set .so file extension
                String extn = "so";
                if (extn.equals(extension)) {
                	     
                    
                    String text = entry.getName();

                    //using regex match ArchType
                    String patternString = "\\b(" + "mips|x86|armeabi-v7a|armeabi" + ")\\b";
                    Pattern pattern = Pattern.compile(patternString);
                    Matcher matcher = pattern.matcher(text);

                    while (matcher.find()) {
                        count = count + 1;
                        String s = String.format("%d: /%s \t\t ArchType: %s ",count,
                                        entry.getName(), matcher.group(1));
                        System.out.println(s);
                    	}
              

                 }
                
            }
            System.out.println("Number of Libs: " + count);

        }
        finally 
        {
            // we must always close the  file streamer.
            stream.close();
        }
      }
   }
}
