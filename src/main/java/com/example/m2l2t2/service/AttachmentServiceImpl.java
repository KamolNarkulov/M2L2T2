package com.example.m2l2t2.service;

import com.example.m2l2t2.dto.Response;
import com.example.m2l2t2.entity.Attachment;
import com.example.m2l2t2.repository.AttachmentRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    final AttachmentRepository attachmentRepository;

    private static final String uploadDirectory = "src/main/resources/uploadDirectory";

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @SneakyThrows
    @Override
    public Response saveFiles(MultipartFile[] files, MultipartFile[] images) {
        boolean isSaved = false;
        if (files != null) {
            saveFiles(files);
            isSaved = true;
        }

        if (images != null) {
            saveFiles(images);
            isSaved = true;
        }

        if (isSaved)
            return new Response("SAVED", true);

        return new Response("FILE NOT FOUND", false);
    }


    @Override
    public List<Attachment> findAll() {
        return attachmentRepository.findAll();
    }

    @Override
    public Response saveFile(MultipartHttpServletRequest request) {
        boolean isSaved = false;

        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            saveFile(file);
            isSaved = true;
        }

        if (isSaved)
            return new Response("SAVED", true);

        return new Response("ERROR", false);
    }

    @SneakyThrows
    @Override
    public Response download(Integer id, HttpServletResponse response) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + attachment.getOriginalFileName() + "\"");
            response.setContentType(attachment.getContentType());

            FileInputStream fileInputStream = new FileInputStream(uploadDirectory + "/" + attachment.getName());

            FileCopyUtils.copy(fileInputStream, response.getOutputStream());
        }
        return new Response("ATTACHMENT NOT FOUND", false);
    }

    @SneakyThrows
    @Override
    public Response delete(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            File file = new File("src/main/resources/uploadDirectory");
            File[] files = file.listFiles();
            assert files != null;
            for (File file1 : files) {
                if (file1.isFile()) {
                    if (file1.getName().contains(optionalAttachment.get().getName())) {
                        Path fileToDeletePath = Paths.get("src/main/resources/uploadDirectory/" + file1.getName());
                        Files.delete(fileToDeletePath);
                        return new Response("FILE DELETED", true);
                    }
                }
            }
        }
        return new Response("NOT DELETED", false);
    }

    @SneakyThrows
    private void saveFiles(MultipartFile[] files) {
        for (MultipartFile file : files) {
            if (file != null) {
                saveFile(file);
            }
        }
    }

    @SneakyThrows
    private void saveFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        Attachment attachment = new Attachment();
        attachment.setOriginalFileName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());

        String[] split = Objects.requireNonNull(originalFilename).split("\\.");
        String name = UUID.randomUUID().toString() + "." + split[split.length - 1];
        attachment.setName(name);
        attachmentRepository.save(attachment);

        Path path = Paths.get(uploadDirectory + "/" + name);
        Files.copy(file.getInputStream(), path);
    }
}
