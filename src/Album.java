/*
* @Authors: Luka Alhonen, Amos Weckström
* Denna klass representerar ett album. Albumet kan innehålla både subalbum
* och ljudfiler
*/

import java.util.ArrayList;
import java.util.*;

public class Album {
    private final int MAX_SUBALBUMS = 500; // Max antal subalbum
    private int numSubAlbums; // Håller reda på mängden subalbum
    private String name;
    private List<Album> SubAlbum = new ArrayList<Album>(); // Arraylist för att representera SubAlbum
    private List<SoundClip> LjudFiler = new ArrayList<SoundClip>(); // Arraylist för att representera LjudFiler

    // Simpel construktor
    public Album(String name){
        this.name = name;
    }

    // Simpel construktor med default namn
    public Album(){
        this.name = "New Album";
    }
    
    // Getters
    public String toString(){
        return name;
    }

    // Returnerar ljudfilen vid indexet
    public SoundClip getSoundClip(int index){
        if(LjudFiler.size() == 0){
            return null;
        }
        return LjudFiler.get(index);
    }

    // Returnerar den sista ljudfilen
    public SoundClip getSoundClip(){
        if(LjudFiler.size() == 0){
            return null;
        }
        return LjudFiler.get(LjudFiler.size() - 1);
    }

    // Returnerar subalbumet vid indexet
    public Album getSubAlbum(int index){
        if(SubAlbum.size() == 0){
            return null;
        }
        return SubAlbum.get(index);
    }

    // Returnerar det sista subalbumet
    public Album getSubAlbum(){
        if(SubAlbum.size() == 0){
            return null;
        }
        return SubAlbum.get(SubAlbum.size()-1);
    }

    // Setters
    // Lägger till en ljudfil, ingen gräns på mängden ljudfiler i album
    public void addSoundClip(SoundClip song){
        LjudFiler.add(song);
    }

    // Lägger till ett subalbum om det finns rum
    public void addSubAlbum(Album subalbum){
        if(numSubAlbums < MAX_SUBALBUMS) {
            SubAlbum.add(subalbum);
            numSubAlbums++;
        }
    }

    // Tar bort subalbumet vid indexet och returnerar det
    public Album removeSubAlbum(int index){
        if(SubAlbum.size() == 0){
            return null;
        }
        return SubAlbum.remove(index);
    }

    // Tar bort det sista subalbumet och returnerar det
    public Album removeSubAlbum(){
        if(SubAlbum.size() == 0){
            return null;
        }
        return SubAlbum.remove(SubAlbum.size() - 1);
    }

    // Tar bort ljudfilen vid indexet och returnerar den
    public SoundClip removeSoundClip(int index){
        if(LjudFiler.size() == 0){
            return null;
        }
        return LjudFiler.remove(index);
    }

    // Tar bort den sista ljudfilen och returnerar den
    public SoundClip removeSoundClip(){
        if(LjudFiler.size() == 0){
            return null;
        }
        return LjudFiler.remove(LjudFiler.size() - 1);
    }

    
}