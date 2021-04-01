import java.util.ArrayList;
import java.util.*;

public class Album {
    private Album parent;
    private String name;
    private List<Album> SubAlbum = new ArrayList<Album>();
    private List<SoundClip> LjudFiler = new ArrayList<SoundClip>();  

    public Album(String name, Album parent){
        this.name = name;
        this.parent = parent;
    }

    public Album(String name){
        this.name = name;
    }
    
    public String getAlbum(){
        return name;
    }

    public SoundClip getSoundClip(int index){
        return LjudFiler.get(index);
    }

    public Album getSubAlbum(int index){
        return SubAlbum.get(index);
    }

    public void addSoundClip(SoundClip song){
        LjudFiler.add(song);
    }

    public void addSubAlbum(Album subalbum){
        SubAlbum.add(subalbum);
    }

    public Album removeAlbum(int index){
        return SubAlbum.remove(index);
    }
    
    public SoundClip removeSoundClip(int index){
        return LjudFiler.remove(index);
    }

    
}