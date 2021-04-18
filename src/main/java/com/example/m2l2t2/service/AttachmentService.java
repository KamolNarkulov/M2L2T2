package com.example.m2l2t2.service;

import com.example.m2l2t2.dto.Response;
import com.example.m2l2t2.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public interface AttachmentService {

    Response saveFiles(MultipartFile[] files, MultipartFile[] images);

    List<Attachment> findAll();

    Response saveFile(MultipartHttpServletRequest request);

    Response download(Integer id, HttpServletResponse response);

    Response delete(Integer id);
}
