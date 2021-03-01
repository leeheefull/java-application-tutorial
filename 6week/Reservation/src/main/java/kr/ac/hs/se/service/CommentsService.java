package kr.ac.hs.se.service;

import kr.ac.hs.se.model.Dto.CommentDto;
import kr.ac.hs.se.model.response.ListAllResponse;
import kr.ac.hs.se.repository.CommentsRepository;
import kr.ac.hs.se.model.response.ListPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public ListAllResponse<CommentDto> getComments() {
        return new ListAllResponse<>(commentsRepository.selectComments());
    }

    public ListPageResponse<CommentDto> getComments(long productId) {
        List<CommentDto> CommentsByProductId = commentsRepository.selectComments(productId);
        return ListPageResponse.<CommentDto>builder()
                .totalCount(commentsRepository.selectComments().size())
                .itemCount(CommentsByProductId.size())
                .items(CommentsByProductId)
                .build();
    }

    public ListPageResponse<CommentDto> getComments(long productId, long pageSize, long page) {
        List<CommentDto> comments = commentsRepository.selectComments(productId, pageSize, page);
        return ListPageResponse.<CommentDto>builder()
                .totalCount(commentsRepository.selectComments(productId).size())
                .itemCount(comments.size())
                .items(comments)
                .build();
    }
}
