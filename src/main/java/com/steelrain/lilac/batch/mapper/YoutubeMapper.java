package com.steelrain.lilac.batch.mapper;

import com.steelrain.lilac.batch.datamodel.YoutubeChannelDTO;
import com.steelrain.lilac.batch.datamodel.YoutubeCommentDTO;
import com.steelrain.lilac.batch.datamodel.YoutubePlayListDTO;
import com.steelrain.lilac.batch.datamodel.YoutubeVideoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YoutubeMapper {

    int insertYoutubePlaylist(List<YoutubePlayListDTO> dto);
    int insertYoutubeVideoList(List<YoutubeVideoDTO> dto);
    int insertYoutubeChannelInfo(YoutubeChannelDTO dto);

    int insertYoutubeCommentList(List<YoutubeCommentDTO> dto);
}
