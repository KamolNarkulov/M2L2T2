package com.example.m2l2t2.controller;

import com.example.m2l2t2.dto.Response;
import com.example.m2l2t2.entity.Attachment;
import com.example.m2l2t2.service.AttachmentService;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @SneakyThrows
    @PostMapping("/upload")
    public HttpEntity<?> uploadFilesToSystem(@RequestParam("files") MultipartFile[] multipartFiles,
                                          @RequestParam("images") MultipartFile[] multipartImages) {
        Response response = attachmentService.saveFiles(multipartFiles, multipartImages);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @SneakyThrows
    @GetMapping
    public HttpEntity<?> getAttachments() {
        List<Attachment> attachmentList = attachmentService.findAll();
        return ResponseEntity.ok(attachmentList);
    }

    @SneakyThrows
    @PostMapping("/uploadSystem")
    public HttpEntity<?> uploadFileToFileSystem(MultipartHttpServletRequest request) {
        Response response = attachmentService.saveFile(request);
        return ResponseEntity.status(response.isStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @SneakyThrows
    @GetMapping("/download/{id}")
    public HttpEntity<?> getFileFromSystem(@PathVariable Integer id, HttpServletResponse response) {
        Response download = attachmentService.download(id, response);
        return ResponseEntity.status(download.isStatus() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(download);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteFileFromSystem(@PathVariable Integer id) {
        Response delete = attachmentService.delete(id);
        return ResponseEntity.status(delete.isStatus() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(delete);
    }




}
