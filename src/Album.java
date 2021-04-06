/*
* @Authors: Luka Alhonen, Amos Weckström
* Denna klass representerar ett album. Albumet kan innehålla både subalbum
* och ljudfiler
*/

import java.util.ArrayList;
import java.util.*;

public class Album {
    private final int MAX_SUBALBUMS = 500;
    private int numSubAlbums;
    private Album parent;
    private String name;
    private List<Album> SubAlbum = new ArrayList<Album>();
    private List<SoundClip> LjudFiler = new ArrayList<SoundClip>();

    // Simpel construktor
    public Album(String name){
        this.name = name;
    }

    public Album(){
        this.name = "New Album";
    }
    
    // Getters
    public String toString(){
        return name;
    }

    public SoundClip getSoundClip(int index){
        return LjudFiler.get(index);
    }

    public SoundClip getSoundClip(){
        if(LjudFiler.size() == 0){
            return null;
        }

        return LjudFiler.get(LjudFiler.size() - 1);
    }

    // Returnerar subalbumet vid indexet
    public Album getSubAlbum(int index){ return SubAlbum.get(index); }

    // Returnerar det sista subalbumet
    public Album getSubAlbum(){
        if(SubAlbum.size() == 0){
            return null;
        }
        return SubAlbum.get(SubAlbum.size()-1);
    }

    // Setters
    public void addSoundClip(SoundClip song){
        LjudFiler.add(song);
    }

    public void addSubAlbum(Album subalbum){
        if(numSubAlbums < MAX_SUBALBUMS) {
            SubAlbum.add(subalbum);
            numSubAlbums++;
        }
    }

    public Album removeSubAlbum(int index){
        return SubAlbum.remove(index);
    }

    public Album removeSubAlbum(){
        if(SubAlbum.size() == 0){
            return null;
        }
        return SubAlbum.remove(SubAlbum.size() - 1);
    }
    
    public SoundClip removeSoundClip(int index){
        return LjudFiler.remove(index);
    }

    public SoundClip removeSoundClip(){
        if(LjudFiler.size() == 0){
            return null;
        }

        return LjudFiler.remove(LjudFiler.size() - 1);
    }

    
}