package com.steelrain.lilac.batch.youtube;

import com.steelrain.lilac.batch.datamodel.YoutubeChannelDTO;
import com.steelrain.lilac.batch.datamodel.YoutubeCommentDTO;
import com.steelrain.lilac.batch.datamodel.YoutubePlayListDTO;
import com.steelrain.lilac.batch.datamodel.YoutubeVideoDTO;
import com.steelrain.lilac.batch.exception.LilacYoutubeAPIException;

import java.util.List;

public interface IYoutubeClient {
    //SearchListResponse getYoutubePlayList(String keyword);

    List<YoutubePlayListDTO> getYoutubePlayListDTO(String keyword);
    //PlaylistItemListResponse getVideoListByPlayListId(String playListId);
    List<YoutubeVideoDTO> getVideoDTOListByPlayListId(String playListId);

    List<YoutubeCommentDTO> getCommentList(String videoId) throws LilacYoutubeAPIException;
    YoutubeChannelDTO getChannelInfo(String channelId);
}
