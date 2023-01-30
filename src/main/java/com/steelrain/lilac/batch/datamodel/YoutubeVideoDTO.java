package com.steelrain.lilac.batch.datamodel;

import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.Video;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
public class YoutubeVideoDTO {
    private Long id;
    private Long channelId;
    private Long youtubePlaylistId; // 여기까지는 FK

    private String videoId;
    private String title;
    private String description;
    private Timestamp publishDate;
    private Timestamp regDate; // db에 insert 한 날짜, DB 자동입력된다.
    private String thumbnailMedium;
    private String thumbnailHigh;
    private Long viewCount; // 조회수는 Video api를 따로 호출해야 가져올 수 있다
    private Integer searchCount;
    private String playlistId;
    private Long likeCount; // 좋아요는 Video api를 따로 호출해야 가져올 수 있다
    private Long favoriteCount;
    private Long commentCount;
    private String duration;
    private Float score;
    private Float magnitude;

    private List<YoutubeCommentDTO> comments;

    // 영상정보의 값이 일정하게 넘어오지 않는다. 때때로 속성값이 있거나 없거나(null) 일정하게 넘어오지 않는다.
    // 유튜브 영상의 상세정보를 사용하지 않는 버전
    public static YoutubeVideoDTO convertYoutubeVideoDTO(PlaylistItem item){

        YoutubeVideoDTO dto = new YoutubeVideoDTO();
        dto.setVideoId(item.getContentDetails().getVideoId());
        dto.setTitle(item.getSnippet().getTitle());
        dto.setPlaylistId(item.getSnippet().getPlaylistId());
        dto.setPublishDate(new Timestamp(item.getContentDetails().getVideoPublishedAt().getValue()));
        dto.setThumbnailMedium(item.getSnippet().getThumbnails().getMedium().getUrl());
        dto.setThumbnailHigh(item.getSnippet().getThumbnails().getHigh().getUrl());

        // 숫자형필드에는 정보가 없음을 표시하기 위해 0 대신 -1을 세팅한다
        dto.setViewCount(-1L);
        dto.setDescription(item.getSnippet().getDescription());
        dto.setLikeCount(-1L);
        dto.setCommentCount(-1L);
        dto.setDuration(null);

        return dto;
    }

    // 유튜브 영상의 상세정보를 사용하는 버전
    /*public static YoutubeVideoDTO convertYoutubeVideoDTO(PlaylistItem item, Video videoInfo){
        YoutubeVideoDTO dto = new YoutubeVideoDTO();
        dto.setVideoId(item.getContentDetails().getVideoId());
        dto.setTitle(item.getSnippet().getTitle());
        dto.setPlaylistId(item.getSnippet().getPlaylistId());
        dto.setPublishDate(new Timestamp(item.getContentDetails().getVideoPublishedAt().getValue()));
        dto.setThumbnailMedium(item.getSnippet().getThumbnails().getMedium().getUrl());
        dto.setThumbnailHigh(item.getSnippet().getThumbnails().getHigh().getUrl());

        dto.setViewCount(videoInfo.getStatistics().getViewCount() == null ? 0 : videoInfo.getStatistics().getViewCount().longValue());
        dto.setDescription(videoInfo.getSnippet().getDescription());
        dto.setLikeCount(videoInfo.getStatistics().getLikeCount() == null ? 0 : videoInfo.getStatistics().getLikeCount().longValue());
        dto.setCommentCount( videoInfo.getStatistics().getCommentCount() == null && videoInfo.getStatistics().getCommentCount().longValue() == 0 ? 0 : videoInfo.getStatistics().getCommentCount().longValue());
        dto.setDuration(videoInfo.getContentDetails().getDuration());

        return dto;
    }*/
}
