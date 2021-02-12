import java.text.*;
class Looper{
    public static void main (String[] args) {
        long count=0;
        while(true){
            try {
                System.out.println("Running since "+count +" seconds");
                Thread.sleep(5000);
                count=count+5;
                if(count%60==0){
                            // Get the Java runtime
                Runtime runtime = Runtime.getRuntime();
                // Calculate the used memory
                long memory = runtime.totalMemory() - runtime.freeMemory();
                long maxMemory = runtime.maxMemory();
                System.out.println("Used memory :  " + humanReadableByteCountSI(memory));
                System.out.println("Max memory : "+ humanReadableByteCountSI(maxMemory));
                }
            } catch (InterruptedException e) {
                //TODO: handle exception
                System.out.println("Interrupted "+e);
            }

        }
    }
    public static String humanReadableByteCountSI(long bytes) {
    if (-1000 < bytes && bytes < 1000) {
        return bytes + " B";
    }
    CharacterIterator ci = new StringCharacterIterator("kMGTPE");
    while (bytes <= -999_950 || bytes >= 999_950) {
        bytes /= 1000;
        ci.next();
    }
    return String.format("%.1f %cB", bytes / 1000.0, ci.current());
}
}