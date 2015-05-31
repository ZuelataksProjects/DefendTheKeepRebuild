package com.defendthekeep.music;

import java.lang.Thread;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Sounds implements Runnable
{
    private static final int EXTERNAL_BUFFER_SIZE = 128000;

    private Thread t;
    public volatile boolean playing = true;
    private String audioFile;
    private SourceDataLine line;
    private AudioInputStream audioInputStream;

    public Sounds(String arg)
    {
        audioFile = arg;
        t = new Thread(this, arg + "_thread");
        t.start();
    }

 
    public void run()
    {

       try
       {
           audioInputStream = AudioSystem.getAudioInputStream(new File(audioFile));
       }
       catch (Exception e)
       {
           /*
         In case of an exception, we dump the exception
         including the stack trace to the console output.
         Then, we exit the program.
            */
           e.printStackTrace();
           System.exit(1);
       }

       AudioFormat audioFormat = audioInputStream.getFormat();
       System.out.println(audioFormat);
       
       DataLine.Info   info = new DataLine.Info(SourceDataLine.class,
               audioFormat);
       
        while(playing)
        {

            try
            {
                line = (SourceDataLine) AudioSystem.getLine(info);

                /*
              The line is there, but it is not yet ready to
              receive audio data. We have to open the line.
                 */
                line.open(audioFormat);
            }
            catch (LineUnavailableException e)
            {
                e.printStackTrace();
                System.exit(1);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }

            line.start();
            
            int nBytesRead = 1;
            byte[]  abData = new byte[EXTERNAL_BUFFER_SIZE];
            while ((nBytesRead != -1) && (playing))
            {
                try
                {
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0)
                {
                    @SuppressWarnings("unused")
					int nBytesWritten = line.write(abData, 0, nBytesRead);
                }
            }
        }  
    }
}
