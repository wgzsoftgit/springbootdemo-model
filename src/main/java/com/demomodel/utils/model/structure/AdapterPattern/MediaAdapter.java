package com.demomodel.utils.model.structure.AdapterPattern;

import com.demomodel.utils.model.structure.AdapterPattern.interfaces.AdvancedMediaPlayer;
import com.demomodel.utils.model.structure.AdapterPattern.interfaces.MediaPlayer;
import com.demomodel.utils.model.structure.AdapterPattern.interfaces.Mp4Player;
import com.demomodel.utils.model.structure.AdapterPattern.interfaces.VlcPlayer;

public class MediaAdapter implements MediaPlayer {
 
   AdvancedMediaPlayer advancedMusicPlayer;
 
   public MediaAdapter(String audioType){
      if(audioType.equalsIgnoreCase("vlc") ){
         advancedMusicPlayer = new VlcPlayer();       
      } else if (audioType.equalsIgnoreCase("mp4")){
         advancedMusicPlayer = new Mp4Player();
      }  
   }
 
   @Override
   public void play(String audioType, String fileName) {
      if(audioType.equalsIgnoreCase("vlc")){
         advancedMusicPlayer.playVlc(fileName);
      }else if(audioType.equalsIgnoreCase("mp4")){
         advancedMusicPlayer.playMp4(fileName);
      }
   }
}