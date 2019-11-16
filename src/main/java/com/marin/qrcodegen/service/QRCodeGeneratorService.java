package com.marin.qrcodegen.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeGeneratorService {

    void generateQRCode(String url) throws IOException, WriterException;

}
