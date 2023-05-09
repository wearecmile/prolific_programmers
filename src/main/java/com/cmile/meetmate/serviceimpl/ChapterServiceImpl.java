package com.cmile.meetmate.serviceimpl;

import com.cmile.meetmate.entity.Chapter;
import com.cmile.meetmate.model.JsonResponse;
import com.cmile.meetmate.repository.ChapterRepository;
import com.cmile.meetmate.service.ChapterService;
import com.cmile.meetmate.utils.constant.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterRepository chapterRepository;

    @Override
    public ResponseEntity<Object> findAll() {
        List<Chapter> chapterList=chapterRepository.findAll();
        if (!chapterList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_CHAPTER_FETCHED)
                            .status(HttpStatus.OK)
                            .data(chapterList)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> findById(Long chapterId) {
        Optional<Chapter> chapterOptional = chapterRepository.findById(chapterId);
        if (chapterOptional.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_SELECTED_CHAPTER_FETCHED +chapterId)
                            .status(HttpStatus.OK)
                            .data(chapterOptional.get())
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> save(Chapter chapter) {
        Chapter savedChapter = chapterRepository.save(chapter);
        if (savedChapter != null)
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_CHAPTER_CREATED)
                            .status(HttpStatus.OK)
                            .data(savedChapter)
                            .build());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> update(Chapter chapter) {
        Optional<Chapter> optionalChapter=chapterRepository.findById(chapter.getChapterId());
        if (optionalChapter.isPresent()) {
            Chapter updateChapter=optionalChapter.get();
            updateChapter.setChapterName(chapter.getChapterName());
            updateChapter.setChapterUpdatedDateTime(chapter.getChapterUpdatedDateTime());
            updateChapter=chapterRepository.save(updateChapter);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_CHAPTER_UPDATED)
                            .status(HttpStatus.OK)
                            .data(optionalChapter)
                            .build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @Override
    public ResponseEntity<Object> delete(Long chapterId) {
        if (chapterRepository.findById(chapterId).isPresent()) {
            chapterRepository.deleteById(chapterId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    JsonResponse.builder()
                            .statusCode(HttpStatus.OK.value())
                            .message(StringConstant.REQUEST_SUCCESS_MESSAGE_CHAPTER_DELETED)
                            .status(HttpStatus.OK)
                            .build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                JsonResponse.builder()
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(StringConstant.REQUEST_FAILURE_MESSAGE_BAD_REQUEST)
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }
}
