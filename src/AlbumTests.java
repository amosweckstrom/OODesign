import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

public class AlbumTests {
    Album rootAlbum = new Album("All soundclips");
    Album music = new Album("Very good music");
    Album nickelBack = new Album("Nickelback");
    Album aphexTwin = new Album("Aphex Twin");
    Album jamesAlbum = new Album("Richard D. James Album");
    SoundClip fingerBib = new SoundClip(new File("/home/luka/Music/test"));
    SoundClip four = new SoundClip(new File("/ome/luka/Music/test2"));

    public void setup(){
        rootAlbum.addSubAlbum(music);
        music.addSubAlbum(nickelBack);
        music.addSubAlbum(aphexTwin);
        aphexTwin.addSubAlbum(jamesAlbum);
        jamesAlbum.addSoundClip(fingerBib);
        jamesAlbum.addSoundClip(four);
    }

    @Test
    public void testAddSubAlbum(){
        setup();

        assertEquals(music, rootAlbum.getSubAlbum(0));
        assertEquals(nickelBack, music.getSubAlbum(0));
        assertEquals(aphexTwin, music.getSubAlbum(1));
        assertEquals(jamesAlbum, aphexTwin.getSubAlbum(0));
    }

    @Test
    public void testAddSoundClip(){
        setup();

        assertEquals(fingerBib, jamesAlbum.getSoundClip(0));
        assertEquals(four, jamesAlbum.getSoundClip(1));
    }

    @Test
    public void testRemoveSubAlbum(){
        setup();

        assertEquals(jamesAlbum, aphexTwin.removeSubAlbum());
        assertNotEquals(jamesAlbum, aphexTwin.getSubAlbum());
        assertEquals(aphexTwin, music.removeSubAlbum());
        assertNotEquals(aphexTwin, music.getSubAlbum());
        assertEquals(nickelBack, music.removeSubAlbum());
        assertNotEquals(nickelBack, music.getSubAlbum());
        assertEquals(music, rootAlbum.removeSubAlbum());
        assertNotEquals(music, rootAlbum.getSubAlbum());
    }

    @Test
    public void testRemoveSoundClip(){
        setup();

        assertEquals(four, jamesAlbum.removeSoundClip());
        assertNotEquals(four, jamesAlbum.getSoundClip());
        assertEquals(fingerBib, jamesAlbum.removeSoundClip());
        assertNotEquals(fingerBib, jamesAlbum.getSoundClip());
    }

    @Test
    public void testAddMaxSubAlbum(){
        for(int i = 0; i < 500; i++){
            rootAlbum.addSubAlbum(new Album());
        }
        rootAlbum.addSubAlbum(music);
        assertNotEquals(music, rootAlbum.getSubAlbum());
    }

    @Test
    public void testGetNumSubalbums(){
        setup();

        assertEquals(1, rootAlbum.getNumSubAlbums());
        assertEquals(2, music.getNumSubAlbums());
        assertEquals(1, aphexTwin.getNumSubAlbums());
    }
}
