package kr.ac.hs.se.controller;

import kr.ac.hs.se.model.Dto.CommentDto;
import kr.ac.hs.se.model.response.ListAllResponse;
import kr.ac.hs.se.model.response.ListPageResponse;
import kr.ac.hs.se.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentsApiController {

    private final CommentsService commentsService;

    @GetMapping
    public ListAllResponse<CommentDto> getComments() {
        return commentsService.getComments();
    }

    @GetMapping("/product/{productId}")
    public ListPageResponse<CommentDto> getComments(@PathVariable(name = "productId") long productId,
                                                    @RequestParam(value = "pagesize", required = false, defaultValue = "-1") long pageSize,
                                                    @RequestParam(value = "pageno", required = false, defaultValue = "-1") long pageNo) {
        if (pageSize == -1 || pageNo == -1) {
            return commentsService.getComments(productId);
        } else {
            return commentsService.getComments(productId, pageSize, pageNo);
        }
    }
}
