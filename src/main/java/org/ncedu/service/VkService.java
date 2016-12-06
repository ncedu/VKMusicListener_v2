package org.ncedu.service;


import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.audio.AudioFull;
import org.ncedu.entity.MessageMusic;
import org.ncedu.entity.Music;

import java.io.IOException;
import java.util.List;

/**
 * Created by nick on 01.12.16.
 */
public interface VkService {
    public Music getAudio (String uid, String room_id, String link, String name, String author) throws IOException;
    public MessageMusic[] searchAudio (String uid, String query) throws ClientException, ApiException;
    public MessageMusic[] getAudioList (int uid) throws ClientException, ApiException;
    public MessageMusic[] generateArray (List<AudioFull> audioFulls);
}
