/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;
/**
 *
 * @author Robinhood
 */
public class ID3TagExample {
    
    public static void main(String[] args) {
        try {
            // Specify the path to your MP3 file
            File file = new File("C:\\Users\\Robinhood\\Downloads\\heredity\\songs.mp3");
            
            // Read ID3 tags
            AudioFile audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();

            // Retrieve existing ID3 tag information
            String title = tag.getFirst(FieldKey.TITLE);
            String artist = tag.getFirst(FieldKey.ARTIST);
            String album = tag.getFirst(FieldKey.ALBUM);
            String year = tag.getFirst(FieldKey.YEAR);
            String genre = tag.getFirst(FieldKey.GENRE);
            String comment = tag.getFirst(FieldKey.COMMENT);

            System.out.println("Title: " + title);
            System.out.println("Artist: " + artist);
            System.out.println("Album: " + album);
            System.out.println("Year: " + year);
            System.out.println("Genre: " + genre);
            System.out.println("Comment: " + comment);

            // Write new ID3 tag information
            tag.setField(FieldKey.TITLE, "New Title");
            tag.setField(FieldKey.ARTIST, "New Artist");
            tag.setField(FieldKey.ALBUM, "New Album");
            tag.setField(FieldKey.YEAR, "2023");
            tag.setField(FieldKey.GENRE, "New Genre");
            tag.setField(FieldKey.COMMENT, "New Comment");

            // Commit changes to the audio file
            audioFile.commit();
            System.out.println("ID3 tags updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
