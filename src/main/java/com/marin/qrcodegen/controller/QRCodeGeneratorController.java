package com.marin.qrcodegen.controller;

import com.google.zxing.WriterException;
import com.marin.qrcodegen.model.request.GenerateQRCRequestModel;
import com.marin.qrcodegen.service.QRCodeGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class QRCodeGeneratorController {

    final QRCodeGeneratorService qrcodegen;

    public QRCodeGeneratorController(QRCodeGeneratorService qrcodegen) {
        this.qrcodegen = qrcodegen;
    }

    @PostMapping("/qrc")
    public String generateQRC(@RequestBody GenerateQRCRequestModel requestModel) throws IOException, WriterException {

        qrcodegen.generateQRCode(requestModel.getUrl());

        return "Your QR code has been generated. \nPlease use http://localhost:8080/qrc to see the image.";
    }

    @GetMapping("/qrc")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {

        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");

        return new RedirectView("file:///C:/Users/marin/IdeaProjects/QRCodeGeneratorWS/QRCode.png");
    }

}
