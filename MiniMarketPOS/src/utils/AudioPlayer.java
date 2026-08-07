/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javazoom.jl.player.Player;
import java.io.InputStream;
/**
 *
 * @author Rifky
 */
public class AudioPlayer {
   private Player player;
    private Thread audioThread;

    public void playBGM(String filename) {
        audioThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // PASTIKAN MEMAKAI ADANYA STRUKTUR PATH DENGAN LEBIH AMAN:
                    InputStream is = getClass().getResourceAsStream("/audio/" + filename);
                    
                    if (is == null) {
                        // Jika tidak ketemu di /audio/, coba cari dari root:
                        is = getClass().getClassLoader().getResourceAsStream("audio/" + filename);
                    }

                    if (is != null) {
                        player = new Player(is);
                        player.play();
                    } else {
                        System.err.println("ERROR: File audio tidak ditemukan di path /audio/" + filename);
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("Error saat memutar BGM: " + e.getMessage());
                    break;
                }
            }
        });
        audioThread.start();
    }

    public void stopBGM() {
        if (player != null) {
            player.close();
        }
        if (audioThread != null) {
            audioThread.interrupt();
        }
    }

    // Method untuk memutar Efek Suara (SFX) Sekali Jalan (Beep/Ching)
    public static void playSFX(String filename) {
        new Thread(() -> {
            try {
                InputStream is = AudioPlayer.class.getResourceAsStream("/audio/" + filename);
                if (is != null) {
                    Player sfxPlayer = new Player(is);
                    sfxPlayer.play();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
